package kr.or.kosta.dva.client.entity;

public class DvaException extends Exception{
	static final int DEFAULT = 100;
	
	private int errorCode;
	private String error = "";
	
	public DvaException() {
		this(0,"");
	}
	
	public DvaException(int errorCode) {
		this(errorCode, "");
	}
	
	public DvaException(String error) {
		this(0, "");
	}
	
	public DvaException(int errorCode, String error) {
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
