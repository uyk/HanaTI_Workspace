
public class AccountException extends Exception {
	//String message;	//상속
	private int errorCode;

	
	public AccountException() {
		this("계좌처리중 예기치 않은 에러가 발생하였습니다.", -9);
		// TODO Auto-generated constructor stub
	}

	public AccountException(String arg0, int errorCode) {
		super(arg0);
		this.errorCode = errorCode;
	}

	public int getErrorCode() {
		return errorCode;
	}

	@Override
	public String toString() {
		return "AccountException [errorCode=" + errorCode + ", getMessage()=" + getMessage() + "]";
	}
	
	
	
}
