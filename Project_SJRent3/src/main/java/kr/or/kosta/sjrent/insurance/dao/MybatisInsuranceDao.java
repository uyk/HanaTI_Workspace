package kr.or.kosta.sjrent.insurance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.sjrent.insurance.domain.Insurance;

public class MybatisInsuranceDao implements InsuranceDao {
	
	private static final String NAMESPACE = "kr.or.kosta.sjrent.insurance.";
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void create(Insurance insurance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Insurance read(int number) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Insurance insurance = sqlSession.selectOne(NAMESPACE + "read", number);
		sqlSession.close();
		return insurance;
	}

	@Override
	public void update(Insurance insurance) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int number) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Insurance> listAll() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Insurance> insuranceList = sqlSession.selectList(NAMESPACE + "listAll");
		sqlSession.close();
		return insuranceList;
	}

	
	
}










