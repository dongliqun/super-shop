package com.fengze.shop.web.shop;

import com.fengze.shop.domain.CarDo;
import com.fengze.shop.domain.ProductDo;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangls on 2016/11/10 0010.
 */
@Slf4j
public class CookieCarServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 1.如果是游客 添加购物车  添加到cookie中
     * 2.如果该游客登录了
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String sessionId = request.getRequestedSessionId();

        Double tempPrice = 0.00;
        DecimalFormat df = new DecimalFormat("#.00");

        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            List<CarDo> carLs = new ArrayList<CarDo>();

            for (int i = 0; i < cookies.length; i++) {
                String[] sts = cookies[i].getName().split("_");
                if(sts[0].equals(sessionId)){
                    String val = URLDecoder.decode(cookies[i].getValue(), "UTF-8");

                    String[] proSts = val.split(",");
                    CarDo car = new CarDo();
                    car.setProdId(Integer.valueOf(proSts[0]));
                    car.setProColor(proSts[4]);
                    car.setProSize(proSts[3]);
                    car.setProPrice(Double.valueOf(proSts[2]));
                    car.setProNum(Integer.valueOf(proSts[5]));
                    car.setTalPrice(Double.valueOf(df.format(Double.valueOf(proSts[2]) * Integer.valueOf(proSts[5]))));

                    ProductDo productDo = new ProductDo();
                    productDo.setId(Integer.valueOf(proSts[0]));
                    productDo.setProPicUri(proSts[6]);

                    car.setPro(productDo);

                    carLs.add(car);
                }
            }

            Integer luckPrice = 0;
            for (CarDo car : carLs) {
                tempPrice += car.getTalPrice();
//                luckPrice += car.getProNum();
            }

            request.setAttribute("tempPrice", df.format(tempPrice));
            request.setAttribute("luckPrice", luckPrice);
            request.setAttribute("orderPrice", df.format(tempPrice-luckPrice));
            request.setAttribute("carLs", carLs);
            request.getRequestDispatcher("/shop/car-list-det.jsp").forward(request, response);
        }


    }
}
