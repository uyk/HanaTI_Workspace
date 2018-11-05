package kr.or.kosta.sjrent.rent.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.sjrent.rent.domain.Rent;


public class MybatisRentDao implements RentDao {
	
	private static final String NAMESPACE = "kr.or.kosta.sjrent.rent.";
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public boolean create(Rent rent) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.insert(NAMESPACE + "insertRent", rent);
		sqlSession.close();
		if(result==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Rent read(int number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rent> listAll(int page, int listSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Rent> listByUserId(String userId) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Rent> rentList = sqlSession.selectList(NAMESPACE + "listByUserId");
		sqlSession.close();
		return rentList;
	}

	@Override
	public boolean update(Rent rent) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int number) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cancel(int number) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.update(NAMESPACE + "cancelRent", number);
		sqlSession.close();
		if(result==1) {
			return true;
		}else {
			return false;
		}	
	}
	
}










