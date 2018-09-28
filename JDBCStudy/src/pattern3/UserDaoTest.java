package pattern3;

import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;

public class UserDaoTest {
	
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521";
	private static final String USER_ID = "hr";
	private static final String USER_PW = "hr";
	private static final int MAX_COUNT = 5;
	private static final int IDLE_COUNT = 2;

	public static void main(String[] args)  {
		JdbcUserDAO dao = new JdbcUserDAO();
		
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(DRIVER_NAME);
		dataSource.setUrl(DB_URL);
		dataSource.setUsername(USER_ID);
		dataSource.setPassword(USER_PW);
		dataSource.setInitialSize(MAX_COUNT);
		dataSource.setMaxIdle(IDLE_COUNT);
		dataSource.setMaxTotal(10);
		
		dao.setDataSource(dataSource);
		
		// DataSource로부터 Connection 취득
		try {
			List<User> list = dao.listAll();
			for (User user : list) {
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
