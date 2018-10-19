package kr.or.kosta.blog.board.domain;

/**
 * 게시글 정보를 저장하는 클래스
 * @author 유예겸
 *
 */

public class Article {
	private int articleId;
	private int boardId;
	private String writer;
	private String subject;
	private String content;
	private String regdate;
	private int hitcount;
	private String ip;
	private String passwd;
	private String attachFile;
	private int groupNo;
	private int orderNo;
	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article(int articleId, int boardId, String writer, String subject, String content, String regdate,
			int hitcount, String ip, String passwd, String attachFile, int groupNo, int orderNo) {
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
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
}
