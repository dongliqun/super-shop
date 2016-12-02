package com.fengze.shop.domain;

import lombok.Data;

/**
 * Created by zhangls on 2016/10/31 0031.
 */
@Data
public class PicDo extends BaseDo {

    private Integer proId;
    private String picUri;
    private String isOrder;
}
