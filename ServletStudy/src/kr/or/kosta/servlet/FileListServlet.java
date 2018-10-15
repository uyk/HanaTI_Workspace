package kr.or.kosta.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileListServlet
 */
public class FileListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String fileRepository;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
//		fileRepository = getServletContext().getInitParameter("Location");

		fileRepository = "C:\\KOSTA187\\workspace\\ServletStudy\\uploadFiles\\";
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filePath = fileRepository;
		File file = new File(filePath);

		// HTTP 버전별 브라우저 캐시 사용 않도록 응답헤더 설정
		String httpVersion = request.getProtocol();
		if (httpVersion.equals("HTTP/1.0")) {
			response.setDateHeader("Expires", 0);
			response.setHeader("Pragma", "no-cache");
		} else if (httpVersion.equals("HTTP/1.1")) {
			response.setHeader("Cache-Control", "no-cache");
		}
		// 디렉토리가 아니면
		if(!(file.isDirectory())) return; 
		File[] files = file.listFiles();
		
		// html출력 Response
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println(
				"<!DOCTYPE html>\r\n" + 
				"<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"utf-8\">\r\n" + 
				"<title>파일목록</title>\r\n" + 
				"<style type=\"text/css\">\r\n" + 
				"body {\r\n" + 
				"  width : 60%;\r\n" + 
				"}\r\n" + 
				"h2 {\r\n" + 
				"  text-align: center;\r\n" + 
				"  font-weight: bold;\r\n" + 
				"  vertical-align: top;\r\n" + 
				"  color: #369;\r\n" + 
				"}\r\n" + 
				"table{\r\n" + 
				"    border-collapse: collapse;\r\n" + 
				"    text-align: left;\r\n" + 
				"    line-height: 1.5;\r\n" + 
				"\r\n" + 
				"}\r\n" + 
				"thead th {\r\n" + 
				"    padding: 10px;\r\n" + 
				"    font-weight: bold;\r\n" + 
				"    vertical-align: top;\r\n" + 
				"    color: #369;\r\n" + 
				"    border-bottom: 3px solid #036;\r\n" + 
				"}\r\n" + 
				"tbody th {\r\n" + 
				"    width: 150px;\r\n" + 
				"    padding: 10px;\r\n" + 
				"    font-weight: bold;\r\n" + 
				"    vertical-align: top;\r\n" + 
				"    border-bottom: 1px solid #ccc;\r\n" + 
				"    background: #f3f6f7;\r\n" + 
				"    border-right: 1px solid #036;\r\n" + 
				"}\r\n" + 
				"td {\r\n" + 
				"    width: 350px;\r\n" + 
				"    padding: 10px;\r\n" + 
				"    vertical-align: top;\r\n" + 
				"    border-bottom: 1px solid #ccc;\r\n" + 
				"    border-left: 1px solid #036;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"</style>" +
				"<script type=\"text/javascript\">\r\n" + 
				"function download(fileName) {\r\n" + 
				"	location.href=\"/servlet/download.do?file=\"+fileName;\r\n" + 
				"}\r\n" + 
				"\r\n" + 
				"</script>"+
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<h2>자료실</h2>\r\n" + 
				"<table>\r\n" + 
				"  <thead>\r\n" + 
				"    <tr>\r\n" + 
				"      <th>번호</th>\r\n" + 
				"      <th>파일명</th>\r\n" + 
				"      <th>사이즈</th>\r\n" + 
				"      <th>다운로드</th>\r\n" + 
				"    </tr>\r\n" + 
				"  </thead>\r\n" + 
				"  <tbody>\r\n");
		int i = 1;
		for (File eachFile : files) {
			System.out.println(eachFile.getName());
			out.print(
					"    <tr>\r\n" + 
					"      <th>"+ i++ +"</th>\r\n" + 
					"      <td>"+ eachFile.getName() +"</td>\r\n" + 
					"      <td>"+ eachFile.length() +"</td>\r\n" + 
					"      <td><button onclick=\"download(\'"+ eachFile.getName() +"\')\">다운로드</button></td>" + 
					"    </tr>");			
		}
		
		out.print(
				"    </tr>\r\n" + 
				"  </tbody>\r\n" + 
				"</table>\r\n" + 
				"</body>\r\n" + 
				"</html>");
	}

}
