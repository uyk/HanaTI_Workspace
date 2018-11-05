package kr.or.kosta.sjrent.faq.domain;

public class FAQ {

	private int number;
	private String title;
	private String content;
	
	public FAQ() {
		super();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
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

	@Override
	public String toString() {
		return "FAQ [number=" + number + ", title=" + title + ", content=" + content + "]";
	}
	
	
	
}
