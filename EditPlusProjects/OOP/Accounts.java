/**
 * 일상생활의 객체를 추상화하기 위한 모델링 클래스 정의
 * 은행 계좌 객체
 */


public class Accounts {

	static int a,b,c;
	
	// static 초기화 블록 : 특수한 목적의 명령어 실행(주로 초기화)
	static {
		System.out.println("초기화 블럭 실행입니다.");
		a = 10;
		b = 20;
		c = 30;
	}



	// 클래스(static)변수
	public static String bankName = "하나은행";

	// 인스턴스 변수 선언
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;

	// 생성자
	public Accounts() {
		this(null,null,0,0);
	}
	public Accounts(String accountNum, String accountOwner) {
		//this.accountNum = accountNum;
		//this.accountOwner = accountOwner;
		this(accountNum, accountOwner, 0, 0);
	}
	public Accounts(String accountNum, String accountOwner, int passwd, long restMoney) {
		this.passwd = passwd;
		this.restMoney = restMoney;
	}

	// setter, getter 메소드
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getAccountNum() {
		return this.accountNum;
	}
	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}
	public String getAccountOwner() {
		return this.accountOwner;
	}
	public void setPasswd(int passwd) {
		this.passwd = passwd;
	}
	public int getPasswd() {
		return this.passwd;
	}
	public void setRestMoney(long restMoney) {
		this.restMoney = restMoney;
	}
	public long getRestMoney() {
		return this.restMoney;
	}

	// 인스턴스 메소드 선언
	long deposit(long money) {
		restMoney += money;
		return restMoney;
	}
	long withdraw(long money) {
		restMoney -= money;		// 정상적인 데이터가 들어왔다고 가정
		return restMoney;
	}
	boolean checkPasswd(int pw) {
		return passwd == pw;
	}

	//클래스 메소드
	public static int sum(int a, int b) {
		return a + b;
	}
}
