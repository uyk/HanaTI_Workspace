package kr.or.kosta.shoppingmall.common.dao;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.sql.DataSource;

import kr.or.kosta.shoppingmall.common.controller.Controller;
import kr.or.kosta.shoppingmall.common.controller.ControllerFactory;
import kr.or.kosta.shoppingmall.user.dao.UserDao;
import kr.or.kosta.shoppingmall.user.domain.User;

public class JdbcDaoFactory extends DaoFactory {
	//private String[] daoNames = {"kr.or.kosta.jsp.dao.JdbcUserDao"};
	private Hashtable<String, Object> daos;
	
	
	public JdbcDaoFactory(String daoMapperLocation) {
		daos = new Hashtable<String, Object>();
		
		// 매핑정보를 저장할 Properties 객체 생성
		Properties prop = new Properties();
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(daoMapperLocation);
			prop.load(fis);
			Iterator keyIter = prop.keySet().iterator();
			System.out.println("--- dao 생성 목록 ---");
			while (keyIter.hasNext()) {
				String daoName = (String)keyIter.next();
				String daoClassName = prop.getProperty(daoName);
				// dao 생성
				Object daoObject = Class.forName(daoClassName).newInstance();
				addDataSource(daoObject);
				daos.put(daoClassName, daoObject);
				System.out.println(daoClassName + "=" + daoObject);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Object getDao(String daoName) {
		return daos.get(daoName);
	}
	
	public Object getDao(Class cls) {
		return daos.get(cls.getName());
	}
	
	@Override
	public UserDao getUserDao() {
		return (UserDao)daos.get("kr.or.kosta.jsp.dao.JdbcUserDao");
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
	
	public static void main(String[] args) throws Exception {
		DaoFactory factory = new JdbcDaoFactory("C:/KOSTA187/workspace/Model2Study/WebContent/WEB-INF/dao-mapper.properties");
		UserDao dao = factory.getUserDao();
		List<User> list = dao.listAll();
		for (User user : list) {
			System.out.println(user.toString());
		}
		
	}

}
