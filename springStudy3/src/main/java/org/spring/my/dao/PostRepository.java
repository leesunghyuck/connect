package org.spring.my.dao;

import java.util.List;

import org.spring.my.domain.Post;

public interface PostRepository {

	List<Post> selectAllPost();

	List<Post> selectAllUserPost();
}
