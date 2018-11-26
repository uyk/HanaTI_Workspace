package kr.or.kosta.spring.board.mapper;

import java.util.List;

import kr.or.kosta.spring.board.domain.BoardVO;
import kr.or.kosta.spring.board.domain.Criteria;

public interface BoardMapper {
	public List<BoardVO> getList();
	
	public List<BoardVO> getListWithPaging(Criteria cri); 
	
	public void insert(BoardVO board); 
	
	public void insertSelectKey(BoardVO board); 
	
	public BoardVO read(Long bno);
	
	/** bno 번호의 데이터를 제거. 몇 개가 삭제되었는지 반환*/
	public int delete(Long bno); 
	
	public int update(BoardVO board); 
	
	public int getTotalCount(Criteria cri);
	
}
