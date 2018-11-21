package kr.or.kosta.spring.common.aop.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import lombok.extern.log4j.Log4j;

/**
 * AOP - Advice(공통) 클래스
 * Spring Annotation을 이용한 Advice 설정
 * @author 김기정
 */
@Component
@Aspect
@Log4j
public class DemoAdvice {

	/** Pointcut 종류 : @Before(), @After(), @AfterReturnning(), @AfterThrowing(), @Around() */
	
	@Before("execution(* kr.or.kosta.spring.demo.service..*.*(..))")
	public void startLog() {
		log.info("----------------------- 비즈니스 메소드 실행 전 -------------------------");
		
	}
	

	@After("execution(* kr.or.kosta.spring.demo.service..*.*(..))")
	public void endLog() {
		log.info("----------------------- 비즈니스 메소드 실행 후 -------------------------");
	}

	@AfterReturning(pointcut = "execution(* kr.or.kosta.spring.demo.service..*.*(..))", returning = "returnValue")
	public void afterReturningLog(JoinPoint joinPoint, Object returnValue) {
		log.info("실행 메소드 반환값: " + returnValue);
	}

	@AfterThrowing(pointcut = "execution(* kr.or.kosta.spring.demo.service..*.*(..))", throwing = "exception")
	public void afterThrowingLog(JoinPoint joinPoint, Throwable exception) {
		log.info(joinPoint.getSignature().toShortString() + " 메소드 예외발생 : " + exception);
	}
	
	// 메소드 실행 전체를 앞, 뒤로 감싸서 특정한 기능을 실행할 수 있는 가장 강력한 타입의 Advice 설정
	@Around("execution(* kr.or.kosta.spring.demo.service..*.*(..))")
	public Object serviceAccessLog(ProceedingJoinPoint joinPoint) throws Throwable {
		
		String methodName = joinPoint.getSignature().toShortString();
		log.info(methodName + " 메서드 실행 시작됨 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			log.info(methodName + "  -- 메서드가 반환한 객체 : " + result);
			return result;
		} finally {
			long end = System.currentTimeMillis();
			log.info(methodName + " 메서드 실행 종료됨 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			log.info(methodName + " 메서드 실행 시간 : " + (end - start) + "ms");
		}
	}
}
