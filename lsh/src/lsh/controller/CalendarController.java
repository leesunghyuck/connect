package lsh.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lsh.service.CalendarService;
import lsh.service.CalendarVO;

@Controller
public class CalendarController {

	@Resource
	private CalendarService calendarService;

	@RequestMapping("/calendar/calendar.do")
	public String calendar(Model model) throws SQLException {

		List<CalendarVO> calList = calendarService.getCalAllList();

		Map<Integer, List<Integer>> map = calendarService.getCalendar("2018", "5");

		model.addAttribute("map", map);
		model.addAttribute("calList", calList);

		return "/calendar/calendar";

	}

	@RequestMapping("/calendar/calendarView.do")
	public String calendarView(Model model, String divId) throws SQLException {

		List<CalendarVO> calList = calendarService.getCalList(Integer.parseInt(divId));

		model.addAttribute("calList", calList);

		return "/calendar/calendarView";
	}

	@RequestMapping("/calendar/calendarWriteForm.do")
	public String calendarWriteForm(Model model) throws SQLException {

		return "/calendar/calendarWrite";
	}

	@RequestMapping("/calendar/new.do")
	public String newdo(Model model) throws SQLException {

		return "/calendar/NewFile";
	}

	@RequestMapping("/calendar/calendarWrite.do")
	public String calendarWrite(Model model, CalendarVO calendarVO) throws SQLException {

		int leng = calendarVO.getEndDay()-calendarVO.getStartDay()+1;
		int end = 7 - leng;
		calendarVO.setLeng(leng);
		calendarVO.setEnd(end);

		System.out.println(calendarVO);
		calendarService.insertCalendar(calendarVO);

		return "redirect:/calendar/calendar.do";
	}

}

