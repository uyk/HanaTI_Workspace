package kr.or.kosta.blog.board.dao;

import java.util.List;

import kr.or.kosta.blog.board.domain.Article;
import kr.or.kosta.blog.common.Params;

/**
 * 게시글 DB와 연동하는 인터페이스
 * @author 유예겸
 *
 */

public interface ArticleDao {
	public void create(Article article) throws Exception;
	
	public Article read(String articleId) throws Exception;
	
	public void update(Article article) throws Exception;
	
	public void delete(String articleId) throws Exception;
	
	/** 페이징 처리없이 모든 카테고리의 게시글 목록을 가져오는 메소드*/
	public List<Article> listAll() throws Exception;
	
	/** 선택페이지에 따른 사용자 목록 반환 */	
	public List<Article> listByPage(int page, String boardId) throws Exception;
	
	/** 선택페이지, 조회 목록개수에 따른 사용자 목록 반환 */	
	public List<Article> listByPage(int page, int listSize) throws Exception;
	
	/** 선택페이지, 조회 목록개수, 검색유형, 검색값에 따른 사용자 목록 반환 */	
	public List<Article> listByPage(int page, int listSize, String searchType, String searchValue) throws Exception;
	
	/** 선택페이지, 조회 목록개수, 검색유형, 검색값에 따른 사용자 목록 반환 */	
	public List<Article> listByPage(Params params) throws Exception;
	
	/** 검색유형, 검색값에 따른 사용자 개수 반환 - 페이징 처리 시 필요 */	
	public int countBySearch(String searchType, String searchValue) throws Exception;
	
	public int countBySearch(Params params) throws Exception;

}
