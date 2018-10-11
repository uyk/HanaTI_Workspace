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
public class HTTPServletResponseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답 메시지의 헤더에 컨텐츠 유형 설정
		response.setContentType("text/html; charset=utf-8");	
		

		String name = request.getParameter("name");
		if(name != null && name.length() != 0) {
			if(name.equals("bangry")) {
		//		response.setStatus(400);
		//		response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
				response.sendError(HttpServletResponse.SC_FORBIDDEN);
				return;
			}
		}
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style=\"text-fize:20px;\"");
		out.println("<ul>");
		out.println("</ul>");
		out.println("</body>");
		out.println("</html>");
	}

}
