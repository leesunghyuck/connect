package org.spring.my.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.spring.my.dao.SignRepository;
import org.spring.my.domain.Code;
import org.spring.my.domain.User;
import org.spring.my.exception.BadRequestmessageException;
import org.spring.my.util.Sha256;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.CookieGenerator;

@Service
public class SignServiceImpl implements SignService{

	@Autowired
	SignRepository signRepository;

	@Transactional
	@Override
	public User signUp(User user) throws Exception{

		if(!user.getEmail().matches(EMAIL_REGEX)) {
			throw new BadRequestmessageException(Code.SIGN_IN_ERROR_PARAM_EMAIL_REGEX, "이메일 형식이 다릅니다.");
		}

		if(!user.getPassword().matches(PASSWD_REGEX)) {
			throw new BadRequestmessageException(Code.SIGN_IN_ERROR_PARAM_PASSWORD_REGEX, "비밀번호 형식이 다릅니다.");
		}

		if(!user.getName().matches(NAME_REGEX)) {
			throw new BadRequestmessageException(Code.SIGN_IN_ERROR_PARAM_NAME_REGEX, "이름 형식이 다릅니다.");
		}

		String email = user.getEmail();
		String password = user.getPassword();

		password = Sha256.encrypt(email + password);
		user.setPassword(password);

		int insertCount = signRepository.insertUser(user);

		if(insertCount == 0) {
			return null;
		}

		if(true) {
			throw new RuntimeException();
		}

		signRepository.insertUserPoint(user.getIdx(), 100);

		return user;
	}

	@Override
	public User signIn(HttpServletResponse response,User user) {

		if(!user.getEmail().matches(EMAIL_REGEX)) {
			return null;
		}

		if(!user.getPassword().matches(PASSWD_REGEX)) {
			return null;
		}

		Map<String, Object> params = new HashMap<>();

		String email = user.getEmail();
		String password = user.getPassword();
		password = Sha256.encrypt(email + password);

		params.put("email", user.getEmail());
		params.put("password", password);

		User signInUser = signRepository.selectUserByIdPw(params);

		if( signInUser != null ) {
			int tryCount = 5;

			String token = "";
			while(tryCount-- > 0) {
				token = "";
				for(int i=0;i<8;i++) {
					token += UUID.randomUUID().toString().replace("-", "").toUpperCase().substring(0, 16);
				}
				try {
					int insertCount = signRepository.insertAutosign(signInUser.getIdx(), token);
					if(insertCount == 1) {
						break;
					}
				}catch (Exception e) {
					e.printStackTrace();
				}
			}

			if(tryCount == 0) {
				return null;
			}

			CookieGenerator cg = new CookieGenerator();
			cg.setCookieName(AUTOSIGN_KEY);
			cg.setCookieMaxAge(24 * 60 * 60 * 30);
			cg.addCookie(response, token);

		}

		return signInUser;
	}

}
