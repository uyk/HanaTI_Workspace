package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**	
 * Servlet implementation class HelloServlet2
 */
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int count = 0;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답 메시지의 헤더에 컨텐츠 유형 설정
//		String id = "bangry";
		String id = "방그리";
		Cookie cookie = new Cookie("loginId", id);		// 쿠키에서 value는 string만 됨
//		cookie.setMaxAge(60*60*24*30);
		response.addCookie(cookie);
		response.sendRedirect("hello2");
	}

}
