package kr.or.kosta.sjrent.faq.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.sjrent.faq.domain.FAQ;

public class MybatisFAQDao implements FAQDao {
	
	private static final String NAMESPACE = "kr.or.kosta.sjrent.faq.";
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void create(FAQ faq) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public FAQ read(int number) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		FAQ faq = sqlSession.selectOne(NAMESPACE + "read", number);
		sqlSession.close();
		return faq;
	}

	@Override
	public void update(FAQ faq) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int number) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FAQ> listAll() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<FAQ> faqList = sqlSession.selectList(NAMESPACE + "listAll");
		sqlSession.close();
		return faqList;
	}

	
}










