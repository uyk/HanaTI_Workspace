/**
 * QnA 에 필요한 메소드
 * @author 윤형철
 */

package kr.or.kosta.sjrent.qna.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.sjrent.qna.domain.QnA;
import kr.or.kosta.sjrent.qna.paging.Params;
import kr.or.kosta.sjrent.review.domain.Review;

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
		int result = sqlSession.insert(NAMESPACE + "write", qna);
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
		QnA qna = sqlSession.selectOne(NAMESPACE + "read", seq);
		sqlSession.close();
		return qna;
	}

	@Override
	public boolean update(QnA qna) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.update(NAMESPACE + "update", qna);
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
		int result = sqlSession.delete(NAMESPACE + "delete", seq);
		sqlSession.close();
		if(result==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<QnA> listByPage(int page, int listSize) throws Exception {
		Map<String, Object> map = new HashMap<String,Object>();
		int startNum = ((listSize*(page-1))+1);
		int endNum = (listSize*(page));
		map.put("startNum", startNum);
		map.put("endNum", endNum);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<QnA> qnaList = sqlSession.selectList(NAMESPACE + "listByPage", map);
		sqlSession.close();
		return qnaList;
	}

	@Override
	public int countAll() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int count = sqlSession.selectOne(NAMESPACE + "count");
		sqlSession.close();
		return count;
	}
}










