package kr.or.kosta.spring.demo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import lombok.extern.log4j.Log4j;
/**
 * Spring Security 테스트를 위한 세부컨트롤러
 * @author 김기정
 */
@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController{
	
	@RequestMapping(value="/all")
	public void doAll(){
		log.info("로그인 여부와 상관없이 누구든지 접근할 수 있습니다...");
	}
	
	@RequestMapping(value="/member")
	public void doMember(){
		log.info("로그인 회원만 접근할 수 있습니다...");
	}
	
	@RequestMapping(value="/admin")
	public void doAdmin(){
		log.info("로그인 관리자만 접근할 수 있습니다...");
	}
	
	//---------------------------------------------------------

	@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MEMBER')")
	@GetMapping("/annoMember")
	public void doMember2(){
		log.info("Logined Annotation Member...");
	}
	
//	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@Secured({"ROLE_ADMIN"})
	@GetMapping("/annoAdmin")
	public void doAdmin2(){
		log.info("Logined Annotation Admin...");
	}
}






