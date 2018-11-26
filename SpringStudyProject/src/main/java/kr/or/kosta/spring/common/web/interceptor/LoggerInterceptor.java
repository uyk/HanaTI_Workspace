package kr.or.kosta.spring.common.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.log4j.Log4j;

@Log4j
public class LoggerInterceptor extends HandlerInterceptorAdapter {
	private long start, end;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if (log.isDebugEnabled()) {
			log.debug("-------------------------------------- Controller Start --------------------------------------");
			start = System.currentTimeMillis();
			log.debug("Request URI  :  " + request.getRequestURI());
			log.debug("Controller   :  " + ((HandlerMethod) handler).getBeanType());
		}
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (log.isDebugEnabled()) {
			end = System.currentTimeMillis();
			log.debug(((HandlerMethod) handler).getMethod().getName() + "() 메서드 실행 시간 : " + (end - start) + "ms");
			log.debug("-------------------------------------- Controller End --------------------------------------");
		}
	}

}
