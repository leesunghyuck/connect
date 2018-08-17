package lsh.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import lsh.service.BoardService;
import lsh.service.BoardVO;

@Controller
public class BoardController {

	@Resource
	private BoardService boardService;

	@RequestMapping("/board/boardList.do")
	public String boardList(Model model, SessionStatus sessionStatus) throws SQLException {

		List<BoardVO> boardList = boardService.getBoardList();
		int totalCount = boardService.totalCount();

		model.addAttribute("totalCount", totalCount);
		model.addAttribute("boardList", boardList);
System.out.println("wqe");
		return "/board/boardList";

	}

	@RequestMapping("/board/boardWriteForm.do")
	public String boardWriteForm(Model model) throws SQLException {

		return "/board/boardWrite";

	}

	@RequestMapping("/board/boardWrite.do")
	public String boardWrite(Model model, BoardVO boardVO) throws SQLException {
		if(boardVO.getTitle().equals("") || boardVO.getTitle() == null) {

		} else {
			boardVO.setCreateName("이성혁");
			boardService.boardInsert(boardVO);
		}

		return "/board/boardWrite";

	}

	@RequestMapping("/board/boardView.do")
	public String boardView(Model model, String seq) throws SQLException {
		BoardVO viewList = boardService.getViewList(seq);

		model.addAttribute("viewList", viewList);

		return "/board/boardView";

	}

	@RequestMapping("/board/boardDelete.do")
	public String boardDelete(Model model, String seq) throws SQLException {
		boardService.boardDelete(seq);

		return "redirect:/board/boardList.do";

	}

	@RequestMapping("/board/boardModify.do")
	public String boardModify(Model model, String seq) throws SQLException {
		BoardVO viewList = boardService.getViewList(seq);

		model.addAttribute("viewList", viewList);

		return "/board/boardWrite";

	}

}
