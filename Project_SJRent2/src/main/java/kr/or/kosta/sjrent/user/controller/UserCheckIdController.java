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
 * 아이디 중복확인 컨트롤러
 * 
 * @author 윤형철
 *
 */

public class UserCheckIdController implements Controller {
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

		boolean isExistId = false;
		
		try {
			isExistId = userService.isExistId(id);
			
			System.out.println(isExistId);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// 중복아이디 없을시 success 보냄
		if (isExistId == false) {
			obj.put("result", "success");
			try {
				response.getWriter().print(obj);
				
				mav.addObject("isExistId", isExistId);
				
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		// 중복아이디 존재시 fail 보냄
		else {

			obj.put("result", "fail");
			try {
				response.getWriter().print(obj);
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return mav;
	}

}