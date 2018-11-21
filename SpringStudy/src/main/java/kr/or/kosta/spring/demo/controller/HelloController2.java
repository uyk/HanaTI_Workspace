package kr.or.kosta.spring.demo.controller;

import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Spring 2.5 이후 세부 컨트롤러(POJO)
 * @author 유예겸
 *
 */
@Controller
@RequestMapping("/demo")
public class HelloController2 {

	@RequestMapping(value="/hello")
	public String hello(Model model) throws Exception {
		String message = "spring mvc module 테스트입니다.";
		model.addAttribute("message", message);
		return "demo/hello";
	}
	
	@RequestMapping(value="/today")
	public String today(Model model) throws Exception {
		Calendar calendar = Calendar.getInstance();
		String time = String.format("%1$tF %1$tT", calendar);
		model.addAttribute("today", time);
		return "demo/today";
	}
	
	@RequestMapping(value="/find", params="admin=true")
	public String admin(Model model) throws Exception {
		model.addAttribute("message", "관리자화면입니다.");
		return "demo/admin";
	}

}
