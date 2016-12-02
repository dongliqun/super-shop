package com.fengze.shop.web.shop;

import com.fengze.shop.service.BusinessService;
import com.fengze.shop.service.impl.BusinessServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangls on 2016/11/7 0007.
 */
@Slf4j
public class CarUpdServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BusinessService service = new BusinessServiceImpl();
        if (service.updCarItem(req.getParameter("carId"), req.getParameter("proNum"))) {
            log.info("更新成功");
            req.getRequestDispatcher("/shop/carList").forward(req, resp);
        } else {
            log.info("更新失败");
        }
    }
}
