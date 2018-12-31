package org.spring.my.service;

import java.util.List;

import org.spring.my.domain.User;
import org.springframework.web.multipart.MultipartFile;

public interface UserService {

	boolean updateProfileImage(int userIdx, MultipartFile photo);

	List<User> selectAllUser();
}
