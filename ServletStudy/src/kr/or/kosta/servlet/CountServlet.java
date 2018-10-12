package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CountServlet
 */
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = 0;
		
		Cookie[] cookies = request.getCookies();
		if(cookies !=null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("count")) {
					count = Integer.parseInt(cookie.getValue());
				}
			}
		}
		count++;
		Cookie cookie = new Cookie("count", String.valueOf(count));
		cookie.setMaxAge(60*60*24*30);
		response.addCookie(cookie);

		response.setContentType("text/html; charset=utf-8");	
		PrintWriter out = response.getWriter();
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Count</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style=\"text-fize:20px;\"");
		out.println("<h2>" + count + "</h2>");
		out.println("</body>");
		out.println("</html>");
	}

}
