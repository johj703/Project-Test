package board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.bean.BoardDTO;

@Repository // => DAO 빈 객체 설정
public class BoardDAO {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	// 저장
	public int boardWrite(BoardDTO dto) {	
		return sqlSession.insert("mybatis.boardMapper.boardWrite", dto);
	}
	
	// 삭제
	public int boardDelete(int seq) {		
		return sqlSession.delete("mybatis.boardMapper.boardDelete", seq);
	}
	
	// 상세보기
	public BoardDTO boardView(int seq) {		
		return sqlSession.selectOne("mybatis.boardMapper.boardView", seq);
	}
	
	// 목록보기
	public List<BoardDTO> boardList(int startNum, int endNum) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		return sqlSession.selectList("mybatis.boardMapper.boardList", map);
	}
	// 전체데이터 갯수 구하기
	public int getTotal() {		
		return sqlSession.selectOne("mybatis.boardMapper.getTotal");
	}
	
	// 조회수 증가하기
	public int updateHit(int seq) {		
		return sqlSession.update("mybatis.boardMapper", seq);
	}
}









