package kr.or.kosta.blog.user.dao;

import java.util.List;
import java.util.Map;

import kr.or.kosta.blog.user.domain.User;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 김기정
 *
 */
public interface UserDao {
	
	/** 계정 생성 */
	public void create(User user) throws Exception;
	
	/** id의 계정 읽기 */
	public User read(String id) throws Exception;
	
	/** email로 계정 읽기 */
	public User readEmail(String email) throws Exception;
	
	/** 계정 수정 */
	public void update(User user) throws Exception;
	
	/** 계정 제거 */
	public void delete(String id) throws Exception;
	
	/** 전체 유저 목록 반환 */
	public List<User> listAll() throws Exception;
	
	/** id와 passwd로 인증 */
	public User certify(String id, String passwd) throws Exception;
	
}
