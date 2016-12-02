package com.fengze.shop.dao.impl;

import com.fengze.shop.dao.UserDao;
import com.fengze.shop.domain.UserDo;
import com.fengze.shop.utils.JdbcUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.ResultSet;
import java.sql.SQLException;

@Slf4j
public class UserDaoImpl implements UserDao {

    public Boolean add(UserDo user) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "INSERT INTO tb_user (user_name, pass_word, real_name, email, cell_phone, address, user_type, state, create_by, create_date, update_by, update_date) VALUES (?,?,?,?,?,?,?,'1',?,now(),?,now())";
            Object params[] = {user.getUserName(), user.getPassword(), user.getRealName(),
                    user.getEmail(), user.getCellphone(), user.getAddress(), user.getUserType(),
                    user.getCreateBy(), user.getUpdateBy()};
            log.info("UserDaoImpl-->add:sql-->{}", sql);
            return runner.update(sql, params) > 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @SuppressWarnings("unchecked")
    public UserDo find(String id) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "select * from user where id = ?";
            log.info("UserDaoImpl-->find:sql-->{}", sql);
            return (UserDo) runner.query(sql, id, new BeanHandler(UserDo.class));
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


    public UserDo find(String username, String password) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "SELECT t.user_id,t.user_name,t.pass_word,t.real_name,t.email,t.user_type,t.state,t.cell_phone,t.address,t.create_by,t.create_date,t.update_by,t.update_date FROM tb_user t WHERE t.user_name=? AND t.pass_word=? ";
            Object[] params = {username, password};

            ResultSetHandler<UserDo> rsh = new ResultSetHandler<UserDo>() {
                @Override
                public UserDo handle(ResultSet rs) throws SQLException {
                    if (!rs.next()) return null;
                    UserDo user = new UserDo();
                    user.setId(rs.getInt("user_id"));
                    user.setUserName(rs.getString("user_name"));
                    user.setPassword(rs.getString("pass_word"));
                    user.setRealName(rs.getString("real_name"));
                    user.setEmail(rs.getString("email"));
                    user.setUserType(rs.getString("user_type"));
                    user.setState(rs.getString("state"));
                    user.setCellphone(rs.getString("cell_phone"));
                    user.setAddress(rs.getString("address"));
                    user.setCreateBy(rs.getString("create_by"));
                    user.setCreateDate(rs.getString("create_date"));
                    user.setUpdateBy(rs.getString("update_by"));
                    user.setUpdateDate(rs.getString("update_date"));

                    return user;
                }
            };

            log.info("UserDaoImpl-->find:sql-->{}", sql);
            return runner.query(sql, rsh, params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
