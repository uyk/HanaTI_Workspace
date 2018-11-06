package kr.or.kosta.sjrent.rent.domain;

public class Rent {
	
	private int seq;
	private int insuranceNumber;
	private int userSeq;
	private String userId;
	private String carNumber;
	private String startDate;
	private String endDate;
	private String pickupPlace;
	private int paidAmount;
	private String paymentOption;
	private int isCanceled;
	
	public Rent() {
		super();
	}

	public int getSeq() {
		return seq;
	}



	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getInsuranceNumber() {
		return insuranceNumber;
	}

	public void setInsuranceNumber(int insuranceNumber) {
		this.insuranceNumber = insuranceNumber;
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

	public String getCarNumber() {
		return carNumber;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
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

	public String getPickupPlace() {
		return pickupPlace;
	}

	public void setPickupPlace(String pickupPlace) {
		this.pickupPlace = pickupPlace;
	}

	public int getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getPaymentOption() {
		return paymentOption;
	}

	public void setPaymentOption(String paymentOption) {
		this.paymentOption = paymentOption;
	}

	public int getIsCanceled() {
		return isCanceled;
	}

	public void setIsCanceled(int isCanceled) {
		this.isCanceled = isCanceled;
	}

	@Override
	public String toString() {
		return "Rent [seq=" + seq + ", insuranceNumber=" + insuranceNumber + ", userSeq=" + userSeq + ", userId="
				+ userId + ", carNumber=" + carNumber + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", pickupPlace=" + pickupPlace + ", paidAmount=" + paidAmount + ", paymentOption=" + paymentOption
				+ ", isCanceled=" + isCanceled + "]";
	}

	
	
	

}
