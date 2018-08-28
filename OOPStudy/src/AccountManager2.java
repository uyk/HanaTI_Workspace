import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;

/**
 * 배열을 이용한 은행 계좌 관리
 * 
 * @author 유예겸
 *
 */
public class AccountManager2 {

// 인스턴스변수
	/**
	 * accounts : 클래스 Accounts의 배열. 고객들의 계좌 정보를 저장
	 */
	private Vector accounts;

// 생성자
	public AccountManager2() {
		this(10);
	}

	public AccountManager2(int size) {
		accounts = new Vector(size, 5);
	}

// Getter,Setter (count의 setter는 만들지 않음)	
	public Vector getAccounts() {
		return accounts;
	}

	// 인스턴스 메소드
	/**
	 * accounts에 계좌정보를 추가하는 메소드.
	 * 
	 * @param account 계좌정보
	 */
	public void add(Accounts account) {
		accounts.addElement(account);
	}

	/**
	 * accounts에서 유효 데이터의 배열을 반환하는 메소드
	 * 
	 * @return tempAccounts 유효 데이터의 배열
	 */
	public List list() {
		if(accounts.size() == 0) return null;
		
//		List tempAccounts = new ArrayList();
//		tempAccounts = accounts.subList(0, accounts.size());

		List tempAccounts = new ArrayList();
		Enumeration e = accounts.elements();
		while (e.hasMoreElements()) {
			Object temp = e.nextElement();
			tempAccounts.add(temp);
		}
		return tempAccounts;
	}
	
	/**
	 * accounts에서 계좌번호가 일치하는 계좌를 찾아 반환하는 메소드
	 *  
	 * @param accountNumber 검색할 계좌번호
	 * @return 찾아낸 계좌의 정보
	 */
	public Accounts searchByNumber(String accountNumber) {
		Enumeration e = accounts.elements();
		while (e.hasMoreElements()) {
			Accounts account = (Accounts)(e.nextElement());
			if( ( account.getAccountNum() ).equals(accountNumber))
				return account;
		}
		return null;

	}

	/**
	 * accounts에서 계좌 주인이 일치하는 계좌를 찾아 List로 반환하는 메소드
	 * 
	 * @param accountOwner	검색할 계좌 주인의 이름
	 * @return 찾아낸 계좌의 List
	 */
	public List serachByOwner(String accountOwner) {
		ArrayList tempList = new ArrayList();

		Enumeration e = accounts.elements();
		while (e.hasMoreElements()) {
			Accounts account = (Accounts)(e.nextElement());
			if(( account.getAccountOwner() ).equals(accountOwner))
				tempList.add(account);
		}
		return tempList;
	}

	/**
	 * accounts 배열에서 계좌 번호로 검색하여 일치하는 계좌의 정보를 제거
	 * 
	 * @param accountNumber 제거할 계좌의 계좌번호
	 * @return 제거에 성공하면 true, 제거할 계좌가 없으면 flase
	 */
	public boolean remove(String accountNumber) {
		Enumeration e = accounts.elements();
		while (e.hasMoreElements()) {
			Accounts account = (Accounts)(e.nextElement());
			if(( account.getAccountNum() ).equals(accountNumber))
				return accounts.removeElement(account);
		}
		return false;

	}

	/**
	 * 클래스의 내용을 문자열로 반환하는 메소드
	 * 
	 */
	@Override
	public String toString() {
		return "AccountManager [accounts=" + accounts.toString();
	}

}
