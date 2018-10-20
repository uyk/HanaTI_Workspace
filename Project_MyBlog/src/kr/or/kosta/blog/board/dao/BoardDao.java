package kr.or.kosta.blog.board.dao;

import java.util.List;

import kr.or.kosta.blog.board.domain.Board;

/**
 * 게시판 DB와 연동하는 인터페이스
 * 
 * @author 유예겸
 *
 */
public interface BoardDao {
	public void create(Board board) throws Exception;
	
	public Board read(String boardId) throws Exception;
	
	public void update(Board board) throws Exception;
	
	public void delete(String boardId) throws Exception;
	
	/** 전체 게시판 목록 */
	public List<Board> listAll() throws Exception;
}
