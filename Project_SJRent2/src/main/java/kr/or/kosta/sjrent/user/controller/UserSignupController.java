package kr.or.kosta.sjrent.user.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

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
 * @author 윤형철
 *
 */

public class UserSignupController implements Controller {
	private UserService userService;
	private JSONObject obj;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		obj = new JSONObject();
		mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		userService = (UserService) factory.getBean(UserServiceImpl.class);


		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email1 = request.getParameter("email1");
		String email2 = request.getParameter("email2");
		String email_select = request.getParameter("email_select");
		String email = email1 + "@" + email2 + email_select; 
		String password = request.getParameter("password");
		String birthday = request.getParameter("birthday");
		int point = 10000;
		int gender = Integer.parseInt(request.getParameter("gender"));
		String cellphone1 = request.getParameter("cellphone1");
		String cellphone2 = request.getParameter("cellphone2");
		String cellphone3 = request.getParameter("cellphone3");
		String cellphone = cellphone1 + "-" + cellphone2 + "-" + cellphone3; 
		int isUser = 1;
		

		User user = new User();
		boolean isCreate = false;
				
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setBirthday(birthday);
		user.setGender(gender);
		user.setCellphone(cellphone);
		user.setIsUser(isUser);
		user.setPoint(point);


		System.out.println("회원가입요청: "+user);
		
		try {
			isCreate = userService.create(user);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 회원가입 실패시 응답으로 fail 보냄
		if (isCreate == false) {
			obj.put("result", "fail");
			try {
				response.sendRedirect("/sjrent/user/regist.jsp");
				//response.getWriter().print(obj);
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// 회원가입 성공시 응답으로 success 보냄
		else {
			obj.put("result", "success");
			mav.addObject("id", id);
			mav.addObject("email", email);
			mav.addObject("cellphone", cellphone);

			mav.setView("/user/regist_result.jsp");
			
		}
		return mav;
	}

}