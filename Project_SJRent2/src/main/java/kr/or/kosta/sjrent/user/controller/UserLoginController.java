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
		String remember = request.getParameter("remember");
		String where = request.getParameter("login"); 
		
		User user = null;
		Cookie cookie = null; 

		if (id != null) { //로그인 
			try {
				// 회원가입여부 확인 
				user = userService.certify(id, pw);
				
				if (user != null) {// 회원인 경우 
					cookie = new Cookie("loginId", id);
					cookie.setMaxAge(60*60*24*30);
					cookie.setPath("/");
					response.addCookie(cookie);
					
					request.setAttribute("loginId", id);
					
					mav.addObject("user", user);
					
					// hidden 처리한 요청 페이지별 처리
					if(where.equals("myPage")) {
						mav.setView("/mypage/myPageLoginOK.jsp");
						
					//System.out.println(mav);
					}else {
						mav.setView("/index.jsp");
					}
					
				}
				//회원이 아닌 경우 
				else {
					
					// hidden 처리한 요청 페이지별 처리
					if(where.equals("myPage")) {
						mav.setView("/mypage/myPage.jsp");
						
					//System.out.println(mav);
					}else {
						mav.setView("/index.jsp");
					return null;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				}	
			}
			
	

		Cookie cookie2 = null; 
		// checkbox 아이디 저장시 쿠키에 저장		
		if (remember != null) {
			
			cookie2 = new Cookie("saveId", id);
			cookie2.setPath("/");	
			response.addCookie(cookie2);
			//request.getServletContext().setAttribute("loginId", id);
			//request.setAttribute("loginId", id);
		// checkbox 클릭 안할시 null
		}/*else {
			
			cookie2 = new Cookie("saveId", null);
			cookie2.setMaxAge(0);
			response.addCookie(cookie2);
		}*/
		

		// System.out.println(mav);
		return mav;

	}
		
	}

