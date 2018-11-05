package kr.or.kosta.sjrent.common;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import kr.or.kosta.sjrent.common.factory.XMLObjectFactory;
import kr.or.kosta.sjrent.user.dao.MybatisUserDao;
import kr.or.kosta.sjrent.user.domain.User;

public class XMLObjectFactoryTest {
	
	String mapperLocation = "object-mapper.xml";
	
	XMLObjectFactory objectFactory;
	
	Logger logger = Logger.getLogger(XMLObjectFactoryTest.class);
	
	@Before
	public void setUp() {
		try {
			objectFactory = new XMLObjectFactory(mapperLocation);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testFactory() {
		MybatisUserDao dao =  (MybatisUserDao)objectFactory.getBean("userDao");

		
	}
	
}








