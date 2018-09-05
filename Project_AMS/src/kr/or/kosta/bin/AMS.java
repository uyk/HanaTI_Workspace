package kr.or.kosta.bin;

import kr.or.kosta.boundary.MainFrame;
import kr.or.kosta.entity.Account;
import kr.or.kosta.entity.AccountException;
import kr.or.kosta.entity.AccountManager;
import kr.or.kosta.entity.MinusAccount;

/**
 * 계좌 관리 프로그램
 * 
 * AMS : 프로그램 엔티티를 포함하는 애플리케이션 클래스
 * 
 * @author 유예겸
 *
 */

public class AMS {

	public static void main(String[] args) {
		// 계좌 정보를 저장하고 관리하는 AccountManager의 인스턴스 선언 및 생성
		AccountManager accountManager = new AccountManager();

		try {
			// 임시 계좌 추가
			accountManager.add(new Account("1111-2222-3333", "유예겸", 1234, 1000000));
			accountManager.add(new Account("1342-2222-3333", "가나다라", 1234, 1000000));
			accountManager.add(new Account("9999-2222-3333", "사람", 1234, 10000));
			accountManager.add(new MinusAccount("1111-0000-0000", "유예겸", 1234, 1000000, 1000));
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}

		MainFrame frame = new MainFrame("AMS - Main");
		frame.setAccountManager(accountManager);
		frame.setContents();
		frame.setSize(700, 450);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setCenter();
		
	}

}
