package kr.or.kosta.spring.common.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

/**
 * Spring Security에서 사용하는 세부컨트롤러
 * @author 김기정
 */
@Controller
@Log4j
public class CommonController{
	
	@RequestMapping("/error/error_403")
	public void accessDenied(Authentication auth, Model model){
		log.info("Access Denied: " + auth);
		model.addAttribute("msg", "Access Denied");
	}
	
	@RequestMapping("/customLogin")
	public void loginInput(String error, String logout, Model model){
		log.info("error: " + error);
		log.info("logout: " + logout);
		
		if(error != null) {
			model.addAttribute("error", "아이디와 비밀번호를 확인하세요.");			
		}
		
		if(logout != null) {
			model.addAttribute("logout", "로그아웃!!");			
		}
	}
	
	@GetMapping("/customLogout")
	public void logoutGET(){
		log.info("사용자 로그아웃 화면");
	}
	
	@PostMapping("/customLogout")
	public void logoutPOST(){
		log.info("사용자 로그아웃 처리");
	}
}






