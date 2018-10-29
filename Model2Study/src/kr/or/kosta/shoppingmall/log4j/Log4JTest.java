package kr.or.kosta.shoppingmall.log4j;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Annotation을 이용하여 Test 클래스를 정의하는 방법(JUnit 4)
 */
public class Log4JTest {
	
	SomeService service = new SomeService();

	@Test
	public void sumTest() {
		service.someMethod();
	}
}
