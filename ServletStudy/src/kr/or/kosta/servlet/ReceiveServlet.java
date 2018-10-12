package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**	
 * Servlet implementation class HelloServlet2
 */
public class ReceiveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);                                                                                                                                                                                                                                                    
	}
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답 메시지의 헤더에 컨텐츠 유형 설정
		response.setContentType("text/html; charset=utf-8");		
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("utf-8");
		
		// 요청 파라메터 수신
		String userId = request.getParameter("userid");
		String userPw = request.getParameter("userpw");
		String team = request.getParameter("teams");
		String[] hoby = request.getParameterValues("hoby");
		
		Enumeration<String> paramNames = request.getParameterNames();
		while (paramNames.hasMoreElements()) {
			String string = paramNames.nextElement();
			String value = request.getParameter(string);
			System.out.println(string + " : " + value);
		}
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style='font-size:20pt;'");
		out.println("<h3>아이디 : " + userId +"</h3>");
		out.println("<h3>비번 : " + userPw +"</h3>");
		out.println("<h3>팀 : " + team +"</h3>");
		if(hoby != null) {
			for (String string : hoby) {
				out.println("<h3>취미 : " + string +"</h3>");
			}
		}
		out.println("</body>");
		out.println("</html>");
	}

}
