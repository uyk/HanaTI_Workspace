package kr.or.kosta.sjrent.qna.service;

import java.util.List;

import kr.or.kosta.sjrent.qna.domain.QnA;

public interface QnAService {
	public void create(QnA qna) throws Exception;
	
	public QnA read(int number) throws Exception;

	public void update(QnA qna) throws Exception;
	
	public void delete(int number) throws Exception;

	public List<QnA> listAll(int page, int listSize) throws Exception;

	public List<QnA> listByPage(int page, int listSize) throws Exception;
	
	public int countListAll() throws Exception;
}
