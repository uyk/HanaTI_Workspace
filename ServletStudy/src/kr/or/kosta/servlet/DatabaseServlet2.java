package kr.or.kosta.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbcp2.BasicDataSource;

import kr.or.kosta.dao.JdbcUserDAO;
import kr.or.kosta.dao.User;

/**	
 * Servlet implementation class HelloServlet2
 */
public class DatabaseServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521";
	private static final String USER_ID = "hr";
	private static final String USER_PW = "hr";
	private static final int MAX_COUNT = 5;
	private static final int IDLE_COUNT = 2;
	JdbcUserDAO dao;
	
	@Override
	public void init() throws ServletException {
		dao = new JdbcUserDAO();
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DRIVER_NAME);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(USER_ID);
		dataSource.setPassword(USER_PW);
		dataSource.setInitialSize(MAX_COUNT);
		dataSource.setMaxIdle(IDLE_COUNT);
		dataSource.setMaxTotal(10);
		
		dao.setDataSource(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<User> list = null;
		try {
			list = dao.listAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		// 응답 메시지의 헤더에 컨텐츠 유형 설정
		response.setContentType("text/html; charset=utf-8");	
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Servlet Programming</title>");
		out.println("<meta charset=\"utf-8\">");
		out.println("</head>");
		out.println("<body style=\"text-fize:20px;\"");
		out.println("<table border='1' width='50%'>");
		for (User user : list) {
			System.out.println(user);
		}

		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		
		
		// 디스패치 기술
		response.sendRedirect("/servlet/hello.do");
	}

}
