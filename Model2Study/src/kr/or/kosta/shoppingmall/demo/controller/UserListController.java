package kr.or.kosta.shoppingmall.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.shoppingmall.common.controller.Controller;
import kr.or.kosta.shoppingmall.common.controller.ModelAndView;

public class UserListController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		ModelAndView mav = new ModelAndView();
		// 모델영역의 비즈니스소드 호출 및 데이터 반환
		// String message = xxxService.bizMethod();
		String message = "유저리스트입니다....";
		request.getSession().setAttribute("message", message);
		
		mav.addObject("message", message);
		
		mav.setView("/user/list.jsp");
		
		//redirect는 request 값이 reset 되기 때문에 값을 넘기고 싶으면 session에 저장해서 넘겨야함.
		return mav;
	}

}
