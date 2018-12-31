package org.spring.my.dao;

import java.util.Map;

import org.spring.my.domain.Autosign;
import org.spring.my.domain.User;

public interface SignRepository {

	int insertUser(User user);

	User selectUserByIdPw(Map<String, Object> params);

	int insertAutosign(int userIdx, String token);

	Autosign selectAutosign(String token);

	int insertUserPoint(int userIdx, int point);
}
