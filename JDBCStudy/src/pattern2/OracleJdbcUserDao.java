package pattern2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp2.BasicDataSource;

public class OracleJdbcUserDao extends JdbcUserDAO {

	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521";
	private static final String USER_ID = "hr";
	private static final String USER_PW = "hr";
	private static final int MAX_COUNT = 5;
	private static final int IDLE_COUNT = 2;
	
	@Override
	public Connection getConnection() throws Exception {
		// 커넥션 풀 적용하여 Connection 실행
//		return UserConnectionPool.getInstance().getConnection();
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DRIVER_NAME);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(USER_ID);
		dataSource.setPassword(USER_PW);
		dataSource.setInitialSize(MAX_COUNT);
		dataSource.setMaxIdle(IDLE_COUNT);
		dataSource.setMaxTotal(10);
		
		// DataSource로부터 Connection 취득
		return dataSource.getConnection();	
	}

}

