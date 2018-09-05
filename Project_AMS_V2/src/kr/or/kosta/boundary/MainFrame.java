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

import kr.or.kosta.entity.Account;
import kr.or.kosta.entity.AccountDao;
import kr.or.kosta.entity.AccountException;
import kr.or.kosta.entity.AccountManager;
import kr.or.kosta.entity.MinusAccount;

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
	AccountDao accountDao;

// 생성자
	/**
	 * 디폴트 생성자. inputPanel초기화, frame에 대한 기본적인 설정
	 */
	public MainFrame() {
		this("AMS = Main");
	}
	
	/**
	 * 프레임 타이틀을 인자로 받는 생성자.
	 * inputPanel초기화
	 * @param title
	 */
	public MainFrame(String title) {
		setTitle(title);
		inputPanel = new InputPanel(this);
		// 닫기 활성화
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(1);
			}
		});
	}

// setter, getter
	public void setAccountManager(AccountManager accountManager) {
		this.accountManager = accountManager;
	}
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

// 인스턴스 메소드
	/**
	 * 프레임에 컴포넌트를 배치하는 메소드
	 */
	public void setContents() {
		inputPanel.setAccountDao(accountDao);
		inputPanel.setContents();
		inputPanel.eventRegist();
		
		
		add(inputPanel, BorderLayout.NORTH);

	}

	/**
	 * 프레임을 윈도우 중앙에 배치하는 메소드
	 */
	public void setCenter() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (dim.width - this.getSize().width) / 2;
		int y = (dim.height - this.getSize().height) / 2;

		setLocation(x, y);

	}
}
