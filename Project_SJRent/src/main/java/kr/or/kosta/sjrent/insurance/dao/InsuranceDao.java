package kr.or.kosta.sjrent.insurance.dao;

import java.util.List;

import kr.or.kosta.sjrent.insurance.domain.Insurance;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 남수현
 *
 */
public interface InsuranceDao {
	
	public void create(Insurance insurance) throws Exception;
	
	public Insurance read(int number) throws Exception;

	public void update(Insurance insurance) throws Exception;
	
	public void delete(int number) throws Exception;

	public List<Insurance> listAll() throws Exception;
}
