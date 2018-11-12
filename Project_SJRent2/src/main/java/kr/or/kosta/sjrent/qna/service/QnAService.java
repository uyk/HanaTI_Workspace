package kr.or.kosta.sjrent.qna.service;

import java.util.List;

import kr.or.kosta.sjrent.qna.domain.QnA;
import kr.or.kosta.sjrent.qna.paging.Params;

public interface QnAService {
	
	// QnA 생성
	public boolean create(QnA qna) throws Exception;
	// QnA 상세보기
	public QnA read(int seq) throws Exception;
	// QnA 수정
	public boolean update(QnA qna) throws Exception;
	// QnA 삭제
	public boolean delete(int seq) throws Exception;
	// QnA 목록 by Page
	public List<QnA> listByPage(int page, int listSize) throws Exception;
	// QnA 숫자
	public int count() throws Exception;
	// QnA 답글 달기
	public boolean writeAnswer(int seq, String answer) throws Exception;
	
}
