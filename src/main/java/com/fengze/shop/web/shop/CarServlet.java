package com.fengze.shop.web.shop;

import com.fengze.shop.domain.CarDo;
import com.fengze.shop.domain.ProductDo;
import com.fengze.shop.domain.UserDo;
import com.fengze.shop.service.BusinessService;
import com.fengze.shop.service.impl.BusinessServiceImpl;
import com.fengze.shop.utils.CookieUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by zhangls on 2016/11/4 0004.
 */
@Slf4j
public class CarServlet extends HttpServlet {

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

        Integer proId = Integer.valueOf(request.getParameter("proId"));
        Double proPrice = Double.valueOf(request.getParameter("proPrice"));
        String proSize = request.getParameter("proSize") != null ? request.getParameter("proSize") : "XL";
        String proColor = request.getParameter("proColor") != null ? request.getParameter("proColor") : "black";
        Integer proNum = request.getParameter("proNum") != null ? Integer.valueOf(request.getParameter("proNum")) : 1;

        BusinessService service = new BusinessServiceImpl();
        ProductDo prod = service.queryProductById(String.valueOf(proId));

        UserDo user = (UserDo) request.getSession().getAttribute("user");

        //游客添加购物车
        if (null == user) {

            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length > 0) {
                for (int i = 0; i < cookies.length; i++) {
                    String proKey = getCookieKey(String.valueOf(proId), sessionId);

                    if (cookies[i].getName().equals(proKey)) {
                        String val = URLDecoder.decode(cookies[i].getValue(), "UTF-8");

                        String[] proSts = val.split(",");
                        Integer tmpId = Integer.valueOf(proSts[0]);
                        String tmpColor = proSts[4];
                        String tmpSize = proSts[3];
                        Integer tmpNum = Integer.valueOf(proSts[5]);

                        if (tmpId.equals(proId) && tmpColor.equals(proColor) && tmpSize.equals(proSize)) {
                            cookies[i].setMaxAge(0);//删除cookie
                            Integer newNum = tmpNum + 1;

                            String proVal = getCookieVal(prod, String.valueOf(newNum), proColor, proSize, String.valueOf(proPrice));

                            CookieUtils.setCookie(response, proKey, URLEncoder.encode(proVal, "UTF-8"));
                        } else {
                            addCookieProNew(prod, String.valueOf(proNum), proColor, proSize, String.valueOf(proPrice), sessionId, response);
                        }
                    }else {
                        addCookieProNew(prod, String.valueOf(proNum), proColor, proSize, String.valueOf(proPrice), sessionId, response);
                    }
                }
            }

            request.getRequestDispatcher("/shop/car-list.jsp").forward(request, response);

            // response.sendRedirect(request.getContextPath() + "/shop/login.jsp");
            // return;
        } else { //登陆用户添加购物车

            CarDo carDo = new CarDo();

            carDo.setUserId(user.getId());
            carDo.setProdId(proId);
            carDo.setProSize(proSize);
            carDo.setProColor(proColor);
            carDo.setProNum(proNum);
            carDo.setProPrice(proPrice);
            carDo.setTalPrice(proPrice * proNum);
            carDo.setCreateBy(user.getUserName());
            carDo.setUpdateBy(user.getUserName());

            if (service.addCarInfo(carDo)) {
                log.info("加入购物车成功！");
                request.getRequestDispatcher("/shop/car-list.jsp").forward(request, response);
            } else {
                request.getRequestDispatcher("/shop/page-500.jsp").forward(request, response);
            }
        }
    }

    /**
     * 拼cookie字符串
     *
     * @return
     */
    private String getCookieKey(String proId, String sessionId) {
        StringBuffer proCookie = new StringBuffer();
        proCookie.append(sessionId).append("_").append(proId);

        return proCookie.toString();

    }

    /**
     * 拼cookie字符串
     *
     * @param prod
     * @return
     */
    private String getCookieVal(ProductDo prod, String proNum, String proColor, String proSize,
                                String proPrice) {
        StringBuffer proCookie = new StringBuffer();
        proCookie.append(prod.getId()).append(",").append(prod.getProName()).append(",").append(proPrice)
                .append(",").append(proSize).append(",").append(proColor).append(",").append(proNum).append(",").append(prod.getProPicUri());

        return proCookie.toString();
    }

    private void addCookieProNew(ProductDo prod, String proNum, String proColor, String proSize,
                                 String proPrice, String sessionId, HttpServletResponse response) throws IOException {
        StringBuffer proCookieVal = new StringBuffer();
        proCookieVal.append(prod.getId()).append(",").append(prod.getProName()).append(",").append(proPrice)
                .append(",").append(proSize).append(",").append(proColor).append(",").append(proNum).append(",").append(prod.getProPicUri());

        StringBuffer proCookieKey = new StringBuffer();
        proCookieKey.append(sessionId).append("_").append(prod.getId());

        CookieUtils.setCookie(response, proCookieKey.toString(), URLEncoder.encode(proCookieVal.toString(), "UTF-8"));
    }

}
