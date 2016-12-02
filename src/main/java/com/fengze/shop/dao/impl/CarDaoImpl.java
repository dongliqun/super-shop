package com.fengze.shop.dao.impl;

import com.fengze.shop.dao.CarDao;
import com.fengze.shop.domain.CarDo;
import com.fengze.shop.domain.ProductDo;
import com.fengze.shop.domain.UserDo;
import com.fengze.shop.utils.JdbcUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangls on 2016/11/3 0003.
 */
@Slf4j
public class CarDaoImpl implements CarDao {

    @Override
    public Boolean addCarInfo(CarDo carDo) {

        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "INSERT INTO tb_prod_car(user_id,prod_id,pro_size,pro_color,pro_num,pro_price,tal_price,state,create_by,create_date,update_by,update_date) VALUES(?, ?, ?, ?, ?, ?, ?,'1', ?,NOW(), ?,NOW())";
            Object params[] = {carDo.getUserId(), carDo.getProdId(), carDo.getProSize(),
                    carDo.getProColor(), carDo.getProNum(), carDo.getProPrice(), carDo.getTalPrice(),
                    carDo.getCreateBy(), carDo.getUpdateBy()};
            log.info("CarDaoImpl-->addCarInfo:sql-->{}", sql);
            log.info("参数：{},{},{},{},{},{},{},{},{}", carDo.getUserId(), carDo.getProdId(), carDo.getProSize(),
                    carDo.getProColor(), carDo.getProNum(), carDo.getProPrice(), carDo.getTalPrice(),
                    carDo.getCreateBy(), carDo.getUpdateBy());
            return runner.update(sql, params) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public List<CarDo> queryCarInfo(UserDo user) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "SELECT t.car_id,t.user_id,t.prod_id,t.pro_size,t.pro_color,t.pro_num,t.pro_price,t.tal_price,t.update_date,t.create_by,t.update_by,p.pro_name,p.is_stock,p.pro_desc,p.pro_type_id,p.pro_pic_uri,p.pro_id FROM tb_prod_car t LEFT JOIN tb_product p ON t.prod_id=p.pro_id WHERE t.state='1' AND p.state='1' AND t.user_id=?";
            Object[] params = {user.getId()};
            ResultSetHandler<List<CarDo>> rsh = new BeanListHandler<CarDo>(CarDo.class) {
                @Override
                public List<CarDo> handle(ResultSet rs) throws SQLException {
                    List<CarDo> ls = new LinkedList<CarDo>();
                    while (rs.next()) {
                        CarDo car = new CarDo();

                        car.setId(rs.getInt("car_id"));
                        car.setProdId(rs.getInt("prod_id"));
                        car.setUserId(rs.getInt("user_id"));
                        car.setProSize(rs.getString("pro_size"));
                        car.setProColor(rs.getString("pro_color"));
                        car.setProNum(rs.getInt("pro_num"));
                        car.setProPrice(rs.getDouble("pro_price"));
                        car.setTalPrice(rs.getDouble("tal_price"));
                        car.setUpdateDate(rs.getString("update_date"));
                        car.setCreateBy(rs.getString("create_by"));
                        car.setUpdateBy(rs.getString("update_by"));

                        ProductDo pro = new ProductDo();
                        pro.setId(Integer.valueOf(rs.getString("pro_id")));
                        pro.setProName(rs.getString("pro_name"));
                        pro.setIsStock(rs.getString("is_stock"));
                        pro.setProDesc(rs.getString("pro_desc"));
                        pro.setProTypeId(rs.getString("pro_type_id"));
                        pro.setProPicUri(rs.getString("pro_pic_uri"));

                        car.setPro(pro);
                        ls.add(car);
                    }

                    return ls;
                }
            };

            log.info("CarDaoImpl-->queryCarInfo:sql-->{}", sql);
            log.info("参数：{}", user.getId());
            return runner.query(sql, rsh, params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Integer queryCarCount(UserDo user) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "SELECT COUNT(1) num FROM tb_prod_car t WHERE t.state='1' AND t.user_id=?";
            Object[] params = {user.getId()};
            ResultSetHandler<Integer> rsh = new BeanHandler<Integer>(Integer.class) {

                @Override
                public Integer handle(ResultSet rs) throws SQLException {
                    Integer res = 0;
                    while (rs.next()) {
                        res = rs.getInt("num");
                    }
                    return res;
                }
            };
            log.info("CarDaoImpl-->queryCarInfo:sql-->{}", sql);
            log.info("参数：{}", user.getId());
            return runner.query(sql, rsh, params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Integer queryCarByPro(CarDo carDo) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "  SELECT t.car_id FROM tb_prod_car t WHERE t.pro_size=? AND t.pro_color=? AND t.prod_id=? AND t.user_id=? AND t.state='1'";
            Object[] params = {carDo.getProSize(), carDo.getProColor(),
                    carDo.getProdId(), carDo.getUserId()};
            ResultSetHandler<Integer> rsh = new BeanHandler<Integer>(Integer.class) {

                @Override
                public Integer handle(ResultSet rs) throws SQLException {
                    Integer res = 0;
                    while (rs.next()) {
                        res = rs.getInt("car_id");
                    }

                    return res;
                }
            };
            log.info("CarDaoImpl-->queryCarByPro:sql-->{}", sql);
            log.info("参数：{},{},{},{}", carDo.getProSize(), carDo.getProColor(),
                    carDo.getProdId(), carDo.getUserId());
            return runner.query(sql, rsh, params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Boolean updateCarNum(Integer carId) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "UPDATE tb_prod_car SET pro_num=pro_num+1, update_date=NOW(), tal_price=(pro_num*pro_price) WHERE car_id=?";
            Object params[] = {carId};
            log.info("CarDaoImpl-->updateCarNum:sql-->{}", sql);
            log.info("参数：{}", carId);
            return runner.update(sql, params) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Boolean delCarItem(String carId) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "UPDATE tb_prod_car t SET t.state='0', t.update_date=NOW() WHERE t.car_id=?";
            Object params[] = {carId};
            log.info("CarDaoImpl-->delCarItem:sql-->{}", sql);
            log.info("参数：{}", carId);
            return runner.update(sql, params) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
     public Boolean delCarByUser(Integer userId) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "UPDATE tb_prod_car t SET t.state='0', t.update_date=NOW() WHERE t.user_id=?";
            Object params[] = {userId};
            log.info("CarDaoImpl-->delCarByUser:sql-->{}", sql);
            log.info("参数：{}", userId);
            return runner.update(sql, params) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Boolean updCarItem(String carId, String proNum) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "UPDATE tb_prod_car SET pro_num=?, update_date=NOW(), tal_price=(?*pro_price) WHERE car_id=?";
            Object params[] = {proNum, proNum, carId};
            log.info("CarDaoImpl-->updCarItem:sql-->{}", sql);
            log.info("参数：{},{},{}", proNum, proNum, carId);
            return runner.update(sql, params) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
