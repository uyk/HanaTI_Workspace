package kr.or.kosta.bin;

import java.io.File;
import java.io.IOException;

import kr.or.kosta.boundary.MainFrame;
import kr.or.kosta.entity.Account;
import kr.or.kosta.entity.AccountDao;
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
		AccountDao accountDao ;
		
		// 테스트를 위해 파일 초기화
		File tempFile = new File("accounts.dbf");
		tempFile.delete();
		
		try {

			MainFrame frame = new MainFrame("AMS - Main");
			accountDao = new AccountDao();
			accountDao.create(new Account("1111-2222-3333", "유예겸", 1234, 1000000));
			accountDao.create(new Account("2222-2222-3333", "가나다라", 1234, 1000000));
			accountDao.create(new Account("3333-2222-3333", "사람", 1234, 10000));
			accountDao.create(new MinusAccount("4444-0000-0000", "유예겸", 1234, 1000000, 1000));

			frame.setAccountDao(accountDao);

			frame.setContents();
			frame.setSize(700, 450);
			frame.setResizable(false);
			frame.setVisible(true);
			frame.setCenter();
			
		} catch(IOException e) {
			System.out.println(e);
		}
		
	}

}
