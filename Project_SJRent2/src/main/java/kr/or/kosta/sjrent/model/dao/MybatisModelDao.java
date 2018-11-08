package kr.or.kosta.sjrent.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.sjrent.model.domain.Model;
import kr.or.kosta.sjrent.model.params.ModelParams;

public class MybatisModelDao implements ModelDao {
	
	private static final String NAMESPACE = "kr.or.kosta.sjrent.model.";
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void create(Model model) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Model read(String name) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Model model = sqlSession.selectOne(NAMESPACE + "read", name);
		sqlSession.close();
		return model;
	}

	@Override
	public void update(Model model) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String name) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Model> listAll() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Model> modelList = sqlSession.selectList(NAMESPACE + "listAll");
		sqlSession.close();
		return modelList;
	}

	@Override
	public List<Model> listByPage(int page, int listSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Model> listBySearch(int page, int listSize, String startDate, String endDate, String fuelType,
			int seater, String transmission, String navigation, String cameraRear, String blackBox) throws Exception {
		return null;
	}

	@Override
	public List<Model> listBySearch(ModelParams modelParams) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Model> modelList = sqlSession.selectList(NAMESPACE + "listBySearch", modelParams);
		sqlSession.close();
		return modelList;
	}

	@Override
	public int countBySearch(int page, int listSize, String startDate, String endDate, String fuelType, int seater,
			String transmission, String navigation, String cameraRear, String blackBox) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countBySearch(ModelParams modelParams) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Model> popularModel(int num) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Model> modelList = sqlSession.selectList(NAMESPACE + "popularModel", num);
		sqlSession.close();
		return modelList;
	}

	@Override
	public List<Model> recommendModel(int num) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean changeCount(String name, int num) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("name", name);
		paramMap.put("num",num);
		System.out.println(paramMap);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.update(NAMESPACE + "changeCount", paramMap);
		sqlSession.close();
		if(result==1) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public List<String> checkEnableCar(String startDate, String endDate, String modelName) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startDate", startDate);
		paramMap.put("endDate", endDate);
		paramMap.put("modelName", modelName);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<String> result = sqlSession.selectList(NAMESPACE+"checkEnableCar",paramMap);
		sqlSession.close();
		return result;
	}
}










