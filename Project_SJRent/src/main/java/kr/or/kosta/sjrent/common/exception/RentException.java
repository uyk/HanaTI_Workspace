package kr.or.kosta.sjrent.common.exception;

/**
 * 사용자 정의 RuntimeException
 * 
 * @author 남수현
 */
public class RentException extends RuntimeException {
	
	private static final String DEFAULT_CODE = "KMS-0001";
	private String code;

	public RentException() {
		this(DEFAULT_CODE, "Database Server Error!");				
	}
		
	public RentException(String message) {
		super(message);
	}

	public RentException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public RentException(String code, String message) {
		super(message);
		this.code = code;
	}
	
	public RentException(String code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
