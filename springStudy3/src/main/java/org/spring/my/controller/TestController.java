package org.spring.my.controller;

import java.util.Map;

import org.spring.my.util.Kakao;
import org.spring.my.util.Kakao.KakaoResultJson;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping("/async")
	public Object asyncGET() {

		Map<String, Object> map = new LinkedTreeMap<>();
		map.put("succ", true);

		echo("async");

		return map;
	}

	@Async
	private void echo(String str) {
		for(int i = 0; i<100000;i++) {
			System.out.println(str + " " + i);
		}
	}

	//@Scheduled(cron="*/5 * * * * *")
	public void test() {
		System.out.println("test");
	}

	@PostMapping("/kakao")
	public void kakao(String accessToken) {
		System.out.println(accessToken);

		KakaoResultJson user = Kakao.getUserInfoByAccessToken(accessToken);
		System.out.println(new GsonBuilder().setPrettyPrinting().create().toJson(user));
	}

}
