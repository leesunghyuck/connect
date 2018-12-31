package org.spring.my.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.spring.my.dao.SignRepository;
import org.spring.my.domain.Autosign;
import org.spring.my.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutoLoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	SignRepository signRepository;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		HttpSession session = request.getSession();

		Integer userIdx = (Integer) session.getAttribute(SignService.SIGN_IN_USER_IDX_KEY);

		if(userIdx == null) {

			Cookie[] cookies = request.getCookies();
			String token = null;

			if(cookies != null) {
				for(Cookie cookie : cookies) {
					if(cookie.getName().equals(SignService.AUTOSIGN_KEY)) {
						token = cookie.getValue();
						break;
					}
				}
			}

			if(token != null) {
				Autosign autosign = signRepository.selectAutosign(token);

				if(autosign != null) {

					session.setAttribute(SignService.SIGN_IN_USER_IDX_KEY, autosign.getUser_idx());

					//클라이언트 cookie 삭제
					//update 사용시간
					//Autosign 토큰 발급 + cookie 저장
				}
			}
		}

		return super.preHandle(request, response, handler);
	}
}
