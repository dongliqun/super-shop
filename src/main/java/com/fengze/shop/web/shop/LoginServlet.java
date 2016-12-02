package com.fengze.shop.web.shop;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fengze.shop.domain.UserDo;
import com.fengze.shop.service.BusinessService;
import com.fengze.shop.service.impl.BusinessServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * 登陆
 *
 */
@Slf4j
public class LoginServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		log.info("登陆用户名：{}，登陆密码：{}", username,password);

		BusinessService service = new BusinessServiceImpl();
		UserDo user = service.userLogin(username, password);
		if (user == null) {
			request.setAttribute("message", "用户名或密码错误！请重试");
//            response.sendRedirect(request.getContextPath() + "/shop/login.jsp");
			request.getRequestDispatcher("/shop/login.jsp").forward(request, response);
            log.info("登陆失败，用户名或密码错误！");
			return;
		}

        log.info("登陆成功！");
        request.getSession().setAttribute("user", user);
		request.getSession().setAttribute("carNum",service.queryCarNum(user));//设置购物车产品数量
		response.sendRedirect(request.getContextPath() + "/shop/index.jsp");
//		request.getRequestDispatcher("/shop/index.jsp").forward(request, response);
	}

}
