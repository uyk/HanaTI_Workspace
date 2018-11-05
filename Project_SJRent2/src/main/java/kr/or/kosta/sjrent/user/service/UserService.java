package kr.or.kosta.sjrent.user.service;

import java.util.List;

import kr.or.kosta.sjrent.user.domain.User;

/**
 * 고객의 요구사항을 반영한 도메인(개발하고자 하는 업무영역)별 비즈니스 메소드 선언
 * 복잡한 트랜잭션 처리, 예외처리 등
 * @author 남수현
 */
public interface UserService {
	
	// 유저 생성. 성공 시 true, 실패 시 false 반환
	public boolean create(User user) throws Exception;
	
	public User read(String id) throws Exception;

	public User readByCellphone(String cellphone) throws Exception;

	public boolean update(User user) throws Exception;
	
	public boolean delete(String id) throws Exception;
	
	public User certify(String id, String password) throws Exception;
	
	public boolean isExistId(String id) throws Exception;

	public boolean isExistEmail(String email) throws Exception;

	//입력 된 값만큼 포인트 변경 후 결과 포인트 반환(줄이려면 -값 입력) 변경 실패 시 -9999 반환
	public int addPoint(String id, int point)throws Exception;
	
	public int checkPoint(String id)throws Exception;
	
}
