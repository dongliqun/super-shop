package com.fengze.shop.service;


import com.fengze.shop.domain.*;

import java.util.List;
import java.util.Map;

/**
 * 业务处理接口
 */
public interface BusinessService {

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    public UserDo userLogin(String username, String password);

    /**
     * 用户注册
     * @param user
     * @return
     */
    public Boolean registerMember(UserDo user);

    /**
     * 查询菜单
     * @return
     */
    public Map<Integer, List<Menu>> queryMenu();

    /**
     * 菜单中产品列表
     * @param menuId
     * @return
     */
    public List<ProductDo> queryMenuPro(Integer menuId);

    /**
     * 添加产品
     * @param pro
     * @return
     */
    public Boolean addProduct(ProductDo pro);

    /**
     * 分页查询产品列表
     * @param proDo
     * @param currentPage
     * @return
     */
    public Page<ProductDo> queryProductList(ProductDo proDo, Integer currentPage);

    /**
     * 添加购物车
     * @param carDo
     * @return
     */
    public Boolean addCarInfo(CarDo carDo);

    /**
     * 查询购物车列表
     * @param user
     * @return
     */
    public List<CarDo> queryCarInfo(UserDo user);

    /**
     * 根据产品ID，查询产品
     * @param proId
     * @return
     */
    public ProductDo queryProductById(String proId);

    /**
     * 根据用户信息查询购物车产品数量
     * @param user
     * @return
     */
    public Integer queryCarNum(UserDo user);

    /**
     * 删除购物车产品
     * @param carId
     * @return
     */
    public Boolean delCarItem(String carId);

    /**
     * 更新购物车相同产品的数量
     * @param carId
     * @param proNum
     * @return
     */
    public Boolean updCarItem(String carId, String proNum);

    /**
     * 新增订单
     * @param order
     * @return
     */
    public Boolean addOrder(OrderDo order);
}