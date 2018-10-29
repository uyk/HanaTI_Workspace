package kr.or.kosta.shoppingmall.common.service;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;

import javax.sql.DataSource;

import com.sun.xml.internal.ws.util.StringUtils;

import kr.or.kosta.shoppingmall.common.dao.DaoFactory;
import kr.or.kosta.shoppingmall.user.dao.UserDao;
import kr.or.kosta.shoppingmall.user.service.UserService;
import kr.or.kosta.shoppingmall.user.service.UserServiceImpl;

public class ObjectFactory extends DaoFactory {

	private Hashtable<String, Object> serviceList;
	private Hashtable<String, Object> daoList;

	public ObjectFactory(String objectMapperLocation) {
		serviceList = new Hashtable<String, Object>();
		daoList = new Hashtable<String, Object>();

		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(objectMapperLocation);
			prop.load(fis);
			Iterator iter = prop.keySet().iterator();
			while (iter.hasNext()) {
				String text = (String) iter.next();
				String[] parsedText = text.split("]");
				if (parsedText.length > 1) {
					String type = parsedText[0].substring(1, parsedText[0].length());
					if (type.equals("dao")) {
						String daoName = parsedText[1];
						String daoClassName = prop.getProperty(text);
						Object daoObject = Class.forName(daoClassName).newInstance();
						addDataSource(daoObject);
						daoList.put(daoName, daoObject);
						System.out.println(daoName + "=" + daoObject);
					}
				}
			}
			
			iter = prop.keySet().iterator();
			while (iter.hasNext()) {
				String text = (String) iter.next();
				String[] parsedText = text.split("]");
				if (parsedText.length > 1) {
					String type = parsedText[0].substring(1, parsedText[0].length());
					if (type.equals("service")) {
						String[] parsedServiceName = parsedText[1].split("->");
						String serviceName = parsedServiceName[0];
						
						String serviceClassName = prop.getProperty(text);
						Object serviceObject = Class.forName(serviceClassName).newInstance();
						serviceList.put(serviceClassName, serviceObject);
						
						if (parsedServiceName.length == 2) {
							String daoName = parsedServiceName[1];
							String methodName = "set" + StringUtils.capitalize(daoName);
							Class cls = serviceObject.getClass();
							Method method = null;
							try {
								String interfaceName = getDao(daoName).getClass().getInterfaces()[0].getName();
//								method = cls.getMethod(methodName, UserDao.class);
								method = cls.getMethod(methodName,Class.forName(interfaceName));
								method.invoke(serviceObject, getDao(daoName));
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						System.out.println(serviceClassName + "=" + serviceObject);
					}
				}
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Object getService(String serviceName) {
		return serviceList.get(serviceName);
	}

	public Object getService(Class cls) {
		return getService(cls.getName());
	}

	public Object getDao(String daoName) {
		return daoList.get(daoName);
	}

	public Object getDao(Class cls) {
		return getDao(cls.getName());
	}

	private void addDataSource(Object dao) {
		Class cls = dao.getClass();
		// 동적 메소드호출
		Method method;
		try {
			method = cls.getMethod("setDataSource", DataSource.class);
			method.invoke(dao, getDataSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void addDao(Object service, String daoName, String methodName, Object dao) {
		Class cls = service.getClass();
		Method method;
		try {
			method = cls.getMethod(methodName, Class.forName(daoName));
			method.invoke(service, getDataSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		String mapperLocation = "C:/KOSTA187/workspace/Model2Study/WebContent/WEB-INF/object-mapper.properties";
		ObjectFactory factory = new ObjectFactory(mapperLocation);
		UserService userService = (UserService) factory.getService(UserServiceImpl.class);
		System.out.println(userService.list());
	}

}
