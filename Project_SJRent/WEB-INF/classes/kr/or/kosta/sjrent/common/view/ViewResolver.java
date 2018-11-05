package kr.or.kosta.sjrent.common.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * View 선택 및 실행
 * @author 남수현
 *
 */
public class ViewResolver{
	
	public View resolve(String path) throws ServletException{
		View view = new JSPView(path);
//		View view = new XXXView(path);
		return view;
	}
}
