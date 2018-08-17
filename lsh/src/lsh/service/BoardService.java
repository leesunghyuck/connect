package lsh.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import lsh.mapper.BoardMapper;

@Service
public class BoardService {

	@Resource
	private BoardMapper boardMapper;

	public List<BoardVO> getBoardList() throws SQLException{
		return boardMapper.getBoardList();
	}

	public BoardVO getViewList(String seq) throws SQLException{
		return boardMapper.getViewList(seq);
	}

	public Integer totalCount() throws SQLException{
		return boardMapper.totalCount();
	}

	public void boardDelete(String seq) throws SQLException{
		boardMapper.boardDelete(seq);
	}

	public void boardInsert(BoardVO boardVO) throws SQLException {
		boardMapper.boardInsert(boardVO);
	}
}
