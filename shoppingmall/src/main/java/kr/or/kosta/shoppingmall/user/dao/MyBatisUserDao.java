package kr.or.kosta.shoppingmall.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import kr.or.kosta.shoppingmall.common.web.Params;
import kr.or.kosta.shoppingmall.user.domain.User;

public class MybatisUserDao implements UserDao {
	
	private static final String NAMESPACE = "kr.or.kosta.shoppingmall.user.";
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void create(User user) throws Exception {
	}

	@Override
	public User read(String id) throws Exception {
		return null;
	}

	@Override
	public void update(User user) throws Exception {

	}

	@Override
	public void delete(String id) throws Exception {

	}

	@Override
	public List<User> listAll() throws Exception {
		List<User> list = null;
		SqlSession sqlSession = sqlSessionFactory.openSession();
		list = sqlSession.selectList(NAMESPACE + "listAll");
		sqlSession.close();
		return list;
	}
	
	public List<User> listAll2() throws Exception {
		List<User> list = null;
		try(SqlSession sqlSession = sqlSessionFactory.openSession()){
			list = sqlSession.selectList(NAMESPACE + "listAll");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	@Override
	public User certify(String id, String passwd) throws Exception {
		return null;
	}
	
	private User createUser(ResultSet rs) throws SQLException{
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPasswd(rs.getString("passwd"));
		user.setEmail(rs.getString("email"));
		user.setRegdate(rs.getString("regdate"));
		return user;
	}
	
	
	@Override
	public List<Map<String, String>> employeeList() throws Exception {
		return null;
	}

	@Override
	public List<User> listByPage(int page) throws Exception {
		return null;
	}

	@Override
	public List<User> listByPage(int page, int listSize) throws Exception {
		return null;
	}

	@Override
	public List<User> listByPage(int page, int listSize, String searchType, String searchValue) throws Exception {
		return null;
	}

	@Override
	public List<User> listByPage(Params params) throws Exception {
		return null;
	}

	@Override
	public int countBySearch(String searchType, String searchValue) throws Exception {
		return 0;
	}

	@Override
	public int countBySearch(Params params) throws Exception {
		return 0;
	}
}










