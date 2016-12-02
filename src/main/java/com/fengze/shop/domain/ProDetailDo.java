package com.fengze.shop.domain;

import lombok.Data;

/**
 * 产品详表模型类
 * Created by zhangls on 2016/11/3 0003.
 */
@Data
public class ProDetailDo extends BaseDo {

    private Integer proId;
    private String detLength;
    private String detWidth;
    private String detHeight;
    private String detMate;//质地
    private String detAddr;//产地
    private String detDate;//生产日期
    private String detDesc;
}
