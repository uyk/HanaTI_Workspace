package kr.or.kosta.shoppingmall;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import kr.or.kosta.shoppingmall.employee.domain.Employee;

public class MybatisTest {
	private String NAMESPACE = "kr.or.kosta.shoppingmall.employee.";
	String resource = "mybatis-config.xml";
	SqlSessionFactory sqlSessionFactory;
	Logger logger = Logger.getLogger(MybatisTest.class);
	
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
	}
	
//	@Test
	public void testSelectAll() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Employee> list = sqlSession.selectList(NAMESPACE + "selectAll");
		for (Employee employee : list) {
			logger.debug(employee);
		}
		sqlSession.close();
	}
	
//	@Test
	public void testSelectEmployeeById() {
		int num = 100;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Employee employee = sqlSession.selectOne(NAMESPACE + "selectEmployeeById", num);
		logger.debug(employee);
		sqlSession.close();
	}
	
//	@Test
	public void testSelectSalaryById() {
		int num = 100;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int salary = sqlSession.selectOne(NAMESPACE + "selectSalaryById", num);
		logger.debug(salary);
		sqlSession.close();
	}
	
//	@Test
	public void testSelectEmployeesBySalary() {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("min", 3000);
		params.put("max", 4000);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Employee> list = sqlSession.selectList(NAMESPACE + "selectEmployeesBySalary", params);
		for (Employee employee : list) {
			logger.debug(employee);
		}
		sqlSession.close();
	}
	
//	@Test
	public void testSelectEmployeesByLastName() {
		String name = "%S%";
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Employee> list = sqlSession.selectList(NAMESPACE + "selectEmployeesByLastName", name);
		for (Employee employee : list) {
			logger.debug(employee);
		}
		sqlSession.close();
	}
	
//	@Test
	public void testSelectEmployeesWithDepartment() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Map<String, Object>> list = sqlSession.selectList(NAMESPACE + "selectEmployeesWithDepartment");
		for (Map<String, Object> map : list) {
			//String id = String.valueOf(map.get("id"));
			BigDecimal id = (BigDecimal)map.get("id");
			logger.debug("id : " + id);
		}
		sqlSession.close();
	}
	
//	@Test
	public void testSelectAll2() {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Employee> list = sqlSession.selectList(NAMESPACE + "selectAll2");
		for (Employee employee : list) {
			logger.debug(employee);
		}
		sqlSession.close();
	}
	
//	@Test
	public void testUpdateEmployee() {
		Employee emp = new Employee();
		emp.setId(100);
		emp.setSalary(7777);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.update(NAMESPACE + "updateEmployee", emp);
		sqlSession.commit();
		sqlSession.close();
	}
	
	@Test
	public void testDynamicSQL() {
		Map<String, String> params = new HashMap<String, String>();
//		params.put("searchType", "id");
//		params.put("searchValue", "100");
		params.put("searchType", "name");
		params.put("searchValue", "Oliver");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Employee> list = sqlSession.selectList(NAMESPACE + "dynamicSQL", params);
//		List<Employee> list = sqlSession.selectList(NAMESPACE + "dynamicSQL");
		for (Employee employee : list) {
			logger.debug(employee);
		}
		sqlSession.close();
	}

}
