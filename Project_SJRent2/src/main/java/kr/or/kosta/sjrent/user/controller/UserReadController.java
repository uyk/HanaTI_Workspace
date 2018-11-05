package kr.or.kosta.sjrent.user.controller;


import java.io.IOException;

import javax.servlet.ServletException;
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
 * id로 user를 검색하는 컨트롤러
 * 
 * @author 유예겸
 *
 */

public class UserReadController implements Controller {
	private ModelAndView mav;
	private UserService userService;
	private JSONObject obj;

	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		obj = new JSONObject();
		mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory)request.getServletContext().getAttribute("objectFactory");
		userService = (UserService)factory.getBean(UserServiceImpl.class);
	
		String id = (String)request.getServletContext().getAttribute("loginId");
		User user = null;
		try {
			user = userService.read(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		obj.put("name", user.getName());
		obj.put("email", user.getEmail());
		obj.put("phone", user.getCellphone());
		
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
