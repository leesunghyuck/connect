package org.spring.my.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.spring.my.domain.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PostRepositoryImpl implements PostRepository{

	@Autowired
	SqlSession sqlSession;

	private final static String namespace = "PostMapper";

	@Override
	public List<Post> selectAllPost() {

		return sqlSession.selectList(namespace + ".selectAllPost");
	}

	@Override
	public List<Post> selectAllUserPost() {

		return sqlSession.selectList(namespace + ".selectAllUserPost");
	}
}
