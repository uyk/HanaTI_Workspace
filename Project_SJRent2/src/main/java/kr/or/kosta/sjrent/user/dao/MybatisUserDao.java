package kr.or.kosta.sjrent.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.kosta.sjrent.user.domain.User;

public class MybatisUserDao implements UserDao {
	
	private static final String NAMESPACE = "kr.or.kosta.sjrent.user.";
	
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public boolean create(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.insert(NAMESPACE + "insertUser", user);
		sqlSession.close();
		if(result==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public User read(String id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne(NAMESPACE + "read", id);
		sqlSession.close();
		return user;
	}
	
	@Override
	public User readByCellphone(String cellphone) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne(NAMESPACE + "readByCellPhone", cellphone);
		sqlSession.close();
		return user;
	}

	@Override
	public User readByEmail(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne(NAMESPACE + "readByEmail", email);
		sqlSession.close();
		return user;
	}
	
	@Override
	public boolean update(User user) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.update(NAMESPACE + "updateUser", user);
		sqlSession.close();
		if(result==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean delete(String id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.delete(NAMESPACE + "deleteUser", id);
		sqlSession.close();
		if(result==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public User certify(String id, String password) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("password",password);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne(NAMESPACE + "certify", paramMap);
		sqlSession.close();
		return user;
	}

	@Override
	public boolean isExistId(String id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String resultId = sqlSession.selectOne(NAMESPACE + "isExistId", id);
		sqlSession.close();
		if(resultId!=null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean isExistEmail(String email) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		String resultEmail = sqlSession.selectOne(NAMESPACE + "isExistEmail", email);
		sqlSession.close();
		if(resultEmail!=null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean addPoint(String id, int point) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id", id);
		paramMap.put("point",point);
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		int result = sqlSession.update(NAMESPACE + "addUserPoint", paramMap);
		sqlSession.close();
		if(result==1) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public int checkPoint(String id) throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int result = sqlSession.selectOne(NAMESPACE + "checkUserPoint", id);
		sqlSession.close();
		return result;
	}

}










