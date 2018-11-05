package kr.or.kosta.sjrent.daotest;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import kr.or.kosta.sjrent.user.dao.MybatisUserDao;
import kr.or.kosta.sjrent.user.dao.UserDao;
import kr.or.kosta.sjrent.user.domain.User;

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
		logger.debug("sqlSessionFactory 생성 완료!!!");
		
		userDao = new MybatisUserDao();
		((MybatisUserDao)userDao).setSqlSessionFactory(sqlSessionFactory);
		
	}
	
//	@Test
	public void testCreat() {
		User user = new User();
		user.setId("test");
		user.setName("테스트");
		user.setEmail("test@kosta.co.kr");
		user.setPassword("test90");
		user.setBirthday("900727");
		user.setGender(1);
		user.setPoint(0);
		user.setCellphone("010-0000-0000");
		user.setIsUser(1);
		logger.debug("테스트");
		try {
			userDao.create(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
//	@Test
	public void testCertify() throws Exception {
		User user = userDao.certify("gloomycloud", "gloomycloud90");
		logger.debug(user);
	}
//	@Test
	public void testIsExistId() throws Exception {
		logger.debug(userDao.isExistId("gloomycloud"));
	}
//	@Test
	public void testIsExistEmail() throws Exception {
		logger.debug(userDao.isExistEmail("battlecloud@naver.com"));
	}
//	@Test
	public void testRead() throws Exception {
		logger.debug(userDao.read("gloomycloud"));
	}
//	@Test
	public void testReadByCellphone() throws Exception {
		logger.debug(userDao.readByCellphone("010-4045-9440"));
	}
//	@Test
	public void testUpdate() throws Exception {
		User user = new User();
		user.setId("gloomycloud");
		user.setEmail("gloomycloud@khu.ac.kr");
		logger.debug(userDao.update(user));
	}
//	@Test
	public void testAddPoint() throws Exception {
		logger.debug(userDao.addPoint("gloomycloud", -2000));
	}
	@Test
	public void testCheckPoint() throws Exception {
		logger.debug(userDao.checkPoint("gloomycloud"));
	}
}








