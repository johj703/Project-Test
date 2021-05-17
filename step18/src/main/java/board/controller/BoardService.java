package board.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.bean.BoardDTO;

public interface BoardService {
	
	// 저장
	public int boardWrite(BoardDTO dto);
				
	// 삭제
	public int boardDelete(int seq);
				
	// 상세보기
	public BoardDTO boardView(int seq);
				
	// 목록보기
	public List<BoardDTO> boardList(int startNum, int endNum);
				
	// 전체데이터 갯수 구하기
	public int getTotal();
				
	// 조회수 증가하기
	public int updateHit(int seq);
}
