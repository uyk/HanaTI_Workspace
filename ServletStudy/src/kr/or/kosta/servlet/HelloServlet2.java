package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**	
 * Servlet implementation class HelloServlet2
 */
public class HelloServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 웹클라이언트로 동적 출력하고자 하는 데이터 생성
		Calendar now = Calendar.getInstance();
		String nowString = String.format("%1$tF %1tT", now);
		String cookieValue = null;

		// 응답 메시지의 헤더에 컨텐츠 유형 설정
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body>");
		out.println("<h2>오늘은" + nowString + "입니다...</h2>");
		out.println("<h2>"+ request.getSession().getAttribute("userName") +"</h2>");
		out.println("<h2> 쿠키"+ request.getCookies()[0].getName() +"</h2>");
		
		out.println("</body>");
		out.println("</html>");
		
		cookieValue = URLDecoder.decode(cookieValue, "utf-8");
	}

}
