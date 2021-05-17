package board.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import board.bean.BoardDTO;
import board.dao.BoardDAO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value = "/board/boardDelete.do")
	public ModelAndView boardDelete(HttpServletRequest request, HttpServletResponse response) {
		//데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//DB
		//BoardDAO dao = new BoardDAO();
		int result = boardService.boardDelete(seq); 		
		
		// 화면 네비게이션 : 데이터 공유 + view 처리 파일 선택
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result",result);
		modelAndView.addObject("pg",pg);		
		modelAndView.setViewName("boardDelete.jsp");	
		
		return modelAndView;
		
		//request.setAttribute("result", result);
		//request.setAttribute("pg", pg);
		
		//return "boardDelete";
	}
	
	@RequestMapping(value = "/board/boardList.do")
	public ModelAndView boardList(HttpServletRequest request, HttpServletResponse response) {		
		//데이터 처리 
	    int pg = 1;
	    if(request.getParameter("pg")!= null) {
	         pg = Integer.parseInt(request.getParameter("pg"));
	    }
	    // 목록 : 5개
	    int limit = 5;
	    int endNum = pg*limit;  // 1 * 5 = 5
	    int startNum = endNum - (limit -1); // 5 - (5-1) = 1
	    
	    //BoardDAO dao = new BoardDAO();
	    List<BoardDTO> list = boardService.boardList(startNum, endNum);	    
	    
	    // 페이징 : 3블럭
	    int totalA = boardService.getTotal();
	    int totalP = (totalA + (limit -1))/ limit;
	    
	    int startPage = (pg-1)/3*3+1;
	    int endPage = startPage + 2;
	    if(endPage > totalP) endPage = totalP;  
	    
	    // 화면 네비게이션
	    ModelAndView modelAndView = new ModelAndView();
	    modelAndView.addObject("pg", pg);
	    modelAndView.addObject("list", list);
	    modelAndView.addObject("totalP", totalP);
	    modelAndView.addObject("startPage", startPage);
	    modelAndView.addObject("endPage", endPage);
	    
	    modelAndView.setViewName("boardList.jsp");
	    return modelAndView;
	    
//	    request.setAttribute("pg", pg);
//	    request.setAttribute("list", list);
//	    request.setAttribute("totalP", totalP);
//	    request.setAttribute("startPage", startPage);
//	    request.setAttribute("endPage", endPage); 
//	    
//		return "boardList";
	}
	
	@RequestMapping(value = "/board/boardView.do")
	public ModelAndView boardView(HttpServletRequest request, HttpServletResponse response) {
		//데이터
		int seq = Integer.parseInt(request.getParameter("seq"));
		int pg = Integer.parseInt(request.getParameter("pg"));
		
		//DB
		//BoardDAO dao = new BoardDAO();			
		// 조회수 증가하기		
		boardService.updateHit(seq);
		BoardDTO dto = boardService.boardView(seq); 
		
		// 화면 네비게이션 : 데이터 공유 + view 처리 파일 선택
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("seq", seq);
		modelAndView.addObject("pg", pg);
		modelAndView.addObject("dto", dto);		
		modelAndView.setViewName("boardView.jsp");
		
		return modelAndView;
		
		//request.setAttribute("seq", seq);
		//request.setAttribute("pg", pg);
		//request.setAttribute("dto", dto);				
		//return "boardView";
	}
	
	@RequestMapping(value = "/board/boardWrite.do")
	public ModelAndView boardWrite(HttpServletRequest request, HttpServletResponse response) {
		//데이터
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		String name = (String)session.getAttribute("memName");
		String id = (String)session.getAttribute("memId");
		
		//DB
		BoardDTO dto = new BoardDTO();
		dto.setId(id);
		dto.setName(name);
		dto.setSubject(subject);
		dto.setContent(content);
		
		//BoardDAO dao = new BoardDAO();
		int result = boardService.boardWrite(dto); 		
		
		// 화면 네비게이션 : 데이터 공유 + view 처리 파일 선택
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("result", result);
		modelAndView.setViewName("boardWrite.jsp");
				
		return modelAndView;
		
		//request.setAttribute("result", result);		
		//return "boardWrite";
	}
	
	@RequestMapping(value = "/board/boardWriteForm.do")
	public ModelAndView boardWriteForm(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("boardWriteForm.jsp");
		
		return modelAndView;
	}
}
