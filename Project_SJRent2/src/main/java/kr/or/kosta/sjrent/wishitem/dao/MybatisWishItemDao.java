package kr.or.kosta.sjrent.wishitem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.sjrent.user.domain.User;
import kr.or.kosta.sjrent.wishitem.domain.WishItem;

public class MybatisWishItemDao implements WishItemDao {
	
	private static final String NAMESPACE = "kr.or.kosta.sjrent.wishitem.";
	private SqlSessionFactory sqlSessionFactory;
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public boolean create(WishItem wishItem) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.insert(NAMESPACE + "add", wishItem);
		sqlSession.close();
		if(result==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public WishItem read(int wishItemNumber) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		WishItem wishItem = sqlSession.selectOne(NAMESPACE + "read", wishItemNumber);
		sqlSession.close();
		return wishItem;
	}

	@Override
	public void update(WishItem wishItem) throws Exception {
		
	}

	@Override
	public boolean delete(int wishItemNumber) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.delete(NAMESPACE + "delete", wishItemNumber);
		sqlSession.close();
		if(result==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public List<WishItem> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WishItem> listByUser(String userId) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<WishItem> wishItemList = sqlSession.selectList(NAMESPACE + "delete", userId);
		sqlSession.close();
		return wishItemList;
	}
}










