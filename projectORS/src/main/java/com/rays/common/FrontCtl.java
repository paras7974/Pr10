package com.rays.common;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Front controller verifies if user id logged in
 * 
 * @author Paras Mahajan
 * 
 */
@Component
public class FrontCtl extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		String path = request.getServletPath();

		System.out.println(" Front Ctl Called " + path);
		/*
		 * System.out.println(" Session ID " + session.getId());
		 * System.out.println("Usercontext " + session.getAttribute("`"));
		 */

		if (!path.startsWith("/Auth/")) {
			System.out.println("inside if condition");
			// System.out.println(session.getAttribute("test")+"-------test____");
			if (session.getAttribute("user") == null) {

				System.out.println("inside if usercontext null");

				response.setContentType("application/json");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);

				response.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
				response.setHeader("Access-Control-Allow-Credentials", "true");
				response.setHeader("Access-Control-Allow-Methods", "GET,DELETE,OPTIONS,POST,PUT");
				response.setHeader("Access-Control-Allow-Headers", "*");

				PrintWriter out = response.getWriter();
				out.print("{\"success\":\"false\",\"error\":\"OOPS! Your session has been expired\"}");
				out.close();
				System.out.println("going to return false ");

				return false;
			}
		}
		System.out.println("going to return true");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("inside post handler");
		response.setHeader("Access-Control-Allow-Origin", "");
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Methods", "GET,HEAD,OPTIONS,POST,PUT");
	}
}
