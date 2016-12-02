package com.fengze.shop.domain;

import lombok.Data;

import java.util.List;

/**
 * 订单模型类
 * Created by zhangls on 2016/11/8 0008.
 */
@Data
public class OrderDo extends BaseDo {


    private String orderId;//数据库生成的订单号
    private Integer userId;//用户ID
    private String orderName;//邮寄人姓名
    private Double orderPrice;//订单金额
    private String orderAddr;//邮寄地址
    private String orderPhone;//联系手机
    private String orderTel;//联系电话
    private String orderDesc;//留言

    private List<OrderDetDo> detLs;
}
