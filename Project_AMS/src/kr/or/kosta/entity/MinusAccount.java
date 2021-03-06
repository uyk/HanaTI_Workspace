package kr.or.kosta.entity;

/**
 * 계좌 관리 프로그램
 * 
 * MinusAccount : 마이너스 계좌 정보를 저장하는 클래스. 부모클래스 : Account
 * 
 * @author 유예겸
 *
 */

public class MinusAccount extends Account {
// 인스턴스 변수
	private long borrowMoney;

// 생성자
	/**
	 * 디폴트 생성자. 계좌번호 null, 계좌주인 null, 비밀번호 0, 잔액 0, 대출금 0으로 초기화한다.
	 */
	public MinusAccount() {
		this(null, null, 0, 0, 0);
	}

	/**
	 * 계좌번호, 계좌주인, 비밀번호, 잔액, 대출금을 인자로 받아 초기화하는 생성자.
	 * 
	 * @param accountNum   계좌번호
	 * @param accountOwner 계좌주인
	 * @param passwd       비밀번호
	 * @param restMoney    잔액
	 * @param borrowMoney  대출금
	 */
	public MinusAccount(String accountNum, String accountOwner, int passwd, long restMoney, long borrowMoney) {
		super(accountNum, accountOwner, passwd, restMoney);
		this.borrowMoney = borrowMoney;
		super.setRestMoney(super.getRestMoney() - getBorrowMoney());
	}

// getter와 setter
	public long getBorrowMoney() {
		return borrowMoney;
	}

	public void setBorrowMoney(long borrowMoney) {
		this.borrowMoney = borrowMoney;
	}

// 오버라이딩
	/**
	 * 계좌의 내용을 출력하는 메소드
	 */
	@Override
	public String toString() {
		return super.toString() + "\t" + getBorrowMoney();
	}

}
