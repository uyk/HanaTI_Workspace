package kr.or.kosta.sjrent.review.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.sjrent.review.domain.Review;

public class MybatisReviewDao implements ReviewDao {
	
	private static final String NAMESPACE = "kr.or.kosta.sjrent.review.";
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void create(Review review) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Review read(int number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Review review) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int number) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Review> listByPage(int page, int listSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> listByUser(int page, int listSize, String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Review> listByModel(int page, int listSize, String modelName) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countByUser(String User) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countByModel(String modelName) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double evalPointByModel(String modelName) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	
}










