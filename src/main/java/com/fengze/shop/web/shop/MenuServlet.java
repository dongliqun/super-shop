package com.fengze.shop.web.shop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fengze.shop.domain.Menu;
import com.fengze.shop.service.BusinessService;
import com.fengze.shop.service.impl.BusinessServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangls on 2016/10/29 0029.
 */
@Slf4j
public class MenuServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request,response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BusinessService service = new BusinessServiceImpl();
        Map<Integer, List<Menu>> map = service.queryMenu();

        PrintWriter out = response.getWriter();
        out.flush();
        String str = JSON.toJSONString(map, true);
        out.print(str);
        out.close();
    }
}
