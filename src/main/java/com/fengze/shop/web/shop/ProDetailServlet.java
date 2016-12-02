package com.fengze.shop.web.shop;

import com.fengze.shop.domain.Page;
import com.fengze.shop.domain.ProductDo;
import com.fengze.shop.service.BusinessService;
import com.fengze.shop.service.impl.BusinessServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhangls on 2016/11/3 0003.
 */
@Slf4j
public class ProDetailServlet extends HttpServlet {

    /**
     * http://localhost:8282/super-shop/shop/proDet?pId=7
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String prodId = request.getParameter("pId");//产品编号
        log.info("查询产品详情，产品ID：{}", prodId);

        BusinessService service = new BusinessServiceImpl();

        ProductDo pro = service.queryProductById(prodId);

        request.setAttribute("pro",pro);

        request.getRequestDispatcher("/shop/item.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
