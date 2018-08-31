package kr.or.kosta.boundary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import ko.or.kosta.entity.Account;
import ko.or.kosta.entity.AccountException;
import ko.or.kosta.entity.AccountManager;

/**
 * 계좌 관리 프로그램
 * 
 * MainFrame : 메인화면을 출력하는 클래스
 * 부모클래스 : Frame
 * 
 * @author 유예겸
 *
 */

public class MainFrame extends Frame {
// 인스턴스 메소드
	InputPanel inputPanel;
	AccountManager accountManager;
	
// 생성자
	/**
	 * 디폴트 생성자.
	 * inputPanel초기화, frame에 대한 기본적인 설정
	 */
	public MainFrame() {
		inputPanel = new InputPanel();
		accountManager = new AccountManager();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//finish();
				setVisible(false);
				dispose();
				System.exit(1);
			}
		});
	}

	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}

	// 인스턴스 메소드
	/** 
	 * 프레임에 컴포넌트를 배치하는 메소드
	 */
	public void setContents() {
		add(inputPanel, BorderLayout.NORTH);
		//add(printPanel, BorderLayout.CENTER);
	}

	/**
	 * 프레임을 윈도우 중앙에 배치하는 메소드
	 */
	public void setCenter() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(dim);
		
		int x = (dim.width - this.getSize().width) / 2;
		int y = (dim.height - this.getSize().height) / 2;
		
		setLocation(x,y);
		
	}
	
// 테스트를 위한 메인	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame frame = new MainFrame();
		AccountManager accountManager = new AccountManager();
		
		try {
			accountManager.add(new Account("1111-2222-3333", "유예겸", 1234, 1000000));
			accountManager.add(new Account("1342-2222-3333", "ㅁㅁㅁ", 1234, 1000000));
			accountManager.add(new Account("9999-2222-3333", "ㄷㄷㄷ", 1234, 1000000));
			accountManager.add(new Account("1351-2222-3333", "ㄷㄷㄷ", 1234, 1000000));
			accountManager.add(new Account("2661-2222-3333", "ㅅㅅㅅ", 1234, 1000000));
		} catch (AccountException e){
			System.out.println(e.getMessage());
		}

		frame.setContents();
		frame.setSize(800,450);
		frame.setVisible(true);
		frame.setCenter();
		
		frame.setAccountManager(accountManager);
		/*
		// AccountManager의 list메소드로 존재하는 계좌 정보만 list 배열에 복사
		
		List<Account> list = frame.accountManager.list();

		System.out.println("\n************* list 출력 *************");
		for (Object object : list) {
			System.out.println(((Account)object).toString());
		}
		
		// AccountManager의 seachByNumber 메소드로 계좌 정보 탐색 및 출력
		System.out.println("\n************* 계좌번호로 탐색 *************");
		System.out.println("1351-2222-3333 탐색 : " + frame.accountManager.searchByNumber("1351-2222-3333"));
		System.out.println("0000-2222-3333 탐색 : " + frame.accountManager.searchByNumber("0000-2222-3333"));		//없음
		
		
		// AccountManager의 seachByOwner 메소드로 계좌 정보 탐색 및 출력
		System.out.println("\n************* ㄷㄷㄷ 탐색 *************");
		ArrayList<Account> accountsOfowner = (ArrayList<Account>)(frame.accountManager.serachByOwner("ㄷㄷㄷ"));
		for (Object object : accountsOfowner) {
			System.out.println(((Account)object).toString());
		}

		// AccountManager의 remove 메소드로 계좌 정보 제거
		System.out.println("\n********* 1111-2222-3333 제거 *********");
		frame.accountManager.remove("1111-2222-3333");
		Enumeration<Account> e = frame.accountManager.getAccounts().elements();
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		*/
	}
}
