/**
 * Account를 확장한 마이너스 계좌
 * 
 * @author 유예겸
 *
 */
public class MinusAccount extends Accounts {
	// 인스턴스 변수
	private long borrowMoney;


	//생성자
	public MinusAccount() {
		this(null, null, 0, 0, 0);
	}
	public MinusAccount(String accountNum, String accountOwner, int passwd, long restMoney, long borrowMoney) {
		super(accountNum, accountOwner, passwd, restMoney);
		this.borrowMoney = borrowMoney;
	}
	/**
	 * @return the borrowMoney
	 */
	public long getBorrowMoney() {
		return borrowMoney;
	}
	/**
	 * @param borrowMoney the borrowMoney to set
	 */
	public void setBorrowMoney(long borrowMoney) {
		this.borrowMoney = borrowMoney;
	}
	
	@Override
	public long getRestMoney() {
		// TODO Auto-generated method stub
		super.setRestMoney(super.getRestMoney() - getBorrowMoney());
		return super.getRestMoney();
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t" + getBorrowMoney();
	}
	
	public static void main(String[] args) {
		MinusAccount minusAccount = new MinusAccount();
		System.out.println(minusAccount.getBorrowMoney());
		
		MinusAccount minusAccount2 = new MinusAccount("9999-1111-2222", "유예겸", 1234, 0, 1000000);
		//minusAccount2.deposit(10000);
		System.out.println(minusAccount2.getRestMoney());
		System.out.println(minusAccount2);

	}
	
}
