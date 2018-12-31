package org.spring.my.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.spring.my.domain.Autosign;
import org.spring.my.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SignRepositoryImpl implements SignRepository{

	@Autowired
	SqlSession sqlSession;

	private final static String namespace = "SignMapper";

	@Override
	public int insertUser(User user) {

		return sqlSession.insert(namespace + ".insertUser", user);
	}

	@Override
	public User selectUserByIdPw(Map<String, Object> params) {

		return sqlSession.selectOne(namespace + ".selectUserByIdPw", params);
	}

	@Override
	public int insertAutosign(int userIdx, String token) {
		Map<String, Object> params = new HashMap<>();
		params.put("userIdx", userIdx);
		params.put("token", token);

		return sqlSession.insert(namespace + ".insertAutoSign", params);
	}

	@Override
	public Autosign selectAutosign(String token) {
		Autosign autosign = new Autosign();
		autosign.setToken(token);

		return sqlSession.selectOne(namespace + ".selectAutoSign", autosign);
	}

	@Override
	public int insertUserPoint(int userIdx, int point) {
		Map<String, Object> params = new HashMap<>();
		params.put("user_idx", userIdx);
		params.put("point", point);

		return sqlSession.insert(namespace + ".insertUserPoint", params);
	}

}
