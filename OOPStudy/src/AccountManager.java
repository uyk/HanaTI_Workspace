import java.util.Arrays;

/**
 * 배열을 이용한 은행 계좌 관리
 * 
 * @author 유예겸
 *
 */
public class AccountManager {

// 인스턴스변수
	/**
	 * accounts : 클래스 Accounts의 배열. 고객들의 계좌 정보를 저장 count : int 변수. 계좌의 수를 저장.
	 */
	private Accounts[] accounts;
	private int count;

// 생성자
	/**
	 * 매개변수가 없는 생성자. 다른 생성자를 호출해 count를 0으로 초기화한다. 
	 * 10개 크기의 배열을 accounts에 할당.
	 */
	public AccountManager() {
		this(10);
	}

	/**
	 * 매개변수로 size를 받아 size의 크기만큼 Accounts 배열을 생성한다. 
	 * 생성한 인스턴스 배열을 accounts 변수에 할당하고 count를 0으로 초기화한다.
	 * 
	 * @param size : 인스턴스 변수 accounts의 크기
	 */
	public AccountManager(int size) {
		accounts = new Accounts[size];
		count = 0;
	}

// Getter,Setter (count의 setter는 만들지 않음)

	/**
	 * 인스턴스 변수 accounts의 setter Accounts의 배열 accounts를 인수로 받아 
	 * 인스턴스 변수 accounts의 값을 바꾼다.
	 * 
	 * @param accounts : 인스턴스 변수 accounts에 저장됨
	 */
	public void setAccounts(Accounts[] accounts) {
		this.accounts = accounts;
	}

	/**
	 * 인스턴스 변수 accounts를 반환한다.
	 * @return	accounts
	 */
	public Accounts[] getAccounts() {
		return accounts;
	}

	/**
	 * 인스턴스 변수 count의 값을 반환한다.
	 * @return count
	 */
	public int getCount() {
		return count;
	}

// 인스턴스 메소드
	/**
	 * accounts에 계좌정보를 추가하는 메소드.
	 * count를 1 증가.
	 * 
	 * @param account 계좌정보
	 */
	public void add(Accounts account) {
		accounts[count++] = account;
	}

	/**
	 * accounts 배열에서 유효 데이터의 배열을 반환하는 메소드
	 * 
	 * @return tempAccounts 유효 데이터의 배열
	 */
	public Accounts[] list() {
		if (count == 0)
			return null;
		Accounts[] tempAccounts = new Accounts[count];
		for (int i = 0; i < count; i++)
			tempAccounts[i] = accounts[i];
		return tempAccounts;
	}

	/**
	 * accounts 배열에서 계좌번호가 일치하는 계좌를 찾아 반환하는 메소드
	 *  
	 * @param accountNumber 검색할 계좌번호
	 * @return 찾아낸 계좌의 정보
	 */
	public Accounts searchByNumber(String accountNumber) {
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountNum().equals(accountNumber))
				return accounts[i];
		}
		return null;
	}

	/**
	 * accounts 배열에서 계좌 주인이 일치하는 계좌를 찾아 배열로 반환하는 메소드
	 * 
	 * @param accountOwner	검색할 계좌 주인의 이름
	 * @return 찾아낸 계좌의 배열
	 */
	public Accounts[] serachByOwner(String accountOwner) {
		int numOfAccounts = 0;
		int[] indexOfAccounts = new int[count];

		for (int i = 0; i < count; i++)
			if (accounts[i].getAccountOwner().equals(accountOwner))
				indexOfAccounts[numOfAccounts++] = i;

		if (numOfAccounts == 0)
			return null; // 일치하는 결과 없음

		Accounts[] tempAccounts = new Accounts[numOfAccounts];

		for (int i = 0; i < numOfAccounts; i++) {
			tempAccounts[i] = accounts[indexOfAccounts[i]];
		}

		return tempAccounts;
	}

	/**
	 * accounts 배열에서 계좌 번호로 검색하여 일치하는 계좌의 정보를 제거
	 * 
	 * @param accountNumber 제거할 계좌의 계좌번호
	 * @return 제거에 성공하면 true, 제거할 계좌가 없으면 flase
	 */
	public boolean remove(String accountNumber) {
		int pos = -1;
		for (int i = 0; i < count; i++) {
			if (accounts[i].getAccountNum().equals(accountNumber)) {
				pos = i;
				break;
			}
		}
		if (pos == -1)
			return false;	// 일치하는 계좌 정보 없음

		if (count == 1)		// 하나의 계좌만 있을 때 
			accounts[0] = null;
		else {
			for (int i = pos; i < count - 1; i++) {
				accounts[i] = accounts[i + 1];		//뒤 인덱스의 정보를 앞으로 이동
			}
			accounts[count] = null;		// 마지막엔 중복값이 남으므로 제거
		}
		count--;			// 계좌 갯수를 세는 변수인 count의 값을 하나 감소
		return true;

	}

	/**
	 * 클래스의 내용을 문자열로 반환하는 메소드
	 * 
	 */
	@Override
	public String toString() {
		return "AccountManager [accounts=" + Arrays.toString(accounts) + ", count=" + count + "]";
	}

}
