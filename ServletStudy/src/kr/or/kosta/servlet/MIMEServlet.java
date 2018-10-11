package kr.or.kosta.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *  음악서비스 서블릿
 */
public class MIMEServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String path = "C:\\KOSTA187\\workspace\\ServletStudy\\WebContent\\assets\\";
//	private String file = "sample.mp3";
	private String file = "sample.pptx";

	// service, init 메소드 동작

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답 메시지의 헤더에 컨텐츠 유형 설정
//		response.setContentType("audio/mpeg");	// Content-Type:text/plain; charset=utf-8		
		response.setContentType("application/vnd.ms-powerpoint");	// Content-Type:text/plain; charset=utf-8		

	     // 바이트입력스트림 생성		( 음악은 바이트로 되어있기 대문에 printwriter로 안됨 )
	     InputStream in = new FileInputStream(path + file);
	     // response가 제공하는 바이트입력스트림 취득
	     OutputStream out = response.getOutputStream();
	     byte[] buffer = new byte[1024];
	     int count = 0;
	     try{
	          while( (count = in.read(buffer)) != -1){
	               out.write(buffer, 0, count);
	          }
	     }finally{
	          if(out != null) out.close();
	          if(in != null) in.close();
	     }

	}

}
