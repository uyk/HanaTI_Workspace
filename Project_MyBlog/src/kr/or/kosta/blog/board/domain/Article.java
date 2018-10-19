package kr.or.kosta.blog.board.domain;

/**
 * 게시글 정보를 저장하는 클래스
 * @author 유예겸
 *
 */

public class Article {
	private int articleId; 		/** 게시글 식별번호 */
	private int boardId; 		/** 소속 게시판번호 */		
	private String writer; 		/** 작성자 아이디 */
	private String subject; 	/** 게시글 제목 */
	private String content; 	/** 게시글 내용 */
	private String regdate; 	/** 게시글 등록일자 */
	private int hitcount; 		/** 게시글 조회수 */
	private String ip; 			/** 작성자 아이피 */
	private String passwd; 		/** 게시글 비밀번호 */
	private String attachFile; 	/** 첨부파일 */
	private int groupNo; 		/** 계층형 게시판 구조를 위한 게시글 그룹번호 */
	private int levelNo; 		/** 계층형 게시판 구조를 위한 그룹내 게시글 레벨번호 */
	private int orderNo; 		/** 계층형 게시판 구조를 위한 그룹내 게시글 순서번호*/
	
	public Article() {
		super();
	}
	public Article(int articleId, int boardId, String writer, String subject, String content, String regdate,
			int hitcount, String ip, String passwd, String attachFile, int groupNo, int levelNo, int orderNo) {
		super();
		this.articleId = articleId;
		this.boardId = boardId;
		this.writer = writer;
		this.subject = subject;
		this.content = content;
		this.regdate = regdate;
		this.hitcount = hitcount;
		this.ip = ip;
		this.passwd = passwd;
		this.attachFile = attachFile;
		this.groupNo = groupNo;
		this.levelNo = levelNo;
		this.orderNo = orderNo;
	}
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public int getHitcount() {
		return hitcount;
	}
	public void setHitcount(int hitcount) {
		this.hitcount = hitcount;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getAttachFile() {
		return attachFile;
	}
	public void setAttachFile(String attachFile) {
		this.attachFile = attachFile;
	}
	public int getGroupNo() {
		return groupNo;
	}
	public void setGroupNo(int groupNo) {
		this.groupNo = groupNo;
	}
	public int getLevelNo() {
		return levelNo;
	}
	public void setLevelNo(int levelNo) {
		this.levelNo = levelNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	
	@Override
	public String toString() {
		return "Article [articleId=" + articleId + ", boardId=" + boardId + ", writer=" + writer + ", subject="
				+ subject + ", content=" + content + ", regdate=" + regdate + ", hitcount=" + hitcount + ", ip=" + ip
				+ ", passwd=" + passwd + ", attachFile=" + attachFile + ", groupNo=" + groupNo + ", levelNo=" + levelNo
				+ ", orderNo=" + orderNo + "]";
	}
}
