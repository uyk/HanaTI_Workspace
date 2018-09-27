package pattern;

public class UserDaoTest {

	public static void main(String[] args)  {
		UserDao dao = new JdbcUserDAO();
		User user = new User();
		user.setId("vv");
		user.setName("김기정");
		user.setPasswd("1111");
		user.setEmail("abcd@abc.com");
		
		try {
			dao.create(user);
			System.out.println("회원가입 완료");
			System.out.println(dao.read("bangry"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
