import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 * 배열을 이용한 은행 계좌 관리
 * 
 * @author 유예겸
 *
 */
public class AccountManager3 {

// 인스턴스변수
	/**
	 * accounts : 클래스 Accounts의 배열. 고객들의 계좌 정보를 저장
	 */
	private Hashtable<String, Accounts> accounts;

// 생성자
	public AccountManager3() {
		accounts = new Hashtable<String, Accounts>();
	}


// Getter,Setter (setter는 만들지 않음)	
	public Hashtable<String, Accounts> getAccounts() {
		return accounts;
	}

// 인스턴스 메소드
	/**
	 * accounts에 계좌정보를 추가하는 메소드.
	 * 
	 * @param account 계좌정보
	 */
	public void add(Accounts account) throws AccountException {
		if(accounts.containsKey(account.getAccountNum())) {
			throw new AccountException("이미 등록되어있는 계좌번호입니다", -200);
			
		}
		accounts.put(account.getAccountNum(), account);
	}

	/**
	 * accounts에서 유효 데이터의 map을  list로 반환하는 메소드
	 * 
	 * @return tempAccounts 유효 데이터의 배열
	 */
	public List<Accounts> list() {
		if(accounts.size() == 0) return null;
		
//		List tempAccounts = new ArrayList();
//		tempAccounts = accounts.subList(0, accounts.size());

		// 반환할 리스트 tempAccounts를 ArrayList로 생성
		List<Accounts> list = new ArrayList<Accounts>();
		
		Enumeration<Accounts> e = accounts.elements();
		while (e.hasMoreElements()) {
			Accounts account = e.nextElement();
			list.add(account);
		}
		// 계좌번호로 정렬해서 전달
		Collections.sort(list, new NumberCompare());
		return list;
	}
	
	/**
	 * accounts에서 계좌번호가 일치하는 계좌를 찾아 반환하는 메소드
	 *  
	 * @param accountNumber 검색할 계좌번호
	 * @return 찾아낸 계좌의 정보
	 */
	public Accounts searchByNumber(String accountNumber) {
		return accounts.get(accountNumber);
	}

	/**
	 * accounts에서 계좌 주인이 일치하는 계좌를 찾아 List로 반환하는 메소드
	 * 
	 * @param accountOwner	검색할 계좌 주인의 이름
	 * @return 찾아낸 계좌의 List
	 */
	public List<Accounts> serachByOwner(String accountOwner) {
		List<Accounts> list = new ArrayList<Accounts>();
		Enumeration<Accounts> e = accounts.elements();
		
		while (e.hasMoreElements()) {
			Accounts account = (Accounts)(e.nextElement());
			if(( account.getAccountOwner() ).equals(accountOwner))
				list.add(account);
		}
		return list;
	}

	/**
	 * accounts에서 계좌 번호로 검색하여 일치하는 계좌의 정보를 제거
	 * 
	 * @param accountNumber 제거할 계좌의 계좌번호
	 * @return 제거에 성공하면 true, 제거할 계좌가 없으면 false
	 */
	public boolean remove(String accountNumber) {
		if(accounts.remove(accountNumber) != null) return true;
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
