package kr.or.kosta.sjrent.wishitem.domain;

public class WishItem {
	
	private int number;
	private int userNumber;
	private String userId;
	private String modelName;
	private String startDate;
	private String endDate;
	private int amountMoney;
	private String picture;
	private String type;
	private String fuelType;
	
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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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
	
	
	
	public int getAmountMoney() {
		return amountMoney;
	}

	public void setAmountMoney(int amountMoney) {
		this.amountMoney = amountMoney;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	@Override
	public String toString() {
		return "WishItem [number=" + number + ", userNumber=" + userNumber + ", userId=" + userId + ", modelName="
				+ modelName + ", startDate=" + startDate + ", endDate=" + endDate + ", amountMoney=" + amountMoney
				+ ", picture=" + picture + ", type=" + type + ", fuelType=" + fuelType + "]";
	}
}
