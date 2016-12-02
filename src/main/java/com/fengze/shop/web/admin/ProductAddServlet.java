package com.fengze.shop.web.admin;

import com.fengze.shop.domain.PicDo;
import com.fengze.shop.domain.ProDetailDo;
import com.fengze.shop.domain.ProductDo;
import com.fengze.shop.service.BusinessService;
import com.fengze.shop.service.impl.BusinessServiceImpl;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangls on 2016/11/1 0001.
 */
@Slf4j
public class ProductAddServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ProductDo proDo = new ProductDo();

        proDo.setProName(request.getParameter("proName"));
        proDo.setProRealPrice(Double.valueOf(request.getParameter("realPrice")));
        proDo.setProNowPrice(Double.valueOf(request.getParameter("nowPrice")));
        proDo.setIsStock(request.getParameter("isStock"));
        proDo.setProDesc(request.getParameter("proDesc"));
        proDo.setProSize(convertStr(request.getParameterValues("proSize")));
        proDo.setProColor(convertStr(request.getParameterValues("proColor")));
        proDo.setProScore(Double.valueOf(request.getParameter("proScore")));
        proDo.setProTypeId(convertStr(request.getParameterValues("typeId")));
        proDo.setCreateBy("admin");
        proDo.setUpdateBy("admin");

        List<PicDo> ls = getPicInfo(request.getParameterValues("picUri"));

        proDo.setPicLs(ls);

        proDo.setProPicUri(ls.get(0).getPicUri());


        ProDetailDo detDo = new ProDetailDo();
        detDo.setCreateBy("admin");
        detDo.setUpdateBy("admin");
        detDo.setDetLength(request.getParameter("detLength"));
        detDo.setDetHeight(request.getParameter("detHeight"));
        detDo.setDetWidth(request.getParameter("detWidth"));
        detDo.setDetMate(request.getParameter("detMate"));
        detDo.setDetAddr(request.getParameter("detAddr"));
        detDo.setDetDate(request.getParameter("detDate"));
        detDo.setDetDesc(request.getParameter("detDesc"));

        proDo.setProDetailDo(detDo);

        log.info("待增加的产品信息{}",proDo.toString());

        BusinessService service = new BusinessServiceImpl();
        if(service.addProduct(proDo)){
            log.info("新增产品成功！");
            request.getRequestDispatcher("/shop/order-pay.jsp").forward(request,response);
        } else {
            log.info("新增产品失败！");
            request.getRequestDispatcher("/shop/page-500.jsp").forward(request,response);
        }
    }

    private String convertStr(String[] param){
        String sts = "";
        for (int i = 0; i < param.length; i++) {
            sts += param[i] + ",";
        }
        return sts.substring(0,sts.length()-1);
    }

    private List<PicDo> getPicInfo(String[] param){
        List<PicDo> ls = new LinkedList<PicDo>();
        for (int i = 0; i < param.length; i++) {
            PicDo pic = new PicDo();
            pic.setPicUri(param[i]);
            pic.setIsOrder(String.valueOf(i));
            pic.setCreateBy("admin");
            pic.setUpdateBy("admin");

            ls.add(pic);
        }
        return ls;
    }
}
