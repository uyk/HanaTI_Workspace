package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");	
		PrintWriter out = response.getWriter();
		

		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		Cookie[] cookies = request.getCookies();
		
		// 첫 접속
		if(cookies == null) {
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(60*60*24*30);
			response.addCookie(cookie);
		}
		
		// 그 외
		else {
			
		}
		 
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Count</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style=\"text-fize:20px;\"");
		out.println("</body>");
		out.println("</html>");
	}

}
