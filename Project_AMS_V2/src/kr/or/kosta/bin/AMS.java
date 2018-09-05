package kr.or.kosta.bin;

import java.io.File;
import java.io.IOException;

import kr.or.kosta.boundary.MainFrame;
import kr.or.kosta.entity.Account;
import kr.or.kosta.entity.AccountDao;
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
		AccountDao accountDao ;
		// 테스트를 위해 파일 초기화
		File tempFile = new File("accounts.dbf");
		tempFile.delete();


		/*
		try {
			// 임시 계좌 추가
			accountManager.add(new Account("1111-2222-3333", "유예겸", 1234, 1000000));
			accountManager.add(new Account("1342-2222-3333", "가나다라", 1234, 1000000));
			accountManager.add(new Account("9999-2222-3333", "사람", 1234, 10000));
			accountManager.add(new MinusAccount("1111-0000-0000", "유예겸", 1234, 1000000, 1000));
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}
		*/
		
		try {

			MainFrame frame = new MainFrame("AMS - Main");
			accountDao = new AccountDao();
			accountDao.create(new Account("1111-2222-3333", "유예겸", 1234, 1000000));
			accountDao.create(new Account("1342-2222-3333", "가나다라", 1234, 1000000));
			accountDao.create(new Account("9999-2222-3333", "사람", 1234, 10000));
			accountDao.create(new MinusAccount("1111-0000-0000", "유예겸", 1234, 1000000, 1000));

			frame.setAccountManager(accountManager);
			frame.setAccountDao(accountDao);

			frame.setContents();
			frame.setSize(700, 450);
			frame.setResizable(false);
			frame.setVisible(true);
			frame.setCenter();
			
			// 테스트용 출력
			/*
			System.out.println(accountDao.getRecordCount());
			
			List<Account> list = accountDao.listAll();
			for (Account account : list) {
				System.out.println(account);
			}
			*/
			
			accountDao.close();
			
		} catch(IOException e) {
			System.out.println(e);
		}
		
	}

}
