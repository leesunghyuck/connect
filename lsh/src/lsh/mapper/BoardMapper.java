package lsh.mapper;

import java.sql.SQLException;
import java.util.List;

import lsh.service.BoardVO;

public interface BoardMapper {
	public List<BoardVO> getBoardList() throws SQLException;

	public BoardVO getViewList(String seq) throws SQLException;

	public Integer totalCount() throws SQLException;

	public void boardDelete(String seq) throws SQLException;

	public void boardInsert(BoardVO boardVO) throws SQLException;

}
