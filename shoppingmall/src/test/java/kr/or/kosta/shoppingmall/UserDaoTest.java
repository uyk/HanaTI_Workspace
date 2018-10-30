package kr.or.kosta.shoppingmall;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import kr.or.kosta.shoppingmall.user.dao.MyBatisUserDao;
import kr.or.kosta.shoppingmall.user.dao.UserDao;
import kr.or.kosta.shoppingmall.user.domain.User;

public class UserDaoTest {
	String resource = "mybatis-config.xml";
	SqlSessionFactory sqlSessionFactory;
	Logger logger = Logger.getLogger(UserDaoTest.class);
	
	UserDao userDao;
	
	@Before
	public void setUp() {
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "development");
		logger.debug("sql Session Factory 생성 완료");
		userDao = new MyBatisUserDao();
		((MyBatisUserDao)userDao).setSqlSessionFactory(sqlSessionFactory);
	}
	
//	@Test
	public void testSelectAll() throws Exception {
		List<User> list = userDao.listAll();
		if(list == null) {
			logger.debug("listAll null");
			return;
		}
		for (User user : list) {
			logger.debug(user);
		}
	}
	
//	@Test
	public void testCreate() throws Exception {
		User user = new User();
		user.setId("testCreate");
		user.setName("테스트");
		user.setPasswd("1111");
		user.setEmail("zz@zz.zz");
		userDao.create(user);
		
		List<User> list = userDao.listAll();
		if(list == null) {
			logger.debug("listAll null");
			return;
		}
		for (User temp_user : list) {
			logger.debug(temp_user);
		}
	}
	
//	@Test
	public void testRead() throws Exception {
		User user = userDao.read("testCreate");
		logger.debug(user);
	}
	
//	@Test
	public void testUpdate() throws Exception {
		User user = new User();
		user.setId("testUpdate");
		user.setName("수정22");
		user.setPasswd("1111");
		user.setEmail("zz1111@zz.zz1");
		userDao.update(user);
		
		List<User> list = userDao.listAll();
		if(list == null) {
			logger.debug("listAll null");
			return;
		}
		for (User temp_user : list) {
			logger.debug(temp_user);
		}
	}
	
//	@Test
	public void testDelete() throws Exception {
		userDao.delete("testCreate");
		
		List<User> list = userDao.listAll();
		if(list == null) {
			logger.debug("listAll null");
			return;
		}
		for (User temp_user : list) {
			logger.debug(temp_user);
		}
	}
	
//	@Test
	public void testCertify() throws Exception {
		User user = userDao.certify("meo","1234");
		logger.debug(user);
	}
	
//	@Test
	public void testListByPage() throws Exception {
//		List<User> list = userDao.listByPage(1);
//		List<User> list = userDao.listByPage(2,4);
//		List<User> list = userDao.listByPage(1,5,"id","bangry3");
		List<User> list = userDao.listByPage(1,5,"name","유");
		if(list == null) {
			logger.debug("listByPage null");
			return;
		}
		for (User user : list) {
			logger.debug(user);
		}
	}
	
	@Test
	public void testCountBySearch() throws Exception {
//		List<User> list = userDao.listByPage(1);
//		List<User> list = userDao.listByPage(2,4);
//		List<User> list = userDao.listByPage(1,5,"id","bangry3");
		int count;
//		count = userDao.countBySearch("id", "bangry3");
//		count = userDao.countBySearch("name", "유");
//		count = userDao.countBySearch(null, null);
		count = userDao.countBySearch(null);
		logger.debug(count);

	}
}
