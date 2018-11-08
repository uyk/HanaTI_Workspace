package kr.or.kosta.sjrent.common.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;


/**
 * ServletContext 생명주기(생성/소멸) 관련 이벤트 리스너
 * @author 남수현
 */
public class ServletContextLoadListener implements ServletContextListener {
	
	private Logger logger = Logger.getLogger(ServletContextLoadListener.class);
	
	public void contextInitialized(ServletContextEvent event)  {
		// WEBINF 경로 파악
		String WEBINFpath = ServletContextLoadListener.class.getResource("").getPath();
		WEBINFpath = WEBINFpath.substring(0,WEBINFpath.indexOf("/WEB-INF"))+"/WEB-INF/";
		ServletContext servletContext = event.getServletContext();
		String configLocation = WEBINFpath+servletContext.getInitParameter("configLocation");
			
		XMLObjectFactory objectFactory = null;
		try {
			objectFactory = new XMLObjectFactory(configLocation);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 모든 서블릿, JSP들이 공유할 수 있도록 ServletContext에 DaoFactory 저장
		servletContext.setAttribute("objectFactory", objectFactory);
		// WEBINF 경로 ServletContext에 저장
		servletContext.setAttribute("WEBINFpath", WEBINFpath);
		logger.debug("XMLObjectFactory 생성 및 ServletContext에 등록 완료!");
		logger.debug(objectFactory);
		logger.debug(objectFactory.getObjectList());

	}
	
	
	public void contextDestroyed(ServletContextEvent event)  {
		logger.debug("ServletContext(서블릿컨테이너) 종료.");
    }
}
