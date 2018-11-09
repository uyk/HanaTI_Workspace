package kr.or.kosta.sjrent.review.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.sjrent.rent.domain.Rent;
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
	public boolean create(Review review) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.insert(NAMESPACE + "write", review);
		sqlSession.close();
		if(result==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Review read(int number) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		Review review = sqlSession.selectOne(NAMESPACE + "read", number);
		sqlSession.close();
		return review;
	}

	@Override
	public boolean update(Review review) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.update(NAMESPACE + "updateReview", review);
		sqlSession.close();
		if(result==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean delete(int number) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.delete(NAMESPACE + "delete", number);
		sqlSession.close();
		if(result==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<Review> listByModel(String modelName) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Review> reviewList = sqlSession.selectList(NAMESPACE + "listByModelName", modelName);
		sqlSession.close();
		return reviewList;
	}

	@Override
	public List<Review> listByModelByPage(int page, int listSize, String modelName) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		int startNum = ((listSize*(page-1))+1);
		int endNum = (listSize*(page));
		map.put("modelName", modelName);
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<Review> reviewList = sqlSession.selectList(NAMESPACE + "listByModelNameByPage", map);
		sqlSession.close();
		return reviewList;
	}

	@Override
	public int countByModel(String modelName) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int count = sqlSession.selectOne(NAMESPACE + "countByModelName", modelName);
		sqlSession.close();
		return count;
	}

}










