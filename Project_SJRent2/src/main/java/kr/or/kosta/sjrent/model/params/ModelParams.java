package kr.or.kosta.sjrent.model.params;

/**
 * 차량 검색을 위한 전달인자들을 포장하기 위한 Wrapper 클래스
 * {시작일, 종료일, 타입(중형 대형 등), 연료 타입, 인승, 변속기, 네비게이션, 후방카메라, 블랙박스 등}
 *  
 * @author 남수현
 */
public class ModelParams {
	private String startDate;
	private String endDate;
	private String fuelType;
	private String type;
	private int seater;
	private String transmission;
	private int navigation;
	private int cameraRear;
	private int blackBox;
	private int highpass;

	public ModelParams() {
		super();
	}
	public ModelParams(String startDate, String endDate, String fuelType, int seater,
			String transmission, int navigation, int cameraRear, int blackBox) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.fuelType = fuelType;
		this.seater = seater;
		this.transmission = transmission;
		this.navigation = navigation;
		this.cameraRear = cameraRear;
		this.blackBox = blackBox;
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
	public int getBlackBox() {
		return blackBox;
	}
	public void setBlackBox(int blackBox) {
		this.blackBox = blackBox;
	}
	public int getHighpass() {
		return highpass;
	}
	public void setHighpass(int highpass) {
		this.highpass = highpass;
	}
	
}
