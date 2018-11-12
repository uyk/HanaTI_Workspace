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
 * 
 * 회원정보 삭제 역할을 수행하는 컨트롤러
 * 
 * @author 윤형철
 *
 */

public class UserDeleteController implements Controller {
	private ModelAndView mav;
	private UserService userService;
	private JSONObject obj;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		obj = new JSONObject();
		mav = new ModelAndView();
		XMLObjectFactory factory = (XMLObjectFactory) request.getServletContext().getAttribute("objectFactory");
		userService = (UserService) factory.getBean(UserServiceImpl.class);

		String id = (String) request.getAttribute("loginId");
		System.out.println("삭제할 ID임돠 : " + id);
		boolean isDelete = false;

		try {
			isDelete = userService.delete(id);
			System.out.println(isDelete);

			if (isDelete == true) {
//					response.getWriter().print("success");
				mav.setView("/index.jsp");
			} else {
				mav.setView("/sjrent/mypage/myPageLoginOK.jsp");
			}
			return mav;
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return mav;

	}

}
