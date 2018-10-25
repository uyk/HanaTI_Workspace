package kr.or.kosta.shoppingmall.common.service;

import java.io.FileInputStream;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;
import kr.or.kosta.shoppingmall.user.service.UserService;
import kr.or.kosta.shoppingmall.user.service.UserServiceImpl;

public class ServiceFactory {
	
	private Hashtable<String, Object> serviceList;
	
	public ServiceFactory(String serviceMapperLocation) {
		serviceList = new Hashtable<String, Object>();
		
		// 매핑정보를 저장할 Properties 객체 생성
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(serviceMapperLocation);
			prop.load(fis);
			Iterator keyIter = prop.keySet().iterator();
			System.out.println("--- service 생성 목록 ---");
			while (keyIter.hasNext()) {
				String servieName = (String)keyIter.next();
				String serviceClassName = prop.getProperty(servieName);
				// dao 생성
				Object serviceObject = Class.forName(serviceClassName).newInstance();
				serviceList.put(serviceClassName, serviceObject);
				System.out.println(serviceClassName + "=" + serviceObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Object getService(String service) {
		return serviceList.get(service);
	}
	
	public Object getService(Class cls) {
		return serviceList.get(cls.getName());
	}
	
	public static void main(String[] args) throws Exception {
		ServiceFactory factory = new ServiceFactory("C:/KOSTA187/workspace/Model2Study/WebContent/WEB-INF/service-mapper.properties");
		UserService userService = (UserService)factory.getService(UserServiceImpl.class);
		userService.list();
	}

}
