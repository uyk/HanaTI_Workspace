package kr.or.kosta.sjrent.wishitem.domain;

public class WishItem {
	
	private int number;
	private int userNumber;
	private String model;
	private String startDate;
	private String endDate;
	
	public WishItem() {
		super();
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getUserNumber() {
		return userNumber;
	}

	public void setUserNumber(int userNumber) {
		this.userNumber = userNumber;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "WishItem [number=" + number + ", userNumber=" + userNumber + ", model=" + model + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}

	
}
