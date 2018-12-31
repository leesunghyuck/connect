package org.spring.my.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.spring.my.service.SignService;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		HttpSession session = request.getSession();

		Integer userIdx = (Integer) session.getAttribute(SignService.SIGN_IN_USER_IDX_KEY);

		if(userIdx == null) {
			/*try {
				response.sendRedirect("/site/signin.html");
			} catch (Exception e) {
				e.printStackTrace();
			}*/

			response.setCharacterEncoding("UTF-8");
//			response.addHeader("Content-Type", "application/json;charset=UTF-8");
			try{
				PrintWriter printWriter = response.getWriter();
				printWriter.print("NEED LOGIN");
			}catch(Exception e){
				e.printStackTrace();
			}

			return false;
		}

		return super.preHandle(request, response, handler);
	}

	/*
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}
	*/
}
