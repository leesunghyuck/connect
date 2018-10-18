package study.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import study.service.BoardService;
import study.service.BoardVO;

@Controller
public class HomeController {

	@Resource
	private BoardService boardService;

	@RequestMapping("/index.do")
	public String home() throws Exception {

		List<BoardVO> list = boardService.pagedList();
		for (BoardVO boardVO : list) {

			System.out.println("==============");
			System.out.println(boardVO.getSeq());
			System.out.println(boardVO.getCreateName());
			System.out.println(boardVO.getContent());
			System.out.println(boardVO.getTitle());
			System.out.println(boardVO.getRn());
			System.out.println("==============");
		}
		return "/index";
	}
}
