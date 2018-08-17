package lsh.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lsh.mapper.CalendarMapper;

@Service
public class CalendarService {

	@Resource
	private CalendarMapper calendarMapper;

	public List<CalendarVO> getCalAllList() throws SQLException{
		return calendarMapper.getCalAllList();
	}

	public void insertCalendar(CalendarVO calendarVO) throws SQLException{
		calendarMapper.insertCalendar(calendarVO);
	}

	public List<CalendarVO> getCalList(int seq) throws SQLException{
		return calendarMapper.getCalList(seq);
	}

	public Map<Integer, List<Integer>> getCalendar(String year, String month) {
		//달력만들기
		Calendar c = Calendar.getInstance();

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		List<Integer> dayList = new ArrayList<Integer>();
		List<Integer> weekList1 = new ArrayList<Integer>();
		List<Integer> weekList2 = new ArrayList<Integer>();
		List<Integer> weekList3 = new ArrayList<Integer>();
		List<Integer> weekList4 = new ArrayList<Integer>();
		List<Integer> weekList5 = new ArrayList<Integer>();
		List<Integer> weekList6 = new ArrayList<Integer>();

		c.set(Calendar.YEAR, Integer.valueOf(year));
		c.set(Calendar.MONTH, Integer.valueOf(month)-1);
		c.set(Calendar.DAY_OF_MONTH, 1);

		int dayofweek = c.get(Calendar.DAY_OF_WEEK);

		c.set(Calendar.DAY_OF_MONTH, 32);

		int lastday = 32 - c.get(Calendar.DAY_OF_MONTH);

		//공백
		for(int i =0;i<dayofweek - 1; i++){
			dayList.add(0);
		}

		//날짜
		for(int day=1; day<=lastday; day++){
			dayList.add(day);
		}

		for(int j=0;j<dayList.size();j++) {
			if(j < 7) {
				weekList1.add(dayList.get(j));
				map.put(0, weekList1);
			} else if(j < 14) {
				weekList2.add(dayList.get(j));
				map.put(1, weekList2);
			} else if(j < 21) {
				weekList3.add(dayList.get(j));
				map.put(2, weekList3);
			} else if(j < 28) {
				weekList4.add(dayList.get(j));
				map.put(3, weekList4);
			} else if(j < 35) {
				weekList5.add(dayList.get(j));
				map.put(4, weekList5);
			} 	else if(j < dayList.size()) {
				weekList6.add(dayList.get(j));
				map.put(5, weekList6);
			}
		}

		return map;
	}

}
