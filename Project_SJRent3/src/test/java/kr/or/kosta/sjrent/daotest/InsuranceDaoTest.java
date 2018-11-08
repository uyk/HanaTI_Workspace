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

import kr.or.kosta.sjrent.faq.dao.FAQDao;
import kr.or.kosta.sjrent.faq.dao.MybatisFAQDao;
import kr.or.kosta.sjrent.faq.domain.FAQ;
import kr.or.kosta.sjrent.insurance.dao.InsuranceDao;
import kr.or.kosta.sjrent.insurance.dao.MybatisInsuranceDao;
import kr.or.kosta.sjrent.insurance.domain.Insurance;

public class InsuranceDaoTest {
	
	String resource = "mybatis-config.xml";
	SqlSessionFactory sqlSessionFactory;
	Logger logger = Logger.getLogger(InsuranceDaoTest.class);
	
	InsuranceDao insuranceDao;
	
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
		
		insuranceDao = new MybatisInsuranceDao();
		((MybatisInsuranceDao)insuranceDao).setSqlSessionFactory(sqlSessionFactory);
		
	}
	
	@Test
	public void testRead() throws Exception {
		logger.debug(insuranceDao.read(1));
	}
	
	@Test
	public void testListAll() throws Exception {
		List<Insurance> insuranceList = insuranceDao.listAll();
		for (Insurance insurance : insuranceList) {
			logger.debug(insurance);
		}
	}

}








