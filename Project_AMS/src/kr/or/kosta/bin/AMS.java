package kr.or.kosta.bin;

import ko.or.kosta.entity.Account;
import ko.or.kosta.entity.AccountException;
import ko.or.kosta.entity.AccountManager;
import ko.or.kosta.entity.MinusAccount;
import kr.or.kosta.boundary.MainFrame;

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

		AccountManager accountManager = new AccountManager();

		try {
			accountManager.add(new Account("1111-2222-3333", "유예겸", 1234, 1000000));
			accountManager.add(new Account("1342-2222-3333", "가나다라", 1234, 1000000));
			accountManager.add(new Account("9999-2222-3333", "사람", 1234, 1000000));
			accountManager.add(new MinusAccount("1111-0000-0000", "ㅅㅅㅅ", 1234, 1000000, 1000));
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(accountManager);
		MainFrame frame = new MainFrame();
		frame.setAccountManager(accountManager);
		frame.setContents();
		frame.setSize(800, 450);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setCenter();
		
	}

}
