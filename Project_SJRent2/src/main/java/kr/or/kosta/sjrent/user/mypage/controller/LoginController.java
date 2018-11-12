package kr.or.kosta.sjrent.user.mypage.controller;

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
 * @author 최재민
 *
 */

public class LoginController implements Controller {
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
		
		//System.out.println("[Debug] Controller에서 받은 아이디 : "+id);

		
		User user = null;
		Cookie cookie = null; 

		if (id != null) { //로그인 
			try {
				// 회원가입여부 확인 
				user = userService.certify(id, pw);
				//System.out.println("[Debug] 서버에서 넘어온 user : " + user);
				
				if (user != null) {// 회원인 경우 
					cookie = new Cookie("loginId", id);
					cookie.setMaxAge(60*60*24*30);
					cookie.setPath("/");
					response.addCookie(cookie);
					
					request.setAttribute("loginId", id);
					request.setAttribute("loginPw", pw);
					
					mav.addObject("user", user);
					mav.setView("/mypage/myPageLoginOK.jsp");
					//System.out.println(mav);
					
					
				}else {//회원이 아닌 경우 
					response.sendRedirect("/mypage/myPage.jsp");
					return null;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
				
				}	
			
			
			}
			
	

		return mav;

	}
		
	}

