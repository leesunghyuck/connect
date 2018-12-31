package org.spring.my.dao;

import java.util.List;

import org.spring.my.domain.User;

public interface UserRepository {

	List<User> selectAllUser();
}
