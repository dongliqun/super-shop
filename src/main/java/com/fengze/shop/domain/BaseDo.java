package com.fengze.shop.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * 模型实体基类
 */
@Data
public class BaseDo implements Serializable {

    private Integer id;//组件ID

    private String state;//是否可用状态

    private String createBy;//创建人

    private String createDate;//创建日期

    private String updateBy;//更新人

    private String updateDate;//更新时间

}
