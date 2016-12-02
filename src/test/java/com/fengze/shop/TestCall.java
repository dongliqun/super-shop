package com.fengze.shop;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * Created by zhangls on 2016/11/9 0009.
 */
public class TestCall {



    public static void main(String[] args) throws Exception {
        Connection conn = null;
        CallableStatement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/super_shop", "root", "root");

            stmt = conn.prepareCall("{call seq_no()}");

            // out 注册的index 和取值时要对应
//            stmt.registerOutParameter(3, Types.INTEGER);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                System.out.printf(rs.getString("order_sn"));
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            if (null != stmt) {
                stmt.close();
            }
            if (null != conn) {
                conn.close();
            }
        }
    }
}
