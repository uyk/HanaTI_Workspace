package kr.or.kosta.shoppingmall.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.kosta.shoppingmall.common.factory.XMLObjectFactory;
import kr.or.kosta.shoppingmall.user.service.UserService;
import kr.or.kosta.shoppingmall.user.service.UserServiceImpl;

/**
 * Annotation을 이용하여 Test 클래스를 정의하는 방법(JUnit 4)
 */
public class ObjectFactoryTest {
	String mapperLocation = "C:/KOSTA187/workspace/Model2Study/WebContent/WEB-INF/object-mapper.xml";
	XMLObjectFactory factory;
	UserService userService;
	
	@Before
	public void init() throws Exception {
		// 선행 작업(자원할당 등)
		factory = new XMLObjectFactory(mapperLocation);
		userService = (UserService) factory.getBean(UserServiceImpl.class);
	}

	@After
	public void destroy() throws Exception {
		// 후행 작업(자원해제 등)
	}

	@Test
	public void testObjectFactory() {
		try {
			System.out.println(userService.list());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
