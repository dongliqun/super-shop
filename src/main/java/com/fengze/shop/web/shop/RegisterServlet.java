package com.fengze.shop.web.shop;

import com.fengze.shop.domain.UserDo;
import com.fengze.shop.service.BusinessService;
import com.fengze.shop.service.impl.BusinessServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangls on 2016/10/28 0028.
 */
@Slf4j
public class RegisterServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserDo user = new UserDo();

        user.setUserName(request.getParameter("userName"));
        user.setPassword(request.getParameter("password"));
        user.setRealName(request.getParameter("realName"));
        user.setEmail(request.getParameter("email"));
        user.setCellphone(request.getParameter("cellphone"));
        user.setAddress(request.getParameter("address"));
        user.setCreateBy("admin");
        user.setUpdateBy("admin");
        user.setUserType("0");//user_type = 1:系统用户 0:注册会员用户

        log.info("新增会员注册信息，user：{}", user.toString());

        BusinessService service = new BusinessServiceImpl();
        if(service.registerMember(user)){
            log.info("会员注册成功！");
            response.sendRedirect(request.getContextPath() + "/shop/login.jsp");
        }else {
            log.info("会员注册失败！");
            request.setAttribute("message", "系统忙，请稍后在试！");
            request.getRequestDispatcher("/shop/register.jsp").forward(request, response);
        }
    }
}
