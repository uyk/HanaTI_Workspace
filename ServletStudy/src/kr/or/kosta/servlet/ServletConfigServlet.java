
package kr.or.kosta.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 유예겸
 *
 */
     
public class ServletConfigServlet extends HttpServlet {
	String driver = "";

	@Override
	public void init(ServletConfig config) throws ServletException {
		driver = config.getInitParameter("driver");
		super.init(config);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(driver);
	}
}
