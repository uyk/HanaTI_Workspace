package kr.or.kosta.sjrent.qna.domain;

public class QnA {

	private int number;
	private int userSeq;
	private String userId;
	private String title;
	private String content;
	private String date;
	private String answer;

	public QnA() {
		super();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(int userSeq) {
		this.userSeq = userSeq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "QnA [number=" + number + ", userSeq=" + userSeq + ", userId=" + userId + ", title=" + title
				+ ", content=" + content + ", date=" + date + ", answer=" + answer + "]";
	}
	
	
	

}
