package org.spring.my.controller;


import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.spring.my.domain.User;
import org.spring.my.service.SignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.CookieGenerator;

@RestController
@RequestMapping("/sign")
public class SignController {

	@Autowired
	SignService signService;

	@PostMapping("/in")
	public Object signInPOST(@RequestHeader(value="User-Agent") String userAgent, User user, HttpSession session, HttpServletResponse response) {

		//userAgent 접속정보
		System.out.println("userAgent : "+ userAgent);
		User signInUser = signService.signIn(response, user);

		Map<String, Object> result = new HashMap<>();

		boolean succ = signInUser != null;
		result.put("succ", succ);

		if(signInUser != null) {
			int userIdx = signInUser.getIdx();
			session.setAttribute(signService.SIGN_IN_USER_IDX_KEY, userIdx);
		}

		return result;
	}

	@PostMapping("/up")
	public Object signUpPost(User user) throws Exception{
		User signUpUser = signService.signUp(user);

		Map<String, Object> result = new HashMap<>();

		boolean succ = signUpUser != null;
		result.put("succ", succ);

		return result;
	}

	@RequestMapping("/out")
	public Object signOUT(HttpSession session, HttpServletResponse response) {

		//session.removeAttribute(SignService.SIGN_IN_USER_IDX_KEY);
		session.invalidate();

		CookieGenerator cg = new CookieGenerator();
		cg.setCookieName(SignService.AUTOSIGN_KEY);
		cg.setCookieMaxAge(0);
		cg.addCookie(response, "");

		return null;
	}

}
