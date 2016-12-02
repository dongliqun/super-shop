package com.fengze.shop.web.shop;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class LogoutServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getSession().invalidate();
        log.info("登出成功！");
//		request.getRequestDispatcher("/client/head.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath() + "/shop/index.jsp");

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
