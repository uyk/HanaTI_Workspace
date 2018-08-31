package ko.or.kosta.entity;

import java.util.Comparator;

/**
 * 계좌 관리 프로그램.
 * 
 * NumberCompare : 계좌정보를 계좌번호를 기준으로 비교하는 클래스
 * 인터페이스 : Comparator
 * 
 * @author 유예겸
 *
 */
public class NumberCompare implements Comparator<Account> {

	/**
	 * 두 계좌 정보를 인자로 받아 정보를 비교하는 메소드
	 * 
	 * @return 앞의 정보가 크면1, 같으면 0, 작으면 -1
	 */
	@Override
	public int compare(Account account1, Account account2) {
		// TODO Auto-generated method stub
		return account1.getAccountNum().compareTo(account2.getAccountNum());
	}

}
