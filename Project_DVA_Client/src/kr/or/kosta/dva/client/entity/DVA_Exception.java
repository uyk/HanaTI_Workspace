package kr.or.kosta.dva.client.entity;

public class DVA_Exception extends Exception{
	static final int DEFAULT = 100;
	
	private int errorCode;
	private String error = "";
	
	public DVA_Exception() {
		this(0,"");
	}
	
	public DVA_Exception(int errorCode) {
		this(errorCode, "");
	}
	
	public DVA_Exception(String error) {
		this(0, "");
	}
	
	public DVA_Exception(int errorCode, String error) {
		this.errorCode = errorCode;
		this.error = error;
		
		System.out.println(error + " " + errorCode);
	}
	
	@Override
	public String toString() {
		//return super.toString();
		return errorCode + error;
	}
}
