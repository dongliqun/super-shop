package com.fengze.shop.dao;

import com.fengze.shop.domain.CarDo;
import com.fengze.shop.domain.ProductDo;
import com.fengze.shop.domain.UserDo;

import java.util.List;

/**
 * Created by zhangls on 2016/11/3 0003.
 */
public interface CarDao {

    public Boolean addCarInfo(CarDo carDo);//添加购物车

    public List<CarDo> queryCarInfo(UserDo user);//查询我的购物车

    public Integer queryCarCount(UserDo user);//查询购物车条数

    public Integer queryCarByPro(CarDo carDo);//

    public Boolean updateCarNum(Integer carId);//修改购物车数量

    public Boolean delCarItem(String carId);//删除购物车

    public Boolean updCarItem(String carId, String proNum);//修改

    public Boolean delCarByUser(Integer userId);//删除购物车--用户
}
