package kr.or.kosta.sjrent.qna.domain;

public class QnA {

	private int qna_seq;
	private int user_seq;
	private String id;
	private String title;
	private String content;
	private String date;
	private String answer;

	public QnA() {
		super();
	}

	public int getQna_seq() {
		return qna_seq;
	}

	public void setQna_seq(int qna_seq) {
		this.qna_seq = qna_seq;
	}

	public int getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		return "QnA [qna_seq=" + qna_seq + ", user_seq=" + user_seq + ", id=" + id + ", title=" + title + ", content="
				+ content + ", date=" + date + ", answer=" + answer + "]";
	}

	

}
