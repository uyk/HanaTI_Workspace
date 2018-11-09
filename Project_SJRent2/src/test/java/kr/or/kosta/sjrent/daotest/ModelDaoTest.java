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

import kr.or.kosta.sjrent.model.dao.ModelDao;
import kr.or.kosta.sjrent.model.dao.MybatisModelDao;
import kr.or.kosta.sjrent.model.domain.Model;
import kr.or.kosta.sjrent.model.params.ModelParams;

public class ModelDaoTest {
	
	String resource = "mybatis-config.xml";
	SqlSessionFactory sqlSessionFactory;
	Logger logger = Logger.getLogger(ModelDaoTest.class);
	
	ModelDao modelDao;
	
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
		
		modelDao = new MybatisModelDao();
		((MybatisModelDao)modelDao).setSqlSessionFactory(sqlSessionFactory);
		
	}
	
//	@Test
	public void testRead() throws Exception {
		logger.debug(modelDao.read("NIRO"));
	}
	
	@Test
	public void testListAll() throws Exception {
		List<Model> ModelList = modelDao.listAll();
		for (Model model : ModelList) {
			logger.debug(model);
		}
	}
//	@Test
	public void testPopularModel() throws Exception{
		List<Model> ModelList = modelDao.popularModel(5);
		for (Model model : ModelList) {
			logger.debug(model);
		}
	}
	
//	@Test
	public void testListSearch() throws Exception{
		ModelParams modelParams = new ModelParams();
		modelParams.setStartDate("2018-11-15");
		modelParams.setEndDate("2018-11-17");
		modelParams.setType("JSegment");
		List<Model> ModelList = modelDao.listBySearch(modelParams);
		for (Model model : ModelList) {
			logger.debug(model);
		}
	}
	
//	@Test
	public void testchangeCount() throws Exception{
		logger.debug(modelDao.changeCount("K5", -1));
	}
}








