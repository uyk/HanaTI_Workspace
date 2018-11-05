package kr.or.kosta.sjrent.faq.dao;

import java.util.List;

import kr.or.kosta.sjrent.faq.domain.FAQ;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 남수현
 *
 */
public interface FAQDao {
	
	public void create(FAQ faq) throws Exception;
	
	public FAQ read(int number) throws Exception;

	public void update(FAQ faq) throws Exception;
	
	public void delete(int number) throws Exception;

	public List<FAQ> listAll() throws Exception;

}
