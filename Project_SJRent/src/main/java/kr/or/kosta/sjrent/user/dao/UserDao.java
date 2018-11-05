package kr.or.kosta.sjrent.user.dao;

import kr.or.kosta.sjrent.user.domain.User;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 남수현
 *
 */
public interface UserDao {
	
	public boolean create(User user) throws Exception;
	
	public User read(String id) throws Exception;

	public User readByCellphone(String cellphone) throws Exception;

	public boolean update(User user) throws Exception;
	
	public boolean delete(String id) throws Exception;
	
	public User certify(String id, String passwd) throws Exception;
	
	public boolean isExistId(String id) throws Exception;

	public boolean isExistEmail(String email) throws Exception;

	public boolean addPoint(String id, int point) throws Exception;

	public int checkPoint(String id) throws Exception;
}
