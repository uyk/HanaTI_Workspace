package pattern2;

import java.util.List;

public class UserDaoTest {

	public static void main(String[] args)  {
		UserDao dao = new OracleJdbcUserDao();
		
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
