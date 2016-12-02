package com.fengze.shop.web.shop;

import com.fengze.shop.domain.OrderDo;
import com.fengze.shop.domain.UserDo;
import com.fengze.shop.service.BusinessService;
import com.fengze.shop.service.impl.BusinessServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 新增订单
 * Created by zhangls on 2016/11/8 0008.
 */
@Slf4j
public class AddOrderServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDo user = (UserDo) request.getSession().getAttribute("user");

        if (null == user) {
            response.sendRedirect(request.getContextPath() + "/shop/login.jsp");
            return;
        }

        OrderDo order = new OrderDo();
        order.setCreateBy(user.getUserName());
        order.setUpdateBy(user.getUserName());
        order.setUserId(user.getId());
        order.setOrderPrice(Double.valueOf(request.getParameter("orderPrice")));
        order.setOrderName(request.getParameter("orderName"));
        order.setOrderAddr(request.getParameter("orderAddr"));
        order.setOrderPhone(request.getParameter("orderPhone"));
        order.setOrderTel(request.getParameter("orderTel"));
        order.setOrderDesc(request.getParameter("orderDesc"));

        log.info("新增订单,请求参数,{}", order);

        BusinessService service = new BusinessServiceImpl();
        if (service.addOrder(order)) {
            request.getRequestDispatcher("/shop/order-pay.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/shop/page-500.jsp").forward(request, response);
        }
    }
}