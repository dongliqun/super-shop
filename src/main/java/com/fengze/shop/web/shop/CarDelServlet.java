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
 * Created by zhangls on 2016/11/6 0006.
 */
@Slf4j
public class CarDelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BusinessService service = new BusinessServiceImpl();
        if (service.delCarItem(req.getParameter("carId"))) {
            log.info("删除成功");
            req.getRequestDispatcher("/shop/carList").forward(req, resp);
        } else {
            log.info("删除失败");
        }
    }
}
