package kr.or.kosta.shoppingmall.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.shoppingmall.common.web.Params;
import kr.or.kosta.shoppingmall.user.domain.User;

public class MyBatisUserDao implements UserDao {
	private static final String NAMESPACE = "kr.or.kosta.shoppingmall.user.";
	SqlSessionFactory sqlSessionFactory;
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void create(User user) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		sqlSession.insert(NAMESPACE + "create", user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public User read(String id) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		User user = sqlSession.selectOne(NAMESPACE + "read", id);
		sqlSession.close();
		return user;
	}

	@Override
	public void update(User user) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		sqlSession.selectOne(NAMESPACE + "update", user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void delete(String id) throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		sqlSession.selectOne(NAMESPACE + "delete", id);
//		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public List<User> listAll() throws Exception {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<User> list = sqlSession.selectList(NAMESPACE + "listAll");
		sqlSession.close();
		return list;
	}
	

	@Override
	public User certify(String id, String passwd) throws Exception {
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", id);
		params.put("passwd", passwd);
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		User user = sqlSession.selectOne(NAMESPACE + "certify", params);
		sqlSession.close();
		return user;
	}

	@Override
	public List<User> listByPage(int page) throws Exception {
		return listByPage(page, 10, null, null);
	}

	@Override
	public List<User> listByPage(int page, int listSize) throws Exception {
		return listByPage(page, listSize, null, null);
	}

	@Override
	public List<User> listByPage(int page, int listSize, String searchType, String searchValue) throws Exception {
		Params params = new Params(page, listSize, searchType, searchValue);
		return listByPage(params);
	}

	@Override
	public List<User> listByPage(Params params) throws Exception {
		List<User> list = null;
		
		if(params.getSearchType() != null && params.getSearchType().equals("name")) {
			params.setSearchValue("%" + params.getSearchValue() + "%");
		}
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		list = sqlSession.selectList(NAMESPACE + "listByPage", params);
		sqlSession.close();
		return list;
	}

	@Override
	public int countBySearch(String searchType, String searchValue) throws Exception {
		int count = 0;
		if(searchType != null && searchType.equals("name")) {
			searchValue = "%" + searchValue + "%";
		}
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("searchType", searchType);
		params.put("searchValue", searchValue);
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		count = sqlSession.selectOne(NAMESPACE + "countBySearch", params);
		sqlSession.close();
		return count;
	}

	@Override
	public int countBySearch(Params params) throws Exception {
		if(params == null) return countBySearch(null, null);
		return countBySearch(params.getSearchType(), params.getSearchValue());
	}
}










