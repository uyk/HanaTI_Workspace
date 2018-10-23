package kr.or.kosta.blog.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import kr.or.kosta.blog.user.domain.User;

/**
 * JDBC API로 DB와 연동하여 User 데이터를 관리하는 Dao
 * @author 유예겸
 *
 */
public class JdbcUserDao implements UserDao {
	
	private DataSource dataSource;
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	/** 계정 생성 */
	@Override
	public void create(User user) throws Exception {
		Connection con =  null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO users \r\n" + 
				     "VALUES     (?, \r\n" + 
				     "            ?, \r\n" + 
				     "            ?, \r\n" + 
				     "            ?, \r\n" + 
				     "            SYSDATE)";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPasswd());
			pstmt.setString(4, user.getEmail());
			pstmt.executeUpdate();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
	}

	/** id의 계정 읽기 */
	@Override
	public User read(String id) throws Exception {
		User user = null;
		
		Connection con =  null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT id, \r\n" + 
				     "       name, \r\n" + 
				     "       passwd, \r\n" + 
				     "       email, \r\n" + 
				     "       TO_CHAR(regdate, 'YYYY\"년\" MM\"월\" DD\"일\" DAY') regdate \r\n" + 
				     "FROM   users \r\n" + 
				     "WHERE  id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = createUser(rs);
			}
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		return user;
	}
	
	/** email로 계정 읽기 */
	@Override
	public User readEmail(String email) throws Exception {
		User user = null;
		
		Connection con =  null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT id, \r\n" + 
				     "       name, \r\n" + 
				     "       passwd, \r\n" + 
				     "       email, \r\n" + 
				     "       TO_CHAR(regdate, 'YYYY\"년\" MM\"월\" DD\"일\" DAY') regdate \r\n" + 
				     "FROM   users \r\n" + 
				     "WHERE  email = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, email);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = createUser(rs);
			}
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		return user;
	}

	/** 계정 수정 */
	@Override
	public void update(User user) throws Exception {
		Connection con =  null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE users \r\n" + 
				     "SET    passwd = ?, \r\n" + 
				     "       email = ? \r\n" + 
				     "WHERE  id = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getPasswd());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getId());
			pstmt.executeUpdate();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		

	}

	/** 계정 제거 */
	@Override
	public void delete(String id) throws Exception {
		// TODO Auto-generated method stub

	}

	/** 전체 유저 목록 반환 */
	@Override
	public List<User> listAll() throws Exception {
		List<User> list = null;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT id, \r\n" + 
				     "       name, \r\n" + 
				     "       passwd, \r\n" + 
				     "       email, \r\n" + 
				     "       TO_CHAR(regdate, 'YYYY/MM/DD HH24:MI:SS') regdate\r\n" + 
				     "FROM   users";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<User>();
			while(rs.next()) {
				User user = createUser(rs);
				list.add(user);
			}
		} finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		return list;
	}
	

	/** id와 passwd로 인증 */
	@Override
	public User certify(String id, String passwd) throws Exception {
		User user = null;
		
		Connection con =  null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT id, \r\n" + 
			     "       name, \r\n" + 
			     "       passwd, \r\n" + 
			     "       email, \r\n" + 
			     "       TO_CHAR(regdate, 'YYYY\"년\" MM\"월\" DD\"일\" DAY') regdate \r\n" + 
			     "FROM   users \r\n" + 
			     "WHERE  id = ? AND passwd = ?";
		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = createUser(rs);
			}
			
		}finally {
			try {
				if(rs != null)    rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)   con.close();
			}catch (Exception e) {}
		}
		return user;
	}
	
	/** SQL의 결과값으로 user 인스턴스를 생성하고 데이터를 저장하는 메소드 */
	private User createUser(ResultSet rs) throws SQLException{
		User user = new User();
		user.setId(rs.getString("id"));
		user.setName(rs.getString("name"));
		user.setPasswd(rs.getString("passwd"));
		user.setEmail(rs.getString("email"));
		user.setRegdate(rs.getString("regdate"));
		return user;
	}
	
}










