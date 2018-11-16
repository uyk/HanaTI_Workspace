package kr.or.kosta.spring.common.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 모든 세부 컨트롤러에서 발생하는 예외를 처리하기 위한 공통 예외 처리 클래스
 * @author 김기정
 */
//@ControllerAdvice
@ControllerAdvice("kr.or.kosta.spring.employee.controller")
public class ControllerExceptionAdvice {
     @ExceptionHandler(Exception.class)
     public ModelAndView commonExceptionHandle(Exception exception) {
          ModelAndView modelAndView = new ModelAndView();
          modelAndView.setViewName("error/error_500");
          modelAndView.addObject("exception", exception);
          return modelAndView;
     }
}
