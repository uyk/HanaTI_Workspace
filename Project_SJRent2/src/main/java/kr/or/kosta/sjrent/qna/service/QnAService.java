package kr.or.kosta.sjrent.qna.service;

import java.util.List;

import kr.or.kosta.sjrent.qna.domain.QnA;
import kr.or.kosta.sjrent.qna.paging.Params;

public interface QnAService {
	
	// 게시글 생성
	public boolean create(QnA qna) throws Exception;
	// 게시글 상세보기
	public QnA read(int seq) throws Exception;
	// 게시글 수정
	public boolean update(QnA qna) throws Exception;
	// 게시글 삭제
	public boolean delete(int seq) throws Exception;
	// 게시글 전체 목록
	public List<QnA> listAll() throws Exception;
	
	
	
	
	// 선택페이지, 조회 목록개수, 검색유형, 검색값에 따른 사용자 목록 반환 */	
	public List<QnA> listByPage(int page, int listSize, String searchType, String searchValue) throws Exception;
	
	public List<QnA> listByPage(Params params) throws Exception;
	
	// 검색유형, 검색값에 따른 사용자 개수 반환 - 페이징 처리 시 필요 */	
	public int countBySearch(String searchType, String searchValue) throws Exception;
	
	public int countBySearch(Params params) throws Exception;

	
	
	
}
