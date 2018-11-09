package kr.or.kosta.sjrent.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;


/**
 * 사용자 로그인 여부 체크 필터
 *
 */
public class LoginCheckFilter implements Filter {
	
	private Logger logger = Logger.getLogger(LoginCheckFilter.class);
	
	private String loginPage = "/user/login2.jsp";
//	private String loginPage = "index.jsp";

    @Override
	public void init(FilterConfig filterConfig) throws ServletException {
    	loginPage = filterConfig.getInitParameter("loginPage");
	}

    @Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

    	System.out.println("LoginCheckFiler 실행..");
		boolean isLogin = false;
		Cookie[] cookies = ((HttpServletRequest)request).getCookies();

		String id = null;
		if(cookies != null) {
			for (Cookie cookie : cookies) {
				if(cookie.getName().equals("loginId")) {
					isLogin = true;
					id = cookie.getValue();
					break;
				}
			}
		}
		// 회원 및 비회원 로그인 페이지 처리 
		if(isLogin) {
			chain.doFilter(request, response);
			request.setAttribute("loginId", id);
		}else {
			
			chain.doFilter(request, response);
			
		}
	}
    
    @Override
	public void destroy() {}

}



















