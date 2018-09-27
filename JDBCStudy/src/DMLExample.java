
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

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
		create2(new Department(0, departmentName, managerId, locationId));
	}
	
	public void create2(Department department) {
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
			pstmt.setString(1, department.getDepartmentName());
			if(department.getManagerId() != 0) {
				pstmt.setInt(2, department.getManagerId());
			}
			else {
				pstmt.setNull(2, Types.INTEGER);
			}
			
			if(department.getLocationId() != 0) {
				pstmt.setInt(3, department.getLocationId());
			}
			else {
				pstmt.setNull(3, Types.INTEGER);
			}
			
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
	
	public void delete(int departmentID) {
		sql = 	"		DELETE FROM departments \r\n" + 
				"		WHERE  department_id = ?";
		 
		Connection con = null;
		PreparedStatement pstmt = null;	 
		
		try {
			Class.forName(driver);	
			
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false);
			
			// SQL 전처리
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, departmentID);
			int count = pstmt.executeUpdate();
			
			System.out.println(count + "행이 제거되었습니다.");
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
//		exam.create2("코스타400", 200, 1700);
//		exam.create3("코스타101", null, null);
		
		exam.delete(400);
		

	}
}