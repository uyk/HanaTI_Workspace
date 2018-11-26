package kr.or.kosta.spring.employee.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.kosta.spring.employee.command.LoginCommand;
import kr.or.kosta.spring.employee.domain.Employee;
import lombok.extern.log4j.Log4j;

/**
 * 사원 관련 요청 처리 세부 컨트롤러
 * 
 * @author 유예겸
 *
 */
@Controller
@RequestMapping("/employee")
@Log4j
public class EmployeeController {

	// 사원 목록
	@RequestMapping("list")
	public String list(Model model) {
		System.out.println(10 / 0);
		String title = "KOSTA 사원 목록"; // bizService.getTitle();
		List<Employee> list = new ArrayList<Employee>(); // bizService.list();
		list.add(new Employee(100, "기정", "김", "bangy313@naver.com"));
		list.add(new Employee(101, "기정", "이", "aangy313@naver.com"));
		list.add(new Employee(102, "기정", "박", "cangy313@naver.com"));

		model.addAttribute("title", title);
		model.addAttribute("list", list);
		return "employee/list";
	}

	@GetMapping("regist")
	public void regist() {
		log.info("사원화면 요청");

	}
	/*
	 * @PostMapping("regist") public String regist(int employeeId, String firstName,
	 * String lastName, String email, Model model) { log.info("사원등록 요청");
	 * log.info(employeeId + ", " +firstName + ", " +lastName + ", " +email);
	 * model.addAttribute("employeeId",employeeId);
	 * model.addAttribute("firstName",firstName); return "employee/result"; }
	 */

	@PostMapping("regist")
	public String regist(Employee employee) {
		log.info("사원등록 요청");
		log.info(employee.getEmployeeId() + ", " + employee.getFirstName() + ", " + employee.getLastName() + ", "
				+ employee.getEmail());
		return "employee/result";
	}

	// 사원 상세정보
	@RequestMapping("view")
	public String view(@RequestParam String id) {
		log.info("사원번호 : " + id);
		return "/employee/view";
	}

	// 사원 정보 수정
	@RequestMapping(value = "update", params = "type=admin")
	public void update() {
		log.info("요청 파라메터 값에 따른 처리");
		// 뷰이름 반환하지 않을 경우 요청이름을 뷰이름으로 사용
	}

	// 서블릿 API 활용
	@RequestMapping("servlet")
	public void servlet(HttpServletRequest request, HttpServletResponse response) {
		log.info(request.getRemoteAddr());
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("<html>");
		out.println("<body>");
		out.println("<h2>Test Message</h2>");
		out.println("</body>");
		out.println("</html>");
	}

	// 브라우저 헤더정보
	@RequestMapping("header")
	public void header(@RequestHeader("user-agent") String userAgent) {
		log.info("브라우저 정보: " + userAgent);
	}

	/********** 쿠키 사용하기 ***********/
	// 로그인 화면
	@GetMapping("login")
	public String form(@CookieValue(value = "rememberId", required = false) Cookie rememberCookie,
			LoginCommand loginCommand) {
		log.info("로그인 화면 요청...");
		if (rememberCookie != null) {
			loginCommand.setUserId(rememberCookie.getValue());
			loginCommand.setRememberId(true);
		}
		return "employee/loginForm";
	}

	// 로그인 처리
	@PostMapping("login")
	public String loginPost(LoginCommand loginCommand, HttpServletResponse response) {
		log.info("로그인 처리 요청...");

		// boolean isMember = employeeService.authenticate(loginCommand.getUserId(),
		// loginCommand.getPassword());
		// 회원이라 가정
		Cookie loginIdCookie = new Cookie("loginId", loginCommand.getUserId());
		loginIdCookie.setPath("/");
		response.addCookie(loginIdCookie);

		Cookie rememberCookie = new Cookie("rememberId", loginCommand.getUserId());
		rememberCookie.setPath("/");
		if (loginCommand.isRememberId()) {
			rememberCookie.setMaxAge(60 * 60 * 24 * 30);
		} else {
			rememberCookie.setMaxAge(0);
		}
		response.addCookie(rememberCookie);

		return "redirect:/";
	}

	// 쿠키 정보 읽기
	@RequestMapping(value = "/readcookie")
	public String readCooke(@CookieValue(value="loginId", required=false) Cookie loginCookie, LoginCommand loginCommand) {
	     if(loginCookie == null) {
	          return "login";
	     }else {
	          loginCommand.setUserId(loginCookie.getValue());
	     }
	     return "/employee/readcookie";
	}
	
	/** RESTful service - JSON 직접 출력(비권장) */
	@GetMapping(value="/{employee_id}")
	public void detail(@PathVariable("employee_id") int employeeId, HttpServletResponse response) throws IOException {
	     log.info("사원정보 요청 : " + employeeId);
	      // JSON 직접 출력
	     response.setContentType("text/plain; charset=utf-8"); 
	     PrintWriter out = response.getWriter();
	     String employeeJson = "{\"employeeId\": \""+employeeId+"\", \"firstName\" : \"기정\", \"lastName\" : \"김\"}";
	     out.println(employeeJson);
	}

	/** RESTful service - @ResponseBody 활용(Json Text 반환) */
	@GetMapping(value="/{employeeId}/1",produces = "text/plain; charset=utf8")
	public @ResponseBody String detail(@PathVariable int employeeId){
	     log.info("사원정보 요청 : " + employeeId);
	     String employeeJson = "{\"employeeId\": \""+employeeId+"\", \"firstName\" : \"기정\", \"lastName\" : \"김\"}";
	     return employeeJson;
	}
	
	/** RESTful service - @ResponseBody 활용(자바 객체 반환) */
	/* 마샬링 작업을 위해 XML, JSON 파싱 라이브러리(jackson) 추가 필요(pom.xml) */
//	@GetMapping(value="/{employeeId}/2", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	//@GetMapping(value="/{employeeId}/2", produces=MediaType.APPLICATION_XML_VALUE)
//	@GetMapping(value="/{employeeId}/2", produces={MediaType.APPLICATION_JSON_UTF8_VALUE, MediaType.APPLICATION_XML_VALUE}) - 생략시 기본값
	@GetMapping(value="/{employeeId}/2")
	public @ResponseBody Employee detail2(@PathVariable int employeeId) {
	     log.info("사원정보 요청 : " + employeeId);
	     Employee employee = new Employee();
	     employee.setEmployeeId(employeeId);
	     employee.setFirstName("길동");
	     employee.setLastName("홍");
	     return employee;
	}
	
	/** RESTful service - @ResponseBody 활용(콜렉션 Map 반환) */
	@GetMapping(value="/{employeeId}/3")
	// 기본 xml 응답, /{employeeId}/3.json 요청시 json 응답 
	public @ResponseBody Map<String, Object> detail3(@PathVariable int employeeId) {
	     log.info("사원정보 요청 : " + employeeId);
	     Map<String, Object> employeeMap = new HashMap<String, Object>();
	     employeeMap.put("employeeId", employeeId);
	     employeeMap.put("firstName", "찬호");
	     employeeMap.put("lastName", "박");
	     return employeeMap;
	}

	/** RESTful service - @ResponseBody 활용(콜렉션 List 반환) */
	@GetMapping(value = "/", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody List<Employee> list() {
	     log.info("사원목록 요청");
	     List<Employee> list = new ArrayList<Employee>();
	     list.add(new Employee(100, "firstName1", "lastName1", "email1"));
	     list.add(new Employee(101, "firstName2", "lastName2", "email2"));
	     list.add(new Employee(102, "firstName3", "lastName3", "email3"));
	     return list;
	}
	
	/** RESTful service - @ResponseBody 활용(ResponseEntity 반환) */
	/** ResponseEntity - 데이터와 함께 Http 응답 메시지의 응답코드와 응답메시지 같이 전달 가능) */
	@GetMapping(value = "/result", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<Employee> list2() {
	     log.info("사원정보 요청");
	     Employee employee = new Employee();
	     employee.setEmployeeId(1000);
	     employee.setFirstName("길동");
	     employee.setLastName("홍");

	     ResponseEntity<Employee> result = ResponseEntity.status(HttpStatus.OK).body(employee);
	     //ResponseEntity<Employee> result = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(employee);
	     //ResponseEntity<Employee> result = ResponseEntity.status(HttpStatus.NOT_FOUND).body(employee);
	     return result;
	}

	/** RESTful service - @RequestBody, @ResponseBody 활용 */
	// 테스트 시 Postman 활용
	@PostMapping(value = "/echo", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public @ResponseBody ResponseEntity<Employee> echo(@RequestBody Employee employee) {
	     log.info("사원정보 수신 : " + employee);
	     // 테스트 에코
	     //ResponseEntity<Employee> result = ResponseEntity.status(HttpStatus.OK).body(employee);
	     ResponseEntity<Employee> result = ResponseEntity.status(HttpStatus.OK).body(employee);
	     return result;
	}

	@GetMapping(value = "/echo")
	public void echo() {
	     log.info("echo Get 요청");
	}


}
