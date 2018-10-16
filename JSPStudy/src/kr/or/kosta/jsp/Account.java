package kr.or.kosta.jsp;

/**
 * JavaBean
 * @author 유예겸
 *
 */
public class Account {

	public static String bankName = "하나은행";

	// 인스턴스 변수 선언
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;

	// 생성자
	public Account() {
		this(null,null,0,0);
	}
	public Account(String accountNum, String accountOwner) {
		//this.accountNum = accountNum;
		//this.accountOwner = accountOwner;
		this(accountNum, accountOwner, 0, 0);
	}
	public Account(String accountNum, String accountOwner, int passwd, long restMoney) {
		this.accountNum = accountNum;
		this.accountOwner = accountOwner;
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
	
	public String toString() {
		return accountNum + "\t" + accountOwner + "\t" + " ****" + "\t" + restMoney;
	}
	//클래스 메소드
	public static int sum(int a, int b) {
		return a + b;
	}
	
	@Override
	public boolean equals(Object obj) {
		// 위임형 비교
		boolean eq = false;
		if(obj instanceof Account)  
			eq = obj.toString().equals(this.toString());
		return eq;
	}
	
}
