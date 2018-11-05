package kr.or.kosta.sjrent.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.or.kosta.sjrent.common.controller.Controller;
import kr.or.kosta.sjrent.common.controller.ModelAndView;
import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.user.domain.User;
import kr.or.kosta.sjrent.user.service.UserService;
import kr.or.kosta.sjrent.user.service.UserServiceImpl;

/**
 * 로그인 역할을 수행하는 컨트롤러
 * 
 * @author 유예겸
 *
 */

public class UserLoginController implements Controller {
	private UserService userService;
	private JSONObject obj;
	private ModelAndView mav;
	private XMLObjectFactory factory;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		obj = new JSONObject();
		mav = new ModelAndView();
		factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		userService = (UserService) factory.getBean(UserServiceImpl.class);
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		User user = null;
		try {
			user = userService.certify(id, pw);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 로그인 실패시 응답으로 fail 보냄
		if (user == null) {
			// return type은 json으로
			obj.put("result", "fail");
		}
		// 로그인 성공시 응답으로 success 보내고 쿠키에 추가
		else {
			obj.put("result", "success");
		    Cookie cookie = new Cookie("loginId", id);
		    cookie.setPath("/");
		    response.addCookie(cookie);
		    request.getServletContext().setAttribute("loginId", id);
		}
		
		// 응답으로 json 객체 보내고 컨트롤러 종료
		try {
			response.getWriter().print(obj);
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mav;
	}

}
