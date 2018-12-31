package org.spring.my.controller;

import java.util.HashMap;
import java.util.Map;

import org.spring.my.resolver.SessionLogin;
import org.spring.my.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/profile/image")
	public Object profileImagePUT(@SessionLogin Integer userIdx, MultipartFile photo) {


		boolean succ = userService.updateProfileImage(userIdx, photo);

		Map<String, Object> result = new HashMap<>();
		result.put("succ", succ);

		return result;
	}

	@GetMapping("/list/all")
	public Object listAllGET() {

		return userService.selectAllUser();
	}
}
