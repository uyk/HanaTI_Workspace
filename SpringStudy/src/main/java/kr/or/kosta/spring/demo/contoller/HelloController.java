package kr.or.kosta.spring.demo.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView();
		String message = "spring mvc module 테스트입니다.";
		mav.addObject("message", message);
		mav.setViewName("hello");		// 확장자 안씀
		
		return mav;
	}

}
