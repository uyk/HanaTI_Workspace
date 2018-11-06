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

import kr.or.kosta.sjrent.rent.dao.MybatisRentDao;
import kr.or.kosta.sjrent.rent.dao.RentDao;
import kr.or.kosta.sjrent.rent.domain.Rent;
import kr.or.kosta.sjrent.user.dao.MybatisUserDao;
import kr.or.kosta.sjrent.user.dao.UserDao;
import kr.or.kosta.sjrent.user.domain.User;

public class RentDaoTest {
	
	String resource = "mybatis-config.xml";
	SqlSessionFactory sqlSessionFactory;
	Logger logger = Logger.getLogger(RentDaoTest.class);
	
	RentDao rentDao;
	
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
		
		rentDao = new MybatisRentDao();
		((MybatisRentDao)rentDao).setSqlSessionFactory(sqlSessionFactory);
		
	}
	
	//@Test
	public void testCreat() {
		Rent rent = new Rent();
		rent.setUserSeq(4);
		rent.setUserId("uyk");
		rent.setInsuranceNumber(1);
		rent.setCarNumber("11호5432");
		rent.setStartDate("2018-11-10");
		rent.setEndDate("2018-11-12");
		rent.setPickupPlace("인천광역시 서구");
		rent.setPaidAmount(50000);
		rent.setPaymentOption("카드");
		rent.setIsCanceled(0);
		logger.debug("예겸바보: " + rent);
		logger.debug(rent.getStartDate());
//		
		try {
			rentDao.create(rent);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void listByUser() {
		List<Rent> list = null;
		try {
			list = rentDao.listByUserId("uyk");
			System.out.println(list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	
}








