package kr.or.kosta.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 * 계좌 관리 프로그램.
 * 
 * AccountManager : 전체 계좌를 관리하는 클래스. 계좌번호를 key, 계좌 정보를 value로 가지는 MAP 형태로 데이터를 관리한다.
 * 
 * 
 * @author 유예겸
 *
 */

public class AccountManager {
// 인스턴스변수
	/**
	 * accounts : 클래스 Accounts의 배열. 고객들의 계좌 정보를 저장
	 */
	private Hashtable<String, Account> accounts;

// 생성자
	public AccountManager() {
		accounts = new Hashtable<String, Account>();
	}

// Getter,Setter (setter는 만들지 않음)	
	public Hashtable<String, Account> getAccounts() {
		return accounts;
	}

// 인스턴스 메소드
	/**
	 * accounts에 계좌정보를 추가하는 메소드.
	 * 
	 * @param account 계좌정보
	 */
	public void add(Account account) throws AccountException {
		if (accounts.containsKey(account.getAccountNum())) {
			throw new AccountException(AccountException.EXIST_NUM);
		}
		accounts.put(account.getAccountNum(), account);
	}

	/**
	 * accounts에서 유효 데이터의 map을 list로 반환하는 메소드
	 * 
	 * @return tempAccounts 유효 데이터의 배열
	 */
	public List<Account> list() {
		if (accounts.size() == 0)
			return null;

		// 반환할 리스트 tempAccounts를 ArrayList로 생성
		List<Account> list = new ArrayList<Account>();

		Enumeration<Account> e = accounts.elements();
		while (e.hasMoreElements()) {
			Account account = e.nextElement();
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
	public Account searchByNumber(String accountNumber) {
		return accounts.get(accountNumber);
	}

	/**
	 * accounts에서 계좌 주인이 일치하는 계좌를 찾아 List로 반환하는 메소드
	 * 
	 * @param accountOwner 검색할 계좌 주인의 이름
	 * @return 찾아낸 계좌의 List
	 */
	public List<Account> serachByOwner(String accountOwner) {
		List<Account> list = new ArrayList<Account>();
		Enumeration<Account> e = accounts.elements();

		while (e.hasMoreElements()) {
			Account account = (Account) (e.nextElement());
			if ((account.getAccountOwner()).equals(accountOwner))
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
		if (accounts.remove(accountNumber) != null)
			return true;
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
