package kr.or.kosta.sjrent.wishitem.domain;

public class WishItem {
	
	private int number;
	private int userNumber;
	private int userId;
	private String modelName;
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

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
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
		return "WishItem [number=" + number + ", userNumber=" + userNumber + ", model=" + modelName + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}

	
}
