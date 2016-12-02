package com.fengze.shop.dao;

import com.fengze.shop.domain.Menu;

import java.util.List;

/**
 * Created by zhangls on 2016/10/29 0029.
 */
public interface MenuDao {

    public List<Menu> queryMenu(Integer menuId);


}
