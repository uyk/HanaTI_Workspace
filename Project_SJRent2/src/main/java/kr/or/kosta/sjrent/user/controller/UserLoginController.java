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
		String where = request.getParameter("login");			// ajax로 응답 받고싶으면 login은 'ajax'

		
		User user = null;
		Cookie cookie = null;			// 로그인아이디 쿠키
		Cookie cookie2 = null;			// 아이디저장 쿠키
		
		// checkbox 아이디 저장시 쿠키에 저장
		if (remember != null) {
			Cookie[] cookies = request.getCookies();
			for (Cookie cookie3 : cookies) {
				if(cookie3.getName().equals("saveId")) {
					cookie3.setMaxAge(0);
				}
			}
			cookie2 = new Cookie("saveId", id);
			cookie2.setPath("/");
			response.addCookie(cookie2);
			// request.getServletContext().setAttribute("loginId", id);
			// request.setAttribute("loginId", id);
			// checkbox 클릭 안할시 null
		} /*
			 * else {
			 * 
			 * cookie2 = new Cookie("saveId", null); cookie2.setMaxAge(0);
			 * response.addCookie(cookie2); }
			 */


		if (id != null) { // 로그인
			try {
				// 회원가입여부 확인
				user = userService.certify(id, pw);

				if (user != null) {// 회원인 경우
					cookie = new Cookie("loginId", id);
					// 로그인 쿠키 30일 저장
					cookie.setMaxAge(60 * 60 * 24 * 30);
					cookie.setPath("/");
					response.addCookie(cookie);
					request.setAttribute("loginId", id);

					mav.addObject("user", user);
					
					// hidden 처리한 요청 페이지별 처리
					// mypage 요청
					if (where != null && where.equals("myPage")) {
						mav.setView("/mypage/myPageLoginOK.jsp");
					}
					// ajax 요청한 경우
					else if(where != null && where.equals("ajax")) {
						response.getWriter().print("success");
						return null;
					}else {
						mav.setView("/index.jsp");
					}

				}
				// 회원이 아닌 경우
				else {
					
					/**
					 * 1. hidden으로 보낸 데이터를 각각 처리하는방법
					 * 	  데이터전달 및 페이지 전환
					 * 2. ajax를 통해 페이지 전환없이 비동기 처리하는 방법 
					 */
					
					// myPage.jsp 에서 로그인 실패시
					if (where != null && where.equals("myPage")) {
						response.getWriter().print("loginfail");
						return null;
					}
					// ajax 요청한 경우
					else if(where != null && where.equals("ajax")) {

						response.getWriter().print("fail");					
						return null;
					}
					// login.jsp에서 로그인 실패시
					else if(where != null && where.equals("login")){
						response.getWriter().print("loginfail");
						return null;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mav;

	}

}
