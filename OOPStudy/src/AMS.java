/**
 * 은행 계좌 관리 애플리케이션
 * 
 * @author 유예겸
 *
 */
public class AMS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// AccountManager 클래스의 인스턴스 생성
		AccountManager am = new AccountManager(100);		// 최대 크기 100
		
		
		// AccountManager의 add 메소드로 다섯개의 계좌 정보 추가
		am.add(new Accounts("1111-2222-3333", "유예겸", 1234, 1000000));
		am.add(new Accounts("1342-2222-3333", "ㅁㅁㅁ", 1234, 1000000));
		am.add(new Accounts("9999-2222-3`333", "ㄷㄷㄷ", 1234, 1000000));
		am.add(new Accounts("1351-2222-3333", "ㄷㄷㄷ", 1234, 1000000));
		am.add(new Accounts("2661-2222-3333", "ㅅㅅㅅ", 1234, 1000000));
		
		// Up Casting
		am.add(new MinusAccount("1234-5678-1234", "김김김", 1234, 568798, 9999999));
		am.add(new MinusAccount("5645-3618-5134", "이이이", 1234, 568798, 9999999));
		
		// AccountManager의 list메소드로 존재하는 계좌 정보만 list 배열에 복사
		Accounts[] list = am.list();
		
		// list 배열의 각 Account 인스턴스 출력
		if(list != null) {
			System.out.println("\n************* list 출력 *************");
			for (Accounts accounts : list) {
				if(accounts instanceof MinusAccount)
					System.out.println("마이너스 계좌\t" + accounts.toString());
				else System.out.println("입출금 계좌\t" + accounts.toString());
			}
		}
		
		// AccountManager의 seachByNumber 메소드로 계좌 정보 탐색 및 출력
		System.out.println("\n************* 계좌번호로 탐색 *************");
		System.out.println(am.searchByNumber("1351-2222-3333"));
		System.out.println(am.searchByNumber("0000-2222-3333"));		//없음
		
		
		// AccountManager의 seachByOwner 메소드로 계좌 정보 탐색 및 출력
		System.out.println("\n************* ㄷㄷㄷ 탐색 *************");
		Accounts[] accountsOfowner = am.serachByOwner("ㄷㄷㄷ");
		for (Accounts accounts : accountsOfowner) {
			System.out.println(accounts.toString());
		}

		// AccountManager의 remove 메소드로 계좌 정보 제거
		System.out.println("\n********* 1111-2222-3333 제거 *********");
		am.remove("1111-2222-3333");
		list = am.list();
		for (Accounts accounts : list) {
			System.out.println(accounts.toString());
		}
		
	}

}
