package kr.or.kosta.spring.common.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

/**
 * 서비스(비즈니스) 객체 로그 기록 Advice(공통) 클래스 
 * Spring Annotation을 이용한 Advice 설정
 * @author 김기정
 */
@Component
@Aspect
@Log4j
public class LogAdvice {

	// AspectJ 표현식을 이용한 포인트컷 설정
	@Before("execution(* kr.or.kosta.spring.demo.service..*.*(..))")
	// public void writeLog() {
	public void writeLog(JoinPoint joinPoint) {
		String bizObject = joinPoint.getTarget().getClass().getName();
		String executionMethod = joinPoint.getSignature().toShortString();
		log.info(bizObject+" 객체의 "+executionMethod+" 비즈니스 메소드 실행됨...");
		log.info("- 전달인자 : " + joinPoint.getArgs());
	}
}
