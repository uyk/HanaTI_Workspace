package kr.or.kosta.sjrent.review.domain;

public class Review {

	private int number;
	private String modelName;
	private int userNumber;
	private String title;
	private String content;
	private String picture;
	private String date;
	
	public Review() {
		super();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
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

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Reivew [number=" + number + ", modelName=" + modelName + ", userNumber=" + userNumber + ", title="
				+ title + ", content=" + content + ", picture=" + picture + ", date=" + date + "]";
	}
	
}
