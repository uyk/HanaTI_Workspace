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
import sun.nio.cs.HistoricallyNamedCharset;

/**
 * 
 * 회원정보 수정 역할을 수행하는 컨트롤러
 * 
 * @author 윤형철
 *
 */

public class UserUpdateController implements Controller {
	private UserService userService;
	private JSONObject obj;
	private ModelAndView mav;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		
		//System.out.println("야넘어오냐???");
		
		obj = new JSONObject();
		mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		userService = (UserService) factory.getBean(UserServiceImpl.class);

		User user = new User();
		boolean isUpdate = false;

		
		// 회원수정시에 들어오는 param
		if(request.getParameter("id") != null) {
					
			String id = (String) request.getAttribute("loginId");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String cellphone = request.getParameter("cellphone");			
			
			
			user.setId(id);
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setCellphone(cellphone);
			
			
			//System.out.println("회원수정요청: "+user);
			
			try {
				isUpdate = userService.update(user);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			// 회원수정 실패시 응답으로 fail 보냄
			if (isUpdate == false) {

				mav.setView("/sjrent/mypage/update.jsp");
				
				/*
				obj.put("result", "fail");
				try {
					response.sendRedirect("/sjrent/mypage/update.jsp");
					response.getWriter().print(obj);
					return null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/

			}
			// 회원수정 성공시 응답으로 success 보냄
			else {
				
				/*
				obj.put("result", "success");
				try {
					response.getWriter().print("success_userUpdate");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				*/
				
				mav.addObject("id", id);
				mav.addObject("name", name);
				mav.addObject("password", password);
				mav.addObject("email", email);
				mav.addObject("cellphone", cellphone);

				mav.setView("/mypage/updateUser_result.jsp");
				
			}
			
		}


		return mav;
	}

}