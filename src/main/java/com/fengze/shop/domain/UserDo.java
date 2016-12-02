package com.fengze.shop.domain;

import lombok.Data;

/**
 * 用户模型类
 * Created by zhangls on 2016/10/27 0027.
 */
@Data
public class UserDo extends BaseDo {

    private String userName;//登陆用户名
    private String password;//登陆密码
    private String realName;//真实姓名
    private String email;//电子邮件
    private String cellphone;//联系电话
    private String address;//地址
    private String userType;//user_type = 1:系统用户 0:注册会员用户

}
