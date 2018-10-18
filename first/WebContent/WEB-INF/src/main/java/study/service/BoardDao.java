package study.service;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface BoardDao {
	public List<BoardVO> getBoardList() throws Exception;
}
