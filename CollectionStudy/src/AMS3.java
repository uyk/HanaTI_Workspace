import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * 은행 계좌 관리 애플리케이션
 * 
 * @author 유예겸
 *
 */
public class AMS3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// AccountManager 클래스의 인스턴스 생성
		AccountManager3 am = new AccountManager3();		
		
		
		// AccountManager의 add 메소드로 다섯개의 계좌 정보 추가
		try {
			am.add(new Accounts("1111-2222-3333", "유예겸", 1234, 1000000));
			am.add(new Accounts("1342-2222-3333", "ㅁㅁㅁ", 1234, 1000000));
			am.add(new Accounts("9999-2222-3333", "ㄷㄷㄷ", 1234, 1000000));
			am.add(new Accounts("1351-2222-3333", "ㄷㄷㄷ", 1234, 1000000));
			am.add(new Accounts("2661-2222-3333", "ㅅㅅㅅ", 1234, 1000000));
		} catch (AccountException e){
			System.out.println(e.getMessage());
		}

		// AccountManager의 list메소드로 존재하는 계좌 정보만 list 배열에 복사
		
		List<Accounts> list = am.list();

		System.out.println("\n************* list 출력 *************");
		for (Object object : list) {
			System.out.println(((Accounts)object).toString());
		}
		
		// AccountManager의 seachByNumber 메소드로 계좌 정보 탐색 및 출력
		System.out.println("\n************* 계좌번호로 탐색 *************");
		System.out.println("1351-2222-3333 탐색 : " + am.searchByNumber("1351-2222-3333"));
		System.out.println("0000-2222-3333 탐색 : " + am.searchByNumber("0000-2222-3333"));		//없음
		
		
		// AccountManager의 seachByOwner 메소드로 계좌 정보 탐색 및 출력
		System.out.println("\n************* ㄷㄷㄷ 탐색 *************");
		ArrayList<Accounts> accountsOfowner = (ArrayList<Accounts>)(am.serachByOwner("ㄷㄷㄷ"));
		for (Object object : accountsOfowner) {
			System.out.println(((Accounts)object).toString());
		}

		// AccountManager의 remove 메소드로 계좌 정보 제거
		System.out.println("\n********* 1111-2222-3333 제거 *********");
		am.remove("1111-2222-3333");
		Enumeration<Accounts> e = am.getAccounts().elements();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}

	}

}
