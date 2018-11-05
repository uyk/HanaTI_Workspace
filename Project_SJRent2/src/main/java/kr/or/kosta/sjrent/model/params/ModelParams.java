package kr.or.kosta.sjrent.model.params;

/**
 * 차량 검색을 위한 전달인자들을 포장하기 위한 Wrapper 클래스
 * {페이지, 조회 목록 개수, 시작일, 종료일, 연료 타입, 인승, 변속기, 네비게이션, 후방카메라, 블랙박스 등}
 *  
 * @author 남수현
 */
public class ModelParams {
	private int page;
	private int listSize;
	private String startDate;
	private String endDate;
	private String fuelType;
	private int seater;
	private String transmission;
	private String navigation;
	private String cameraRear;
	private String blackBox;
	public ModelParams() {
		// 0으로 들어오면 전체 검색 하도록 하기
		this(1, 15, null, null, null, 0, null, null, null, null);
	}
	public ModelParams(String startDate, String endDate) {
		this(1, 15, startDate, endDate, null, 0, null, null, null, null);
	}
	
	
	public ModelParams(int page, int listSize, String startDate, String endDate, String fuelType, int seater,
			String transmission, String navigation, String cameraRear, String blackBox) {
		this.page = page;
		this.listSize = listSize;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fuelType = fuelType;
		this.seater = seater;
		this.transmission = transmission;
		this.navigation = navigation;
		this.cameraRear = cameraRear;
		this.blackBox = blackBox;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getListSize() {
		return listSize;
	}
	public void setListSize(int listSize) {
		this.listSize = listSize;
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
	public String getNavigation() {
		return navigation;
	}
	public void setNavigation(String navigation) {
		this.navigation = navigation;
	}
	public String getCameraRear() {
		return cameraRear;
	}
	public void setCameraRear(String cameraRear) {
		this.cameraRear = cameraRear;
	}
	public String getBlackBox() {
		return blackBox;
	}
	public void setBlackBox(String blackBox) {
		this.blackBox = blackBox;
	}

	
}
