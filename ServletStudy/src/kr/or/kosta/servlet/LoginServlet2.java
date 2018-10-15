package kr.or.kosta.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**	
 */
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 로그인 처리
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답 메시지의 헤더에 컨텐츠 유형 설정
		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		
		// UserDao를 이용한 회원가입여부 체크
		// 무조건 회원이라는 가정
		Cookie cookie = new Cookie("loginId", id);		// 쿠키에서 value는 string만 됨
//		cookie.setMaxAge(60*60*24*30);
		cookie.setPath("/");
		response.addCookie(cookie);
		response.sendRedirect("index.do");
	}
	
	//로그아웃처리
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				System.out.println("[logout]" + cookie.getName() + " : " + cookie.getValue());
				if(cookie.getName().equals("loginId")) {
					cookie.setPath("/");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}
		response.sendRedirect("index.do");
		
	}

}
