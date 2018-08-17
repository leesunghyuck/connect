package lsh;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello.do")
	public String Hello() {

		System.out.println("test");

		return "/hello";
	}

}
