package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 마임타입 이해를 위한 서블릿
 */
public class MIMEServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// service, init 메소드 동작

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답 메시지의 헤더에 컨텐츠 유형 설정
		response.setContentType("text/plain; charset=utf-8");	// Content-Type:text/plain; charset=utf-8		
		PrintWriter out = response.getWriter();
		out.println("일반적인 텍스트입니다..");
	}

}
