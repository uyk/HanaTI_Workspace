package kr.or.kosta;

import java.sql.SQLException;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.kosta.spring.employee.mapper.EmployeeMapper;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class EmployeeMapperTest {
	@Inject
	private EmployeeMapper employeeMapper;
	
	@Test
	public void testEmployeeMapper() throws SQLException{
		log.info(employeeMapper);
		String today = employeeMapper.getTime();
		log.info(today);
	}
}
