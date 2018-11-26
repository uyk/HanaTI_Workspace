package kr.or.kosta.spring.demo.service;

import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class SomeServiceImpl implements SomeService {
	
	@Override
	public void foo(String message){
		log.info("foo() 메소드 실행 : " + message);
	}

	@Override
	public String bar() {
		String message = "AOP 테스트";
		log.info("bar() 메소드 실행 : " + message);
		return message;
	}
}
