package pattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcUserDAO implements UserDao {
	private static final String driver = "oracle.jdbc.OracleDriver";
	private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String userName = "hr";
	private static final String password = "hr";

	@Override
	public void create(User user) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = 
				"INSERT INTO users \r\n" + 
				"VALUES      ( ?, \r\n" + 
				"              ?, \r\n" + 
				"              ?, \r\n" + 
				"              ?, \r\n" + 
				"              sysdate )";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPasswd());
			pstmt.setString(4, user.getEmail());
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null) pstmt.close();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(con != null) con.close();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		
	}

	@Override
	public User read(String id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = 
				"SELECT * \r\n" + 
				"FROM   users \r\n" + 
				"WHERE  id = ? ";
		User user = new User();
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setEmail(rs.getString("email"));
				user.setRegdate(rs.getString("regdate"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(pstmt != null) pstmt.close();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(con != null) con.close();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return user;
	}

	@Override
	public void update(User user) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		String sql = 
				"UPDATE users \r\n" + 
				"SET    id = ?, \r\n" + 
				"       NAME = ?, \r\n" + 
				"       passwd = ?, \r\n" + 
				"       email = ?, \r\n" + 
				"       regdate = sysdate \r\n" + 
				"WHERE  id = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getName());
			pstmt.setString(3, user.getPasswd());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getId());
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null) pstmt.close();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(con != null) con.close();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public void delete(String id) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sql = 
				"DELETE FROM users \r\n" + 
				"WHERE  id = ?";
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();

		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(pstmt != null) pstmt.close();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(con != null) con.close();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
		}

	}

	@Override
	public List<User> listAll() throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = 
				"SELECT * \r\n" + 
				"FROM   users";
		
		List<User> usersList = new ArrayList<>();
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setEmail(rs.getString("email"));
				user.setRegdate(rs.getString("regdate"));
				usersList.add(user);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(pstmt != null) pstmt.close();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(con != null) con.close();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return usersList;
	}

	@Override
	public User certify(String id, String passwd) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = 
				"SELECT * \r\n" + 
				"FROM   users \r\n" + 
				"WHERE  id = ? \r\n" + 
				"       AND passwd = ?";
		User user = new User();
		
		try {
			con = getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPasswd(rs.getString("passwd"));
				user.setEmail(rs.getString("email"));
				user.setRegdate(rs.getString("regdate"));
			}
			else return null;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(rs != null) rs.close();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(pstmt != null) pstmt.close();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
			try {
				if(con != null) con.close();
			}catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return user;
	}


	@Override
	public Connection getConnection() throws Exception {
		Class.forName(driver).newInstance();
		return DriverManager.getConnection(url, userName, password);
	}

	@Override
	public List<Map<String, String>> employeeList() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
