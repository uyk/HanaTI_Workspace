
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC API를 이용한 DBMS 연동
 * 
 * @author 유예겸
 *
 */

public class DMLExample {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String password = "hr";
	String sql = "";
	
	public void create(String departmentName, String managerId, String locationId) {
		/*
		// 만약 int로 하면 null을 못하기때문에				// Integer 클래스를 한다면??
		String mId = "NULL";
		String lId = "NULL";
		if(managerId != 0) {
			mId = managerId + "";
		}
		if(locationId != 0) {
			lId = locationId + "";
		}
		*/
		 sql = 	"INSERT INTO departments \r\n" + 
				"            (department_id , \r\n" + 
				"             department_name, \r\n" + 
				"             manager_id, \r\n" + 
				"             location_id) \r\n" + 
				"VALUES      (departments_seq.nextval, \r\n" + 
				"             '" + departmentName + "', \r\n" + 
				"             "+ managerId + ", \r\n" + 
				"             "+ locationId +")";
		 

		Connection con = null;
		Statement stmt = null;	 
		
		try {
			Class.forName(driver);	
			
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			stmt = con.createStatement();
			int count = stmt.executeUpdate(sql);
			System.out.println(count + "행이 추가되었습니다.");
			con.commit();	
//			con.rollback();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) stmt.close();
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

	public void create2(String departmentName, int managerId, int locationId) {
		sql = 	"INSERT INTO departments \r\n" + 
				"            (department_id , \r\n" + 
				"             department_name, \r\n" + 
				"             manager_id, \r\n" + 
				"             location_id) \r\n" + 
				"VALUES      (departments_seq.nextval, \r\n" + 
				"             ?, \r\n" + 
				"             ?, \r\n" + 
				"             ?)";
		 
		Connection con = null;
		PreparedStatement pstmt = null;	 
		
		try {
			Class.forName(driver);	
			
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			
			// SQL 전처리
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, departmentName);
			pstmt.setInt(2, managerId);
			pstmt.setInt(3, locationId);
			int count = pstmt.executeUpdate();
			System.out.println(count + "행이 추가되었습니다.");
			con.commit();	
//			con.rollback();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
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
	
	public void create3(String departmentName, Integer managerId, Integer locationId) {
		sql = 	"INSERT INTO departments \r\n" + 
				"            (department_id , \r\n" + 
				"             department_name, \r\n" + 
				"             manager_id, \r\n" + 
				"             location_id) \r\n" + 
				"VALUES      (departments_seq.nextval, \r\n" + 
				"             ?, \r\n" + 
				"             ?, \r\n" + 
				"             ?)";
		 
		Connection con = null;
		PreparedStatement pstmt = null;	 
		
		try {
			Class.forName(driver);	
			
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			
			// SQL 전처리
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, departmentName);
			pstmt.setInt(2, managerId);
			pstmt.setInt(3, locationId);
			int count = pstmt.executeUpdate();
			System.out.println(count + "행이 추가되었습니다.");
			con.commit();	
//			con.rollback();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
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
	
	public static void main(String[] args) {
		DMLExample exam = new DMLExample();
//		exam.create("코스타3", null, null);
		exam.create2("코스타100", 200, 1700);
//		exam.create3("코스타101", null, null);
		

	}
}