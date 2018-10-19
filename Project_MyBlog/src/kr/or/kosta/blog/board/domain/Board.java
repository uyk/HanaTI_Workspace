package kr.or.kosta.blog.board.domain;

/**
 * 게시판 정보를 저장하는 클래스
 * @author 유예겸
 *
 */

public class Board {
    private int boardId;
    private int category;
    private String title;
    private String description;
    
	public Board() {
		super();
	}

	public Board(int boardId, int category, String title, String description) {
		super();
		this.boardId = boardId;
		this.category = category;
		this.title = title;
		this.description = description;
	}
    
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Board [boardId=" + boardId + ", category=" + category + ", title=" + title + ", description="
				+ description + "]";
	}
}
