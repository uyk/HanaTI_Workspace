package kr.or.kosta.myshoppingmall.common.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import kr.or.kosta.myshoppingmall.common.factory.XMLObjectFactory;

public class ServletContextListener implements javax.servlet.ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();
		String configLocation = servletContext.getInitParameter("configLocation");
		//XMLObjectFactory 인스턴스를 생성하여 configLocation의 object-mapper.xml에 있는 object들 생성하여 factory에 저장
		XMLObjectFactory objectFactory = null;
		try {
			objectFactory = new XMLObjectFactory(configLocation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 모든 서블릿, JSP들이 공유할 수 있도록 ServletContext에 DaoFactory 저장
		servletContext.setAttribute("objectFactory", objectFactory);
		System.out.println("XMLObjectFactory 생성 및 ServletContext에 등록 완료!");
		System.out.println(objectFactory.getObjectList());

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

		System.out.println("ServletContext(서블릿컨테이너) 종료.");

	}

}
