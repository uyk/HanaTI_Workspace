package kr.or.kosta.sjrent.qna.dao;

import java.util.List;

import kr.or.kosta.sjrent.qna.domain.QnA;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 남수현
 *
 */
public interface QnADao {
	
	public void create(QnA qna) throws Exception;
	
	public QnA read(int number) throws Exception;

	public void update(QnA qna) throws Exception;
	
	public void delete(int number) throws Exception;

	public List<QnA> listAll(int page, int listSize) throws Exception;

	public List<QnA> listByPage(int page, int listSize) throws Exception;
	
	public int countListAll() throws Exception;
}
