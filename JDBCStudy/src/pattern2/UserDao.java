package pattern2;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * DAO 패턴 적용을 위한 인터페이스
 * @author 유예겸
 *
 */

public interface UserDao {
	public void create(User user) throws Exception;
	public User read(String id) throws Exception;
	public void update(User user) throws Exception;
	public void delete(String id) throws Exception;
	public List<User> listAll() throws Exception;
	public User certify(String id, String passwd) throws Exception;
	public Connection getConnection() throws Exception;
	
}
