

/**
 * 계좌 관리 프로그램
 * 
 * Account : 계좌정보를 저장하는 클래스
 * 
 * @author 유예겸
 *
 */
public class Account {

//변수 선언부
	// 클래스(static)변수
	public static String bankName = "KOSTA 은행";

	// 인스턴스 변수 선언
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;

// 생성자
	/**
	 * 디폴트 생성자. 계좌번호 null, 계좌주인 null, 패스워드 0, 잔액 0 으로 초기화한다.
	 */
	public Account() {
		this(null, null, 0, 0);
	}

	/**
	 * 계좌번호, 계좌주인, 패스워드, 잔액을 인자로 받아 초기화하는 생성자
	 * 
	 * @param accountNum   계좌번호
	 * @param accountOwner 계좌주인
	 * @param passwd       비밀번호
	 * @param restMoney    잔액
	 */
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
	/**
	 * 계좌에서 money만큼을 출금하는 메소드. 출금할 금액이 음수면 예외 발생.
	 * 
	 * @param money 출금금액
	 * @return restMoney 잔액. 예외발생 안했을 경우에만 리턴
	 * @throws AccountException 예외
	 */
	long deposit(long money) throws AccountException {
		if (money <= 0) {
			throw new AccountException("출금 금액은 음수일 수 없습니다.", -1);
		}
		restMoney += money;
		return restMoney;
	}

	/**
	 * 계좌에 money만큼을 입금하는 메소드. 입금할 금액이 음수이거나 잔액이 부족할 경우 예외 발생.
	 * 
	 * @param money 입금금액
	 * @return restMoney 잔액. 예외발생 안했을 경우에만 리턴
	 * @throws AccountException 예외. 입금 금액이 음수 또는 잔액 부족
	 */
	long withdraw(long money) throws AccountException {
		if (money <= 0) {
			throw new AccountException("입금 금액은 음수일 수 없습니다.", -2);
		}
		if (money > restMoney) {
			throw new AccountException("잔액이 부족합니다.", -3);
		}
		restMoney -= money; // 정상적인 데이터가 들어왔다고 가정
		return restMoney;
	}

	/**
	 * 패스워드를 인자로 받아 일치하는지 검사하는 메소드.
	 * 
	 * @param pw 패스워드
	 * @return 일치할 경우 true, 불일치할 경우 false
	 */
	boolean checkPasswd(int pw) {
		return passwd == pw;
	}

// 오버라이딩 메소드
	/**
	 * 계좌정보를 문자열로 반환하는 메소드.
	 */
	@Override
	public String toString() {
		return accountNum + "\t" + accountOwner + "\t" + " ****" + "\t" + restMoney;
	}

	/**
	 * 계좌정보의 문자열의 해시코드를 반환하는 메소드.
	 */
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub

		return toString().hashCode();
	}

	/**
	 * 계좌정보가 일치하는지 비교하는 메소드.
	 */
	@Override
	public boolean equals(Object obj) {
		// 위임형 비교
		boolean eq = false;
		if (obj instanceof Account)
			eq = obj.toString().equals(this.toString());
		return eq;
	}

// 테스트를 위한 메인 메소드
	public static void main(String[] args) {
		Account account1 = new Account();
		System.out.println(account1);

		Account account2 = new Account("1111-2222-3333", "홍길동", 1234, 10000);
		System.out.println(account2);

		Account account3 = new Account("1111-9999-3333", "ㅇㄴㄹ", 1234, 10000);
		System.out.println(account3);

		Account account4 = new Account("3333-2222-3333", "ㄴㅇㄹ", 1234, 10000);
		System.out.println(account4);

		System.out.println(account4.checkPasswd(1111));

		try {
			System.out.println(account4.deposit(1000000));
			System.out.println(account4.withdraw(500));
			System.out.println(account4.withdraw(9999999));
		} catch (AccountException e) {
			System.out.println(e);
		}
	}
}
