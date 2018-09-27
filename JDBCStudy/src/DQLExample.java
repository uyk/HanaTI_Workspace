
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * JDBC API를 이용한 DBMS 연동
 * 
 * @author 유예겸
 *
 */

public class DQLExample {

	public static void main(String[] args) throws SQLException {
		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";
		String sql = 
				"SELECT e.employee_id                    \"id\", \r\n" + 
				"       e.last_name                      \"ename\", \r\n" + 
				"       e.salary                         \"salary\", \r\n" + 
				"       TO_CHAR(e.hire_date, 'yy-mm-dd HH24') \"hiredate\", \r\n" + 
				"       d.department_name                \"dname\" \r\n" + 
				"FROM   employees e \r\n" + 
				"       JOIN departments d \r\n" + 
				"         ON e.department_id = d.department_id ";

		
		try {
			Class.forName(driver);	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
	
		con = DriverManager.getConnection(url, user, password);
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			int id = rs.getInt("id");
			String ename = rs.getString("ename");
			int salary = rs.getInt("salary");
			String hiredate = rs.getString("hiredate");
			String dname = rs.getString("dname");
			System.out.println(id + "\t" + ename + "\t\t" + salary + "\t" +hiredate + "\t" + dname);
		}
		
		if(rs != null)	rs.close();
		if(stmt != null) stmt.close();
		if(con != null) con.close();

	}
}