package com.fengze.shop.dao.impl;

import com.fengze.shop.dao.MenuDao;
import com.fengze.shop.domain.Menu;
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
 * Created by zhangls on 2016/10/29 0029.
 */
@Slf4j
public class MenuDaoImpl implements MenuDao {

    @Override
    public List<Menu> queryMenu(Integer menuId) {
        try {
            QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
            String sql = "SELECT t.type_id,t.type_name,t.type_p_id,t.menu_style,t.is_menu,t.menu_uri FROM tb_prod_type t WHERE t.state='1' AND t.type_p_id=? ORDER BY t.type_id desc";
            Object[] params = {menuId};
            ResultSetHandler<List<Menu>> rsh = new BeanListHandler<Menu>(Menu.class) {

                @Override
                public List<Menu> handle(ResultSet rs) throws SQLException {
                    List<Menu> ls = new LinkedList<Menu>();
                    while (rs.next()){
                        Menu menu = new Menu();

                        menu.setId(rs.getInt("type_id"));
                        menu.setMenuName(rs.getString("type_name"));
                        menu.setPId(rs.getInt("type_p_id"));
                        menu.setMenuStyle(rs.getString("menu_style"));
                        menu.setIsMenu(rs.getString("is_menu"));
                        menu.setMenuUri(rs.getString("menu_uri"));

                        ls.add(menu);
                    }

                    return ls;
                }
            };
            //log.info("MenuDaoImpl-->queryMenu:sql-->{}", sql);
            return runner.query(sql, rsh, params);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
