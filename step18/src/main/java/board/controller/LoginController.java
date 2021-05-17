package board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import member.dao.MemberDAO;

@Controller // @Component + Controller 인터페이스 상속
public class LoginController{
	// ModelAndView : 화면 네비게이션 담당 클래스
	// => 데이터 공유 + view 처리 파일 선택	
	@RequestMapping(value = "/member/login.do")  // HandlerMapping 클래스 설정
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 데이터
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
				
		// DB
		MemberDAO dao = new MemberDAO();
		String name = dao.login(id, pwd);
		String viewPage = "";
		
		// 화면 네비게이션
		ModelAndView modelAndView = new ModelAndView();
		
		if(name == null) {
			modelAndView.setViewName("loginForm.jsp");
			//viewPage = "loginForm";
			//viewPage = "loginForm.jsp";
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("memId", id);
			session.setAttribute("memName", name);
			// sendRedirect 방식으로 움직여야함. : 폴더명 변경
			modelAndView.setViewName("redirect:../board/boardList.do?pg=1");
			//viewPage = "../board/boardList.do?pg=1";
		}
		return modelAndView;
	}
}
