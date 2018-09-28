package pattern;

import java.util.List;

public class UserDaoTest {

	public static void main(String[] args)  {
		UserDao dao = new JdbcUserDAO();
		User user = new User();
		user.setId("vv");
		user.setName("김기정11");
		user.setPasswd("11b");
		user.setEmail("abcd@abc.com");
		
		try {
//			dao.create(user);
//			System.out.println("회원가입 완료");
			
//			dao.update(user);
//			dao.delete(user.getId());
//			List<User> usersList = dao.listAll();
//			System.out.println(usersList);

//			System.out.println(dao.read(user.getId()));
//			System.out.println(dao.certify("bbb", "1101"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
