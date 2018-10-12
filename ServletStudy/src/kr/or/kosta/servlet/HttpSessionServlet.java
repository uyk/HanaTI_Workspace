
package kr.or.kosta.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author 유예겸
 *
 */
     
public class HttpSessionServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = "유예겸";
		HttpSession session = request.getSession();
		System.out.println(session.isNew());
		session.setAttribute("userName", name);
		
		response.sendRedirect("hello2.do");
	}
}
