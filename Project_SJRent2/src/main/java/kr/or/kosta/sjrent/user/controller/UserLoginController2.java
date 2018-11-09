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

public class UserLoginController2 implements Controller {
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

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String cellphone = request.getParameter("cellphone");
		
		System.out.println("넘어온 name : " + name);
		System.out.println("넘어온 email : " + email);
		System.out.println("넘어온 cellphone : " + cellphone);
		
		// 비회원 로그인 실패시 응답으로 fail 보냄
		if (email == null) {
			// return type은 json으로
			obj.put("result", "fail");
			try {
				response.getWriter().print(obj);
				return null;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 비회원 로그인 성공시 응답으로 success 보내고 쿠키에 추가
		else {
			obj.put("result", "success");
		    Cookie cookie = new Cookie("loginEmail", email);
		    cookie.setPath("/");
		    response.addCookie(cookie);
		    request.getServletContext().setAttribute("loginEmail", email);
		    
			mav.setView("/index.jsp");
			
		}

		return mav;
	}

}
