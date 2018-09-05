package kr.or.kosta.entity;
/**
 * 계좌 관리 프로그램
 * 
 * AccountException : 계좌처리 중 예외발생 시 생성되는 클래스
 * 부모클래스 : Exception
 * 
 * @author 유예겸
 *
 */

public class AccountException extends Exception {
	public static final int EMPTY_NUM  = 	1;
	public static final int INVALID_NUM = 	2;
	public static final int EXIST_NUM =		3;
	public static final int ONLY_CHAR = 	4;
	public static final int ONLY_DIGIT = 	5;
	public static final int NO_FULLFILL = 	6;
	public static final int CANT_DELETE = 	7;
	public static final int EMPTY_NAME = 	8;
	public static final int NO_SUCH_NAME = 	9;
	public static final int NO_SUCH_NUM = 	10;
	
	private int errorCode;
	private String discription;


// 생성자
	public AccountException() {
		this("계좌처리중 예기치 않은 에러가 발생하였습니다.", 0);
	}
	
	public AccountException(int errorCode) {
		switch(errorCode) {
		case EMPTY_NUM :
			discription = "계좌번호를 입력하세요.";
			break;
		case INVALID_NUM :
			discription = "계좌번호는 12자리 숫자만 가능합니다.";
			break;
		case EXIST_NUM :
			discription = "존재하는 계좌번호 입니다.";
			break;
		case ONLY_CHAR :
			discription = "문자를 입력하세요.";
			break;
		case ONLY_DIGIT :
			discription = "숫자를 입력하세요.";
			break;
		case NO_FULLFILL :
			discription = "빈칸을 채워주세요.";
			break;
		case CANT_DELETE :
			discription = "지우지 못했습니다.";
			break;
		case EMPTY_NAME :
			discription = "예금주를 입력하세요.";
			break;
		case NO_SUCH_NAME :
			discription = "찾을 수 없습니다.";
			break;
		case NO_SUCH_NUM :
			discription = "해당 계좌번호의 계좌를 찾을 수 없습니다.";
			break;
		}
	}
	
	public AccountException(String discription, int errorCode) {
		this.discription = discription;
		this.errorCode = errorCode;
	}

	
// getter 메소드
	public int getErrorCode() {
		return errorCode;
	}

	
	public String getDiscription() {
		return discription;
	}


// 에러 출력 메소드
	@Override
	public String toString() {
		return "AccountException [errorCode=" + errorCode + ", discription=" + discription+"]";
	}

}
