package com.fengze.shop.web.shop;

import com.fengze.shop.domain.CarDo;
import com.fengze.shop.domain.UserDo;
import com.fengze.shop.service.BusinessService;
import com.fengze.shop.service.impl.BusinessServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

/**
 * Created by zhangls on 2016/11/7 0007.
 */
@Slf4j
public class ConfirmOrderServlet extends HttpServlet {

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
        BusinessService service = new BusinessServiceImpl();
        List<CarDo> carLs = service.queryCarInfo(user);
        request.setAttribute("carLs", carLs);

        Double tempPrice = 0.00;
        DecimalFormat df = new DecimalFormat("#.00");
        Integer luckPrice = 1;
        for (CarDo car : carLs) {
            tempPrice += car.getTalPrice();
            luckPrice += car.getProNum();
        }

        request.setAttribute("tempPrice", df.format(tempPrice));
        request.setAttribute("luckPrice", df.format(luckPrice));
        request.setAttribute("orderPrice", df.format(tempPrice-luckPrice));
        request.getRequestDispatcher("/shop/confirm-order.jsp").forward(request, response);

    }
}
