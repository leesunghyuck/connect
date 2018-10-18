package study.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Resource
	private BoardDao boardDao;

	public List<BoardVO> pagedList() throws Exception {
		List<BoardVO> resultList = boardDao.getBoardList();
		return resultList;
	}
}
