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
		// 로그아웃 요청
		response.setContentType("text/html; charset=utf-8");	
		PrintWriter out = response.getWriter();
		out.print("<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"utf-8\">\r\n" + 
				"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/basic.css\">\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"\r\n" + 
				"<div class=\"header\">\r\n" + 
				"  <h1>My Website</h1>\r\n" + 
				"  <p>Resize the browser window to see the effect.</p>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div class=\"topnav\">\r\n" + 
				"  <a href=\"#\">Link</a>\r\n" + 
				"  <a href=\"#\">Link</a>\r\n" + 
				"  <a href=\"#\">Link</a>\r\n" + 
				"  <a href=\"#\" style=\"float:right\">Link</a>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div class=\"row\">\r\n" + 
				"  <div class=\"leftcolumn\">\r\n" + 
				"    <div class=\"card\">\r\n" + 
				"      <h2>TITLE HEADING</h2>\r\n" + 
				"      <h5>Title description, Dec 7, 2017</h5>\r\n" + 
				"      <div class=\"fakeimg\" style=\"height:200px;\">Image</div>\r\n" + 
				"      <p>Some text..</p>\r\n" + 
				"      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>\r\n" + 
				"    </div>\r\n" + 
				"    <div class=\"card\">\r\n" + 
				"      <h2>TITLE HEADING</h2>\r\n" + 
				"      <h5>Title description, Sep 2, 2017</h5>\r\n" + 
				"      <div class=\"fakeimg\" style=\"height:200px;\">Image</div>\r\n" + 
				"      <p>Some text..</p>\r\n" + 
				"      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"  \r\n" + 
				"  <div class=\"rightcolumn\">\r\n" + 
				"    <div class=\"card\">\r\n" + 
				"      <div id=\"loginDiv\">\r\n" + 
				"        <form action=\"/servlet/login.do\" method=\"post\">\r\n" + 
				"          <input type=\"text\" id=\"userid\" name=\"userid\" placeholder=\"Identifier...\">\r\n" + 
				"          <input type=\"password\" id=\"userpw\" name=\"userpw\" placeholder=\"Password...\">\r\n" + 
				"          <input type=\"submit\" value=\"Login\">\r\n" + 
				"        </form>\r\n" + 
				"      </div>\r\n" + 
				"      \r\n" + 
				"      \r\n" + 
				"    </div>\r\n" + 
				"    \r\n" + 
				"    <div class=\"card\">\r\n" + 
				"      <h3>Popular Post</h3>\r\n" + 
				"      <div class=\"fakeimg\"><p>Image</p></div>\r\n" + 
				"      <div class=\"fakeimg\"><p>Image</p></div>\r\n" + 
				"      <div class=\"fakeimg\"><p>Image</p></div>\r\n" + 
				"    </div>\r\n" + 
				"    <div class=\"card\">\r\n" + 
				"      <h3>Follow Me</h3>\r\n" + 
				"      <p>Some text..</p>\r\n" + 
				"    </div>\r\n" + 
				"  </div>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"<div class=\"footer\">\r\n" + 
				"  <h2>Footer</h2>\r\n" + 
				"</div>\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html; charset=utf-8");	
		PrintWriter out = response.getWriter();
		

		String id = request.getParameter("userid");
		String pw = request.getParameter("userpw");
		
		
		// 첫 접속
		Cookie[] cookies = request.getCookies();
		if(cookies == null) {
			Cookie idCookie = new Cookie("id", id);
			idCookie.setMaxAge(60*60*24*30);
			response.addCookie(idCookie);
			Cookie pwCookie = new Cookie("pw", pw);
			pwCookie.setMaxAge(60*60*24*30);
			response.addCookie(pwCookie);
		}
		
		// 그 외
		else {
			Cookie idCookie = new Cookie("id", id);
			idCookie.setMaxAge(60*60*24*30);
			response.addCookie(idCookie);
			Cookie pwCookie = new Cookie("pw", pw);
			pwCookie.setMaxAge(60*60*24*30);
			response.addCookie(pwCookie);
		}
		
		// 로그인 성공
		if(id.equals("bangry") || pw.equals("1234")) {
			out.print("<!DOCTYPE html>\r\n" + 
					"<html>\r\n" + 
					"<head>\r\n" + 
					"<meta charset=\"utf-8\">\r\n" + 
					"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/basic.css\">\r\n" + 
					"\r\n" + 
					"</head>\r\n" + 
					"<body>\r\n" + 
					"\r\n" + 
					"<div class=\"header\">\r\n" + 
					"  <h1>My Website</h1>\r\n" + 
					"  <p>Resize the browser window to see the effect.</p>\r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"<div class=\"topnav\">\r\n" + 
					"  <a href=\"#\">Link</a>\r\n" + 
					"  <a href=\"#\">Link</a>\r\n" + 
					"  <a href=\"#\">Link</a>\r\n" + 
					"  <a href=\"#\" style=\"float:right\">Link</a>\r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"<div class=\"row\">\r\n" + 
					"  <div class=\"leftcolumn\">\r\n" + 
					"    <div class=\"card\">\r\n" + 
					"      <h2>TITLE HEADING</h2>\r\n" + 
					"      <h5>Title description, Dec 7, 2017</h5>\r\n" + 
					"      <div class=\"fakeimg\" style=\"height:200px;\">Image</div>\r\n" + 
					"      <p>Some text..</p>\r\n" + 
					"      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"card\">\r\n" + 
					"      <h2>TITLE HEADING</h2>\r\n" + 
					"      <h5>Title description, Sep 2, 2017</h5>\r\n" + 
					"      <div class=\"fakeimg\" style=\"height:200px;\">Image</div>\r\n" + 
					"      <p>Some text..</p>\r\n" + 
					"      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>\r\n" + 
					"    </div>\r\n" + 
					"  </div>\r\n" + 
					"  \r\n" + 
					"  <div class=\"rightcolumn\">\r\n" + 
					"    <div class=\"card\">\r\n" + 
					"      \r\n" + 
					"      <div id=\"logoutDiv\">\r\n" + 
					"        <form action=\"/servlet/login.do\">\r\n" + 
					"          <label id=\"userInfo\">"+ id +"님이 로그인중..</label>\r\n" + 
					"          <input type=\"submit\" value=\"Logout\">\r\n" + 
					"        </form>\r\n" + 
					"      </div>\r\n" + 
					"      \r\n" + 
					"    </div>\r\n" + 
					"    \r\n" + 
					"    <div class=\"card\">\r\n" + 
					"      <h3>Popular Post</h3>\r\n" + 
					"      <div class=\"fakeimg\"><p>Image</p></div>\r\n" + 
					"      <div class=\"fakeimg\"><p>Image</p></div>\r\n" + 
					"      <div class=\"fakeimg\"><p>Image</p></div>\r\n" + 
					"    </div>\r\n" + 
					"    <div class=\"card\">\r\n" + 
					"      <h3>Follow Me</h3>\r\n" + 
					"      <p>Some text..</p>\r\n" + 
					"    </div>\r\n" + 
					"  </div>\r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"<div class=\"footer\">\r\n" + 
					"  <h2>Footer</h2>\r\n" + 
					"</div>\r\n" + 
					"\r\n" + 
					"</body>\r\n" + 
					"</html>\r\n" + 
					"");
		}
		else {
			out.print("<!DOCTYPE html>\r\n" + 
			"<html>\r\n" + 
			"<head>\r\n" + 
			"<meta charset=\"utf-8\">\r\n" + 
			"<link rel=\"stylesheet\" type=\"text/css\" href=\"css/basic.css\">\r\n" + 
			"</head>\r\n" + 
			"<body>\r\n" + 
			"\r\n" + 
			"<div class=\"header\">\r\n" + 
			"  <h1>My Website</h1>\r\n" + 
			"  <p>Resize the browser window to see the effect.</p>\r\n" + 
			"</div>\r\n" + 
			"\r\n" + 
			"<div class=\"topnav\">\r\n" + 
			"  <a href=\"#\">Link</a>\r\n" + 
			"  <a href=\"#\">Link</a>\r\n" + 
			"  <a href=\"#\">Link</a>\r\n" + 
			"  <a href=\"#\" style=\"float:right\">Link</a>\r\n" + 
			"</div>\r\n" + 
			"\r\n" + 
			"<div class=\"row\">\r\n" + 
			"  <div class=\"leftcolumn\">\r\n" + 
			"    <div class=\"card\">\r\n" + 
			"      <h2>TITLE HEADING</h2>\r\n" + 
			"      <h5>Title description, Dec 7, 2017</h5>\r\n" + 
			"      <div class=\"fakeimg\" style=\"height:200px;\">Image</div>\r\n" + 
			"      <p>Some text..</p>\r\n" + 
			"      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>\r\n" + 
			"    </div>\r\n" + 
			"    <div class=\"card\">\r\n" + 
			"      <h2>TITLE HEADING</h2>\r\n" + 
			"      <h5>Title description, Sep 2, 2017</h5>\r\n" + 
			"      <div class=\"fakeimg\" style=\"height:200px;\">Image</div>\r\n" + 
			"      <p>Some text..</p>\r\n" + 
			"      <p>Sunt in culpa qui officia deserunt mollit anim id est laborum consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco.</p>\r\n" + 
			"    </div>\r\n" + 
			"  </div>\r\n" + 
			"  \r\n" + 
			"  <div class=\"rightcolumn\">\r\n" + 
			"    <div class=\"card\">\r\n" + 
			"      <div id=\"loginDiv\">\r\n" + 
			"        <form action=\"/servlet/login.do\" method=\"post\">\r\n" + 
			"          <input type=\"text\" id=\"userid\" name=\"userid\" placeholder=\"Identifier...\">\r\n" + 
			"          <input type=\"password\" id=\"userpw\" name=\"userpw\" placeholder=\"Password...\">\r\n" + 
			"          <input type=\"submit\" value=\"Login\">\r\n" + 
			"          <label id=\"failL\">로그인 실패</label>" +
			"        </form>\r\n" + 
			"      </div>\r\n" + 
			"      \r\n" + 
			"      \r\n" + 
			"    </div>\r\n" + 
			"    \r\n" + 
			"    <div class=\"card\">\r\n" + 
			"      <h3>Popular Post</h3>\r\n" + 
			"      <div class=\"fakeimg\"><p>Image</p></div>\r\n" + 
			"      <div class=\"fakeimg\"><p>Image</p></div>\r\n" + 
			"      <div class=\"fakeimg\"><p>Image</p></div>\r\n" + 
			"    </div>\r\n" + 
			"    <div class=\"card\">\r\n" + 
			"      <h3>Follow Me</h3>\r\n" + 
			"      <p>Some text..</p>\r\n" + 
			"    </div>\r\n" + 
			"  </div>\r\n" + 
			"</div>\r\n" + 
			"\r\n" + 
			"<div class=\"footer\">\r\n" + 
			"  <h2>Footer</h2>\r\n" + 
			"</div>\r\n" + 
			"\r\n" + 
			"</body>\r\n" + 
			"</html>");
		}
	}

}
