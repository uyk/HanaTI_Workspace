package kr.or.kosta.shoppingmall.common.dao;

import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.List;

import javax.sql.DataSource;

import kr.or.kosta.shoppingmall.user.dao.UserDao;
import kr.or.kosta.shoppingmall.user.domain.User;

public class JdbcDaoFactory extends DaoFactory {

private Hashtable<String, Object> daos;
	
	private String[] daoNames = {"kr.or.kosta.jsp.dao.JdbcUserDao"};
	
	public JdbcDaoFactory() {
		daos = new Hashtable<String, Object>();
		
		for (String className : daoNames) {
			try {
				Object dao = Class.forName(className).newInstance();
				addDataSource(dao);
				daos.put(className, dao);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
	
//	public BarDao getBarDao() {...};
//	public FooDao getFooDao() {...};
	
	public static void main(String[] args) throws Exception {
		DaoFactory factory = new JdbcDaoFactory();
		UserDao dao = factory.getUserDao();
		List<User> list = dao.listAll();
		for (User user : list) {
			System.out.println(user.toString());
		}
		
	}

}
