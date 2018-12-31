package org.spring.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.spring.my.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{

	@Autowired
	SqlSession sqlsession;

	private final static String namespace = "UserMapper";

	@Override
	public List<User> selectAllUser() {

		return sqlsession.selectList(namespace + ".selectAllUser");
	}

}
