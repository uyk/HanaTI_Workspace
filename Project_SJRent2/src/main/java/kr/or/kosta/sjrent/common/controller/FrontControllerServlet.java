package kr.or.kosta.sjrent.common.controller;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.common.listener.ServletContextLoadListener;
import kr.or.kosta.sjrent.common.view.View;
import kr.or.kosta.sjrent.common.view.ViewResolver;

/**
 * 모든 브라우저 요청에 대한 단일 진입점 역할의 프론트 컨트롤러 서블릿(메인 컨트롤러)
 * 
 * @author 남수현
 */
public class FrontControllerServlet extends HttpServlet {
	private String configLocation;
	
//	private ControllerFactory controllerFactory;
	private XMLObjectFactory controllerFactory;
	private ViewResolver viewResolver;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		String WEBINFpath = ServletContextLoadListener.class.getResource("").getPath();
		WEBINFpath = WEBINFpath.substring(0,WEBINFpath.indexOf("/WEB-INF"))+"/WEB-INF/";
		configLocation = WEBINFpath+config.getInitParameter("configLocation");
		try {
			controllerFactory = new XMLObjectFactory(configLocation);
		} catch (Exception e) {
			throw new ServletException("XMLObjectFactory Exception", e);
		}
		viewResolver = new ViewResolver();
		System.out.println(controllerFactory);
		System.out.println(controllerFactory.getObjectList());
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		process(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		process(request, response);
	}

	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		/** 모든 세부 컨트롤러들에 대한 공통 기능 처리 */

		// 모든 요청파라메터에 대한 한글 인코딩 처리
		//request.setCharacterEncoding("utf-8");

		// #1.웹 클라이언트 요청(브라우저 명령) 분석
		String uri = request.getRequestURI();

		// 확장자 형식 매핑시..
		// /appName/some.rent -> /some
		// /appName/board/some.do -> /board/some
		String contextPath = request.getContextPath();
		uri = uri.substring(contextPath.length(), uri.lastIndexOf("."));

		// #2. 웹 클라이언트 요청에 대한 모델 세부 컨트롤러 실행 및 응답 - Command Pattern 적용
		Controller controller = null;
		ModelAndView mav = null;
		View view = null;

		// ControllerFactory에서 요청 uri에 대한 컨트롤러 검색
//		controller = controllerFactory.getController(uri);
		controller = (Controller)controllerFactory.getBean(uri);
		
		if(controller == null){
//			response.sendError(HttpServletResponse.SC_NOT_FOUND);
//			return;
			// 등록된 세부 컨트롤러가 없을 경우 uri에 해당하는 jsp로 단순 포워드
			view = viewResolver.resolve(uri+".jsp");
			view.execute(request, response);
			return;
		}

		// 일관된 메소드 호출을 통한 세부컨트롤러 실행(커맨드패턴)
		mav = controller.handleRequest(request, response);
		if(mav == null){
			return;
		}

		// request 컨텍스트 객체에 View에서 필요로 하는 결과정보 저장
		Map<String, Object> map = mav.getModel();
		Set<String> keySet = map.keySet();
		for (String key : keySet) {
			Object value = map.get(key);
			request.setAttribute(key, value);
		}
		
		//  ViewResolver로 부터 View 선택 및 실행
		String viewPath = mav.getView();
		view = viewResolver.resolve(viewPath);
		view.execute(request, response);
	}

}
