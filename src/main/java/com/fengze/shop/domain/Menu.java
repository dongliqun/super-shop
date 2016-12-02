package com.fengze.shop.domain;

import lombok.Data;

/**
 * 菜单模型类
 * Created by zhangls on 2016/10/29 0029.
 */
@Data
public class Menu extends BaseDo {

    private String menuName;
    private Integer pId;
    private String menuUri;
    private String menuStyle;
    private String isMenu;
}
