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
import ko.or.kosta.entity.MinusAccount;

/**
 * 계좌 관리 프로그램
 * 
 * MainFrame : 메인화면을 출력하는 클래스 부모클래스 : Frame
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
	 * 디폴트 생성자. inputPanel초기화, frame에 대한 기본적인 설정
	 */
	public MainFrame() {
		inputPanel = new InputPanel(this);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
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
	}

	/**
	 * 프레임을 윈도우 중앙에 배치하는 메소드
	 */
	public void setCenter() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(dim);

		int x = (dim.width - this.getSize().width) / 2;
		int y = (dim.height - this.getSize().height) / 2;

		setLocation(x, y);

	}

// 테스트를 위한 메인	
	public static void main(String[] args) {
		AccountManager accountManager = new AccountManager();

		try {
			accountManager.add(new Account("1111-2222-3333", "유예겸", 1234, 1000000));
			accountManager.add(new Account("1342-2222-3333", "ㅁㅁㅁ", 1234, 1000000));
			accountManager.add(new Account("9999-2222-3333", "ㄷㄷㄷ", 1234, 1000000));
			accountManager.add(new Account("1351-2222-3333", "ㄷㄷㄷ", 1234, 1000000));
			accountManager.add(new Account("2661-2222-3333", "ㅅㅅㅅ", 1234, 1000000));
			accountManager.add(new MinusAccount("1111-0000-0000", "ㅅㅅㅅ", 1234, 1000000, 1000));
		} catch (AccountException e) {
			System.out.println(e.getMessage());
		}

		System.out.println(accountManager);
		MainFrame frame = new MainFrame();
		frame.setAccountManager(accountManager);
		frame.setContents();
		frame.setSize(800, 450);
		frame.setVisible(true);
		frame.setCenter();
	}
}
