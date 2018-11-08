/**
 * QnA 에 필요한 메소드
 * @author 윤형철
 */

package kr.or.kosta.sjrent.qna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.sjrent.qna.domain.QnA;
import kr.or.kosta.sjrent.qna.paging.Params;

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
	public boolean create(QnA qna) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.insert(NAMESPACE + "insertQnA", qna);
		sqlSession.close();
		if(result ==1) {
			return true;
		}else {
			return false;	
		}		
	}

	@Override
	public QnA read(int seq) throws Exception {
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		QnA qna = sqlSession.selectOne(NAMESPACE + "readQnA", seq);
		sqlSession.close();
		return qna;
	}

	@Override
	public boolean update(QnA qna) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.update(NAMESPACE + "updateQnA", qna);
		sqlSession.close();
		if(result==1) {
			return true;
		}else {
			return false;
		}		
	}

	@Override
	public boolean delete(int seq) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.delete(NAMESPACE + "deleteQnA", seq);
		sqlSession.close();
		if(result==1) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public List<QnA> listAll() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<QnA> qnaList = sqlSession.selectList(NAMESPACE + "listAll");
		sqlSession.close();
		return qnaList;
	}


	
	

	@Override
	public List<QnA> listByPage(int page, int listSize, String searchType, String searchValue) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<QnA> listByPage(Params params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countBySearch(String searchType, String searchValue) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int countBySearch(Params params) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}


	
	
}










