package com.fengze.shop.domain;

import lombok.Data;

/**
 * 购物车模型类
 * Created by zhangls on 2016/11/3 0003.
 */
@Data
public class CarDo extends BaseDo {

    private Integer userId;//用户ID;
    private Integer prodId;//产品详细ID;
    private String proSize;//产品型号;
    private String proColor;//产品颜色;
    private Integer proNum;//购买产品数;
    private Double proPrice;//产品单价;
    private Double talPrice;//总价

    private ProductDo pro;//产品信息表

}
