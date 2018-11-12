package kr.or.kosta.sjrent.qna.dao;

import java.util.List;

import kr.or.kosta.sjrent.qna.domain.QnA;
import kr.or.kosta.sjrent.qna.paging.Params;

/**
 * Dao 패턴 적용을 위한 인터페이스 선언
 * @author 남수현
 *
 */
public interface QnADao {
	
	// 게시글 등록
	public boolean create(QnA qna) throws Exception;
	// 게시글 상세보기
	public QnA read(int seq) throws Exception;
	// 게시글 수정
	public boolean update(QnA qna) throws Exception;
	// 게시글 삭제
	public boolean delete(int seq) throws Exception;

	// 선택페이지, 조회 목록개수, 검색유형, 검색값에 따른 사용자 목록 반환 */	
	public List<QnA> listByPage(int page, int listSize) throws Exception;
	
	// 전체 qna count - 페이징 처리 시 필요 */	
	public int countAll() throws Exception;

}
