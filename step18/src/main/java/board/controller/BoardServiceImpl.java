package board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired // => 빈 객체 주입
	BoardDAO dao;

	@Override
	public int boardWrite(BoardDTO dto) {
		return dao.boardWrite(dto);
	}

	@Override
	public int boardDelete(int seq) {
		return dao.boardDelete(seq);
	}

	@Override
	public BoardDTO boardView(int seq) {
		return dao.boardView(seq);
	}

	@Override
	public List<BoardDTO> boardList(int startNum, int endNum) {
		return dao.boardList(startNum, endNum);
	}

	@Override
	public int getTotal() {
		return dao.getTotal();
	}

	@Override
	public int updateHit(int seq) {
		return dao.updateHit(seq);
	}	
}
