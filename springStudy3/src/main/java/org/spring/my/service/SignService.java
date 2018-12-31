package org.spring.my.service;

import javax.servlet.http.HttpServletResponse;

import org.spring.my.domain.User;

public interface SignService {

	public final static String SIGN_IN_USER_IDX_KEY = "SignInUserIdx";
	public final static String AUTOSIGN_KEY = "Autosign";

	public final static String EMAIL_REGEX = "^[0-9a-zA-Z_.\\-]+@[0-9a-zA-Z_\\-]+(\\.[0-9a-zA-Z_\\-]+){1,2}$";
	public final static String PASSWD_REGEX = "^(?=.*[a-zA-Z])(?=.*[0-9]).{8,16}$";
	public final static String NAME_REGEX = "^[A-Za-z0-9가-힣]{2,30}$";

	User signUp(User user) throws Exception;
	User signIn(HttpServletResponse response, User user);
}
