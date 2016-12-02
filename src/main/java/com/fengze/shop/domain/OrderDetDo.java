package com.fengze.shop.domain;

import lombok.Data;

/**
 * 订单详表模型类
 * Created by zhangls on 2016/11/8 0008.
 */
@Data
public class OrderDetDo extends BaseDo {

    private String orderId;
    private Integer proId;
    private String proName;
    private Integer proNum;
    private String proDesc;
    private String proSize;
    private String proColor;
    private Double proPrice;
    private Double talPrice;
}
