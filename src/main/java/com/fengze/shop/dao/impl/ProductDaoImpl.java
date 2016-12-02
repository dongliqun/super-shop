package com.fengze.shop.dao.impl;

import com.fengze.shop.dao.ProductDao;
import com.fengze.shop.domain.Page;
import com.fengze.shop.domain.PicDo;
import com.fengze.shop.domain.ProDetailDo;
import com.fengze.shop.domain.ProductDo;
import com.fengze.shop.utils.JdbcUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangls on 2016/10/31 0031.
 */
@Slf4j
public class ProductDaoImpl implements ProductDao {

    private Connection conn;

    public ProductDaoImpl(){
        this.conn = JdbcUtils.getContainer().get();//线程共享对象获取连接
    }

    @Override
    public List<ProductDo> queryMenuProduct(Integer menuId) {

        try {
            QueryRunner runner = new QueryRunner();
            String sql = "SELECT c.pic_uri, p.pro_now_price, p.pro_name, p.pro_id FROM tb_product p, tb_prod_pic c WHERE p.pro_pic_id=c.pic_id AND p.state='1' AND c.state='1' AND p.pro_id IN (SELECT type_name FROM tb_prod_type t WHERE t.state='1' AND t.type_p_id=?)";
            Object[] params = {menuId};
            ResultSetHandler<List<ProductDo>> rsh = new BeanListHandler<ProductDo>(ProductDo.class) {

                @Override
                public List<ProductDo> handle(ResultSet rs) throws SQLException {
                    List<ProductDo> ls = new LinkedList<ProductDo>();
                    while (rs.next()){
                        ProductDo pro = new ProductDo();

                        pro.setId(rs.getInt("pro_id"));
                        pro.setProPicUri(rs.getString("pic_uri"));
                        pro.setProNowPrice(rs.getDouble("pro_now_price"));
                        pro.setProName(rs.getString("pro_name"));
                        pro.setProDesc("加入购物车");

                        ls.add(pro);
                    }

                    return ls;
                }
            };
            log.info("ProductDaoImpl-->queryMenuProduct:sql-->{}", sql);
            log.info("参数：{}", menuId);
            return runner.query(conn, sql, rsh, params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Page<ProductDo> queryProductList(Page<ProductDo> page) {

        try {
            ProductDo proDo = page.getList().get(0);

            QueryRunner runner = new QueryRunner();
            String sql = "SELECT t.pro_id,t.pro_name,t.pro_now_price, p.pic_uri FROM tb_product t LEFT JOIN tb_prod_pic p ON t.pro_pic_id=p.pic_id WHERE t.state=1 AND FIND_IN_SET(?,t.pro_type_id) LIMIT ?,?";
            Object[] params = {proDo.getProTypeId(), page.getStartIndex() ,page.getPageSize()};
            ResultSetHandler<List<ProductDo>> rsh = new BeanListHandler<ProductDo>(ProductDo.class) {

                @Override
                public List<ProductDo> handle(ResultSet rs) throws SQLException {
                    List<ProductDo> ls = new LinkedList<ProductDo>();
                    while (rs.next()){
                        ProductDo pro = new ProductDo();

                        pro.setId(rs.getInt("pro_id"));
                        pro.setProPicUri(rs.getString("pic_uri"));
                        pro.setProNowPrice(rs.getDouble("pro_now_price"));
                        pro.setProName(rs.getString("pro_name"));
                        pro.setProDesc("加入购物车");

                        ls.add(pro);
                    }

                    return ls;
                }
            };
            log.info("ProductDaoImpl-->queryProductList:sql-->{}", sql);
            log.info("参数：{}", proDo.getProTypeId());
            List<ProductDo> ls = runner.query(conn, sql, rsh, params);
            page.setList(ls);
            return page;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Integer queryProListConunt(ProductDo proDo) {

        try {
            QueryRunner runner = new QueryRunner();
            String sql = "SELECT count(1) num FROM tb_product t LEFT JOIN tb_prod_pic p ON t.pro_pic_id=p.pic_id WHERE t.state=1 AND FIND_IN_SET(?,t.pro_type_id)";
            Object[] params = {proDo.getProTypeId()};
            ResultSetHandler<Integer> rsh = new BeanHandler<Integer>(Integer.class) {

                @Override
                public Integer handle(ResultSet rs) throws SQLException {
                    Integer res = 0;
                    while (rs.next()){
                        res = rs.getInt("num");
                    }
                    return res;
                }
            };
            log.info("ProductDaoImpl-->queryProListCount:sql-->{}", sql);
            log.info("参数：{}", proDo.getProTypeId());
            return runner.query(conn, sql, rsh, params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Boolean addProduct(ProductDo pro) {
        try {
            QueryRunner runner = new QueryRunner();
            String sql = "INSERT INTO tb_product (pro_name, pro_real_price, pro_now_price, is_stock, pro_desc, pro_size, pro_color, pro_score, pro_type_id, pro_pic_id, state, create_by, create_date, update_by, update_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?, ?, '1', ?, NOW(), ?, NOW())";
            Object params[] = {pro.getProName(), pro.getProRealPrice(), pro.getProNowPrice(),
                    pro.getIsStock(), pro.getProDesc(), pro.getProSize(), pro.getProColor(),
                    pro.getProScore(), pro.getProTypeId(), pro.getProPicId(),
                    pro.getCreateBy(), pro.getUpdateBy()};

            log.info("ProductDaoImpl-->addProduct:sql-->{}", sql);
            log.info("参数：{},{},{},{},{},{},{},{},{},{},{},{}",
                    pro.getProName(), pro.getProRealPrice(), pro.getProNowPrice(),
                    pro.getIsStock(), pro.getProDesc(), pro.getProSize(), pro.getProColor(),
                    pro.getProScore(), pro.getProTypeId(), pro.getProPicId(),
                    pro.getCreateBy(), pro.getUpdateBy());
            return runner.update(conn, sql, params) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Boolean addProDetail(ProDetailDo detDo) {
        try {
            QueryRunner runner = new QueryRunner();
            String sql = "INSERT INTO tb_prod_detail (prod_id, det_length, det_height, det_width, det_mate, det_Addr, det_date, det_desc, state, create_by, create_date, update_by, update_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, '1', ?, NOW(), ?, NOW())";
            Object params[] = {detDo.getProId(), detDo.getDetLength(), detDo.getDetHeight(),
                    detDo.getDetWidth(), detDo.getDetMate(), detDo.getDetAddr(), detDo.getDetDate(),
                    detDo.getDetDesc(), detDo.getCreateBy(), detDo.getUpdateBy()};

            log.info("ProductDaoImpl-->addProDetail:sql-->{}", sql);
            log.info("参数：{},{},{},{},{},{},{},{},{},{},{},{}",
                    detDo.getProId(), detDo.getDetLength(), detDo.getDetHeight(),
                    detDo.getDetWidth(), detDo.getDetMate(), detDo.getDetAddr(), detDo.getDetDate(),
                    detDo.getDetDesc(), detDo.getCreateBy(), detDo.getUpdateBy());
            return runner.update(conn, sql, params) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public ProductDo queryProByName(ProductDo productDo) {
        try {
            String sql = "SELECT pro_id FROM tb_product WHERE pro_name=?";
            QueryRunner runner = new QueryRunner();
            Object[] params = {productDo.getProName()};
            ResultSetHandler<ProductDo> rsh = new ResultSetHandler<ProductDo>() {
                @Override
                public ProductDo handle(ResultSet rs) throws SQLException {
                    if (!rs.next()) return null;
                    ProductDo pro = new ProductDo();
                    pro.setId(rs.getInt("pro_id"));

                    return pro;
                }
            };
            log.info("ProductDaoImpl-->queryProByName:sql-->{}", sql);
            log.info("参数：{}", productDo.getProName());
            return runner.query(conn, sql, rsh, params);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Boolean addPicInfo(List<PicDo> ls) {
        try {
            String sql = "INSERT INTO tb_prod_pic (pro_id, pic_uri, is_order, state, create_by, create_date, update_by, update_date) VALUES (?, ?, ?, '1', ?, NOW(), ?, NOW())";
            QueryRunner query = new QueryRunner();
            Object[][] params = new Object[ls.size()][];

            for (int i = 0; i < ls.size() ; i++) {
                PicDo pic = ls.get(i);
                params[i]= new Object[5];
                params[i][0] = pic.getProId();
                params[i][1] = pic.getPicUri();
                params[i][2] = pic.getIsOrder();
                params[i][3] = pic.getCreateBy();
                params[i][4] = pic.getUpdateBy();
            }

            int[] isi = query.batch(conn, sql, params);
            log.info("ProductDaoImpl-->addPicInfo:sql-->{}", sql);
            return Boolean.TRUE;
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public PicDo queryPicByPic(ProductDo productDo) {
        try {
            String sql = "SELECT pic_id FROM tb_prod_pic WHERE pro_id=? ORDER BY is_order LIMIT 1";
            QueryRunner runner = new QueryRunner();
            Object[] params = {productDo.getId()};
            ResultSetHandler<PicDo> rsh = new ResultSetHandler<PicDo>() {
                @Override
                public PicDo handle(ResultSet rs) throws SQLException {
                    if (!rs.next()) return null;
                    PicDo pic = new PicDo();
                    pic.setId(rs.getInt("pic_id"));

                    return pic;
                }
            };
            log.info("ProductDaoImpl-->queryPicByPic:sql-->{}", sql);
            log.info("参数：{}", productDo.getId());
            return runner.query(conn, sql, rsh, params);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Boolean updatePro(ProductDo productDo) {
        try {
            String sql = "UPDATE tb_product SET pro_pic_id=? WHERE pro_name=?";
            QueryRunner runner = new QueryRunner();
            Object[] params = {productDo.getProPicId(), productDo.getProName()};
            log.info("ProductDaoImpl-->queryPicByPic:sql-->{}", sql);
            log.info("参数：{},{}", productDo.getProPicId(), productDo.getProName());
            return runner.update(conn, sql, params) > 0;
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public ProductDo queryProductById(String proId) {
        try {
            String sql = "SELECT t.pro_id,t.pro_name,t.pro_real_price,t.pro_now_price,t.is_stock,t.pro_color,t.pro_size,t.pro_desc,t.pro_pic_id,t.pro_pic_uri,t.pro_score,t.pro_type_id," +
                    "d.det_addr,d.det_date,d.det_desc,d.det_length,d.det_height,d.det_width,d.det_mate FROM tb_product t LEFT JOIN tb_prod_detail d ON t.pro_id=d.prod_id WHERE t.pro_id=? AND t.state='1' AND t.state='1'";
            QueryRunner runner = new QueryRunner();
            Object[] params = {proId};
            ResultSetHandler<ProductDo> rsh = new ResultSetHandler<ProductDo>() {
                @Override
                public ProductDo handle(ResultSet rs) throws SQLException {
                    if (!rs.next()) return null;
                    ProductDo pro = new ProductDo();

                    pro.setId(rs.getInt("pro_id"));
                    pro.setProName(rs.getString("pro_name"));
                    pro.setProRealPrice(rs.getDouble("pro_real_price"));
                    pro.setProNowPrice(rs.getDouble("pro_now_price"));
                    pro.setIsStock(rs.getString("is_stock"));
                    pro.setProColor(rs.getString("pro_color"));
                    pro.setProSize(rs.getString("pro_size"));
                    pro.setProDesc(rs.getString("pro_desc"));
                    pro.setProPicId(rs.getInt("pro_pic_id"));
                    pro.setProPicUri(rs.getString("pro_pic_uri"));
                    pro.setProScore(rs.getDouble("pro_score"));
                    pro.setProTypeId(rs.getString("pro_type_id"));

                    ProDetailDo detDo = new ProDetailDo();

                    detDo.setProId(rs.getInt("pro_id"));
                    detDo.setDetAddr(rs.getString("det_addr"));
                    detDo.setDetDate(rs.getString("det_date"));
                    detDo.setDetDesc(rs.getString("det_desc"));
                    detDo.setDetLength(rs.getString("det_length"));
                    detDo.setDetHeight(rs.getString("det_height"));
                    detDo.setDetWidth(rs.getString("det_width"));
                    detDo.setDetMate(rs.getString("det_mate"));

                    pro.setProDetailDo(detDo);

                    return pro;
                }
            };
            log.info("ProductDaoImpl-->queryProductById:sql-->{}", sql);
            log.info("参数：{}", proId);
            return runner.query(conn, sql, rsh, params);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public List<PicDo> queryPicList(ProductDo proDo) {
        try {
            String sql = "SELECT t.pic_id,t.pro_id,t.pic_uri,t.is_order FROM tb_prod_pic t WHERE t.state='1' AND t.pro_id=? ORDER BY t.is_order";
            QueryRunner runner = new QueryRunner();
            Object[] params = {proDo.getId()};
            ResultSetHandler<List<PicDo>> rsh = new BeanListHandler<PicDo>(PicDo.class) {
                @Override
                public List<PicDo> handle(ResultSet rs) throws SQLException {
                    List<PicDo> ls = new LinkedList<PicDo>();
                    while (rs.next()) {
                        PicDo pic = new PicDo();

                        pic.setId(rs.getInt("pic_id"));
                        pic.setProId(rs.getInt("pro_id"));
                        pic.setPicUri(rs.getString("pic_uri"));
                        pic.setIsOrder(rs.getString("is_order"));

                        ls.add(pic);
                    }

                    return ls;
                }
            };
            log.info("ProductDaoImpl-->queryPicList:sql-->{}", sql);
            log.info("参数：{}", proDo.getId());
            return runner.query(conn, sql, rsh, params);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
