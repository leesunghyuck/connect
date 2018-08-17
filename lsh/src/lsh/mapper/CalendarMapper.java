package lsh.mapper;

import java.sql.SQLException;
import java.util.List;

import lsh.service.CalendarVO;

public interface CalendarMapper {
	public List<CalendarVO> getCalAllList() throws SQLException;

	public void insertCalendar(CalendarVO carlendarVO) throws SQLException;

	public List<CalendarVO> getCalList(int seq) throws SQLException;

}
