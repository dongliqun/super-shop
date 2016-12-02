package com.fengze.shop.dao.impl;

import com.fengze.shop.dao.OrderDao;
import com.fengze.shop.domain.OrderDetDo;
import com.fengze.shop.domain.OrderDo;
import com.fengze.shop.utils.JdbcUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbutils.QueryRunner;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangls on 2016/11/8 0008.
 */
@Slf4j
public class OrderDaoImpl implements OrderDao {

    private Connection conn;

    public OrderDaoImpl() {
        this.conn = JdbcUtils.getContainer().get();//线程共享对象获取连接
    }

    @Override
    public Boolean addOrder(OrderDo order) {
        try {
            QueryRunner runner = new QueryRunner();
            String sql = "INSERT INTO tb_order(order_id,user_id,order_price,order_name,order_addr,order_phone,order_tel,order_desc,state,create_by,create_date,update_by,update_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?,'1', ?,NOW(), ?,NOW())";
            Object params[] = {order.getOrderId(), order.getUserId(), order.getOrderPrice(), order.getOrderName(),
                    order.getOrderAddr(), order.getOrderPhone(), order.getOrderTel(), order.getOrderDesc(),
                    order.getCreateBy(), order.getUpdateBy()};
            log.info("OrderDaoImpl-->addCarInfo:sql-->{}", sql);
            log.info("参数：{},{},{},{},{},{},{},{},{},{}", order.getOrderId(), order.getUserId(),
                    order.getOrderPrice(), order.getOrderName(), order.getOrderAddr(),
                    order.getOrderPhone(), order.getOrderTel(), order.getOrderDesc(),
                    order.getCreateBy(), order.getUpdateBy());
            return runner.update(conn, sql, params) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Boolean deleteCarByUser(Integer userId) {
        try {
            QueryRunner runner = new QueryRunner();
            String sql = "UPDATE tb_prod_car t SET t.state='0', t.update_date=NOW() WHERE t.user_id=?";
            Object params[] = {userId};
            log.info("CarDaoImpl-->delCarByUser:sql-->{}", sql);
            log.info("参数：{}", userId);
            return runner.update(conn, sql, params) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Boolean addOrderDet(List<OrderDetDo> ls) {
        try {
            String sql = "INSERT INTO tb_order_detail(order_id,pro_id,pro_name,pro_desc,pro_size,pro_color,pro_num,pro_price,tal_price,state,create_by,create_date,update_by,update_date) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?,'1', ?,NOW(), ?,NOW())";
            QueryRunner query = new QueryRunner();
            Object[][] params = new Object[ls.size()][];

            for (int i = 0; i < ls.size(); i++) {
                OrderDetDo orderDet = ls.get(i);
                params[i] = new Object[11];
                params[i][0] = orderDet.getOrderId();
                params[i][1] = orderDet.getProId();
                params[i][2] = orderDet.getProName();
                params[i][3] = orderDet.getProDesc();
                params[i][4] = orderDet.getProSize();
                params[i][5] = orderDet.getProColor();
                params[i][6] = orderDet.getProNum();
                params[i][7] = orderDet.getProPrice();
                params[i][8] = orderDet.getTalPrice();
                params[i][9] = orderDet.getCreateBy();
                params[i][10] = orderDet.getUpdateBy();
            }

            int[] isi = query.batch(conn, sql, params);
            log.info("ProductDaoImpl-->addPicInfo:sql-->{}", sql);
            return Boolean.TRUE;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public String queryOrderId() {
        String orderId = null;
        String sql = "{call seq_no()}";
        CallableStatement callStmt = null;
        ResultSet rs = null;
        try {
            callStmt = conn.prepareCall(sql);
            rs = callStmt.executeQuery();
            while (rs.next()){
                orderId = rs.getString("order_sn");
            }
            return orderId;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        } finally {
            try {
                rs.close();
                callStmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        }
    }
}
