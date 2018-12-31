package org.spring.my.controller;

import org.spring.my.resolver.SessionLogin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

	@GetMapping("")
	public String rootGET( Model model, @SessionLogin Integer userIdx ) {
		/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String serverTime = sdf.format(new Date());*/
		model.addAttribute("serverTime", ""+userIdx);
		return "home";
	}

	@RequestMapping("/kakao")
	public void kakao() {

	}

}
