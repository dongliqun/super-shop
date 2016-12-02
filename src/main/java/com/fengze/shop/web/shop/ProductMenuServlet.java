package com.fengze.shop.web.shop;

import com.alibaba.fastjson.JSON;
import com.fengze.shop.domain.ProductDo;
import com.fengze.shop.service.BusinessService;
import com.fengze.shop.service.impl.BusinessServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by zhangls on 2016/10/31 0031.
 */
@Slf4j
public class ProductMenuServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BusinessService service = new BusinessServiceImpl();
        List<ProductDo> ls = service.queryMenuPro(Integer.valueOf(request.getParameter("menuId")));

        PrintWriter out = response.getWriter();
        out.flush();
        String str = JSON.toJSONString(ls, true);
        out.print(str);
        out.close();
    }
}
