package kr.or.kosta.sjrent.model.domain;

public class Model {

	private String name;
	private String fuelType;
	private double fuelEfficiency;
	private int seater;
	private String transmission;
	private int navigation;
	private int cameraRear;
	private int year;
	private int highpass;
	private int blackBox;
	private String options;
	private String picture;
	private String type;
	private int weekdayPrice;
	private int weekendPrice;
	private double evalScore;
	private int rentalCount;
	
	public Model() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFuelType() {
		return fuelType;
	}
	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}
	public double getFuelEfficiency() {
		return fuelEfficiency;
	}
	public void setFuelEfficiency(double fuelEfficiency) {
		this.fuelEfficiency = fuelEfficiency;
	}
	public int getSeater() {
		return seater;
	}
	public void setSeater(int seater) {
		this.seater = seater;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
	public int getNavigation() {
		return navigation;
	}
	public void setNavigation(int navigation) {
		this.navigation = navigation;
	}
	public int getCameraRear() {
		return cameraRear;
	}
	public void setCameraRear(int cameraRear) {
		this.cameraRear = cameraRear;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getHighpass() {
		return highpass;
	}
	public void setHighpass(int highpass) {
		this.highpass = highpass;
	}

	public int getBlackBox() {
		return blackBox;
	}
	public void setBlackBox(int blackBox) {
		this.blackBox = blackBox;
	}
	public String getOption() {
		return options;
	}
	public void setOption(String option) {
		this.options = option;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getWeekdayPrice() {
		return weekdayPrice;
	}
	public void setWeekdayPrice(int weekdayPrice) {
		this.weekdayPrice = weekdayPrice;
	}
	public int getWeekendPrice() {
		return weekendPrice;
	}
	public void setWeekendPrice(int weekendPrice) {
		this.weekendPrice = weekendPrice;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	public double getEvalScore() {
		return evalScore;
	}
	public void setEvalScore(double evalScore) {
		this.evalScore = evalScore;
	}
	
	public int getRentalCount() {
		return rentalCount;
	}
	public void setRentalCount(int rentalCount) {
		this.rentalCount = rentalCount;
	}
	@Override
	public String toString() {
		return "Model [name=" + name + ", fuelType=" + fuelType + ", fuelEfficiency=" + fuelEfficiency + ", seater="
				+ seater + ", transmission=" + transmission + ", navigation=" + navigation + ", cameraRear="
				+ cameraRear + ", year=" + year + ", highpass=" + highpass + ", blackBox=" + blackBox + ", options="
				+ options + ", picture=" + picture + ", type=" + type + ", weekdayPrice=" + weekdayPrice
				+ ", weekendPrice=" + weekendPrice + ", evalScore=" + evalScore + ", rentalCount=" + rentalCount + "]";
	}
	
	
	
}
