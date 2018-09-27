
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import java.sql.Driver;
//import oracle.jdbc.OracleDriver;

public class JDBCExample {

	public static void main(String[] args) {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		String sql = "SELECT employee_id, last_name, salary\r\n" + 
					 "FROM employees";
		// #1. JDBC 드라이버 로딩(객체 생성)
//		Driver driver = new OracleDriver();		// 정적 생성
		// Class 클래스를 이용한 동적 객체 생성
//		Class.forName(driver).newInstance();
		try {
			Class.forName(driver);		// newInstance() 안해도 자동으로 호출됨.
//			System.out.println("JDBC 드라이버 생성 완료");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// #2. DBMS 연결
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url, user, password);
//			System.out.println("DBMS 연결 완료 " + con);
			
			// #3. SQL 서버 전송 및 결과 집합 수신
			stmt = con.createStatement();
//			System.out.println(stmt);
			rs = stmt.executeQuery(sql);
//			System.out.println(rs);
			while(rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String lastName = rs.getString("last_name");
				int salary = rs.getInt("salary");
				System.out.println(employeeId + " " + lastName + " "+salary);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null)	rs.close();
				if(stmt != null) stmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
}