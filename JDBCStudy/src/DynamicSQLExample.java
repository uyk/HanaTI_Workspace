
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

/**
 * JDBC API를 이용한 DBMS 연동
 * 
 * @author 유예겸
 *
 */

public class DynamicSQLExample {
	String driver = "oracle.jdbc.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:xe";
	String user = "hr";
	String password = "hr";
	
	public void excuteSQL(String sql) {
		Connection con = null;
		PreparedStatement pstmt = null;	 
		ResultSet rs = null;
		
		try {
			Class.forName(driver);	
			con = DriverManager.getConnection(url, user, password);
			pstmt = con.prepareStatement(sql);
			boolean existRS = pstmt.execute();
			if(existRS) {
				rs = pstmt.getResultSet();
				ResultSetMetaData rsd = rs.getMetaData();
				String[] col = new String[rsd.getColumnCount()];
				
				while(rs.next()) {
					for (int i = 0; i < rsd.getColumnCount(); i++) {
						col[i] = rs.getString(rsd.getColumnName(i+1));
					}
					for (String string : col) {
						System.out.print(string + "\t");
					}
					System.out.println();
				}
			} else {
				int count = pstmt.getUpdateCount();
				System.out.println(count + "개의 행 변경");
			}
			
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
		DynamicSQLExample exam = new DynamicSQLExample();
		exam.excuteSQL(
				"SELECT e.employee_id                    \"id\", \r\n" + 
				"       e.last_name                      \"ename\", \r\n" + 
				"       e.salary                         \"salary\", \r\n" + 
				"       TO_CHAR(e.hire_date, 'yy-mm-dd') \"hiredate\", \r\n" + 
				"       d.department_name                \"dname\" \r\n" + 
				"FROM   employees e \r\n" + 
				"       JOIN departments d \r\n" + 
				"         ON e.department_id = d.department_id \r\n" + 
				"ORDER  BY e.employee_id");
	}
}