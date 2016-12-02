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
 * Created by zhangls on 2016/11/2 0002.
 */
@Slf4j
public class ProductListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //http://localhost:8282/super-shop/shop/prolist?typeId=0&pageNo=1
        ProductDo pro = new ProductDo();

        pro.setProTypeId(request.getParameter("typeId"));


        log.info("查询产品列表，产品类型ID：{}", pro.getProTypeId());

        BusinessService service = new BusinessServiceImpl();
        Page<ProductDo> page = service.queryProductList(pro, Integer.valueOf(request.getParameter("pageNo")));
        if (page.getList().size() > 0) {
            request.setAttribute("page", page);
            request.setAttribute("typeId", request.getParameter("typeId"));
            log.info("page------>{}",page);
            log.info("typeId----->{}","typeId");
            request.getRequestDispatcher("/shop/list-detail.jsp").forward(request, response);
        }
    }
}
