package pattern2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import java.util.Map;

public class MongoDbJdbcUserDao extends JdbcUserDAO {

	@Override
	public Connection getConnection() throws Exception {
		// MongoDB에 맞게 Connection 생성 코드
		return null;
	}

}
