package com.fengze.shop.dao;

import com.fengze.shop.domain.OrderDetDo;
import com.fengze.shop.domain.OrderDo;

import java.util.List;

/**
 * Created by zhangls on 2016/11/8 0008.
 */
public interface OrderDao {

    public Boolean addOrder(OrderDo order);

    public Boolean addOrderDet(List<OrderDetDo> ls);

    public String queryOrderId();

    public Boolean deleteCarByUser(Integer userId);
}
