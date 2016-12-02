package com.fengze.shop.dao.impl;

import com.fengze.shop.dao.CommentDao;
import com.fengze.shop.domain.CommentDo;
import com.fengze.shop.domain.ProductDo;
import com.fengze.shop.utils.JdbcUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangls on 2016/11/3 0003.
 */
@Slf4j
public class CommentDaoImpl implements CommentDao {

    @Override
    public List<CommentDo> queryComByProId(ProductDo pro) {

        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "SELECT t.com_id,t.pro_id,t.user_id,u.user_name,t.com_title,t.com_desc,t.pro_score FROM tb_prod_comment t LEFT JOIN tb_user u ON t.user_id=u.user_id WHERE t.state='1' AND t.pro_id=?";
            Object[] params = {pro.getId()};
            ResultSetHandler<List<CommentDo>> rsh = new BeanListHandler<CommentDo>(CommentDo.class) {

                @Override
                public List<CommentDo> handle(ResultSet rs) throws SQLException {
                    List<CommentDo> ls = new LinkedList<CommentDo>();
                    while (rs.next()) {
                        CommentDo com = new CommentDo();

                        com.setComId(rs.getInt("com_id"));
                        com.setProId(rs.getInt("pro_id"));
                        com.setUserId(rs.getInt("user_id"));
                        com.setUserName(rs.getString("user_name"));
                        com.setComTitle(rs.getString("com_title"));
                        com.setComDesc(rs.getString("com_desc"));
                        com.setProScore(rs.getDouble("pro_score"));

                        ls.add(com);
                    }

                    return ls;
                }
            };
            log.info("CommentDaoImpl-->queryComByProId:sql-->{}", sql);
            log.info("参数：{}", pro.getId());
            return runner.query(sql, rsh, params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
