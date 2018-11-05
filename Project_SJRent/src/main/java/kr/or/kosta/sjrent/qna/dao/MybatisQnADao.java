package kr.or.kosta.sjrent.qna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.sjrent.qna.domain.QnA;

public class MybatisQnADao implements QnADao {
	
	private static final String NAMESPACE = "kr.or.kosta.sjrent.qna.";
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void create(QnA qna) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public QnA read(int number) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(QnA qna) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int number) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<QnA> listAll(int page, int listSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QnA> listByPage(int page, int listSize) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countListAll() throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
}










