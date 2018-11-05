package kr.or.kosta.sjrent.wishitem.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

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
	public void create(WishItem wishItem) throws Exception {
		
	}

	@Override
	public WishItem read(int wishItemNumber) throws Exception {
		return null;
	}

	@Override
	public void update(WishItem wishItem) throws Exception {
		
	}

	@Override
	public void delete(int wishItemNumber) throws Exception {
		
	}

	@Override
	public List<WishItem> listAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WishItem> listByUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	
}










