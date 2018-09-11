package kr.or.kosta.dva.client.boundary;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import kr.or.kosta.dva.client.entity.DvaClient;

/**
 * 카드레이아웃으로 패널을 패치하는 cardPanel을 가진 메인 프레임.
 * 
 * @author 유예겸
 *
 */
public class MainFrame extends Frame{
	// 패널 이름 상수
	static final String LOGIN = "LOGIN";	// 로그인 화면
	static final String WAIT = "WAIT";		// 대기실 화면
	static final String ROOM = "ROOM";		// 채팅방 화면
	
	LoginPanel loginPanel;
	WaitingPanel waitingPanel;
	RoomPanel roomPanel;
	
	Panel cardPanel;
	CardLayout cardLayout;
	
	DvaClient client;
	
	// 생성자
	/** 디폴트 생성자 */
	public MainFrame() {
		this("::: DVA CHAT APP :::");
	}
	
	/**
	 * 프레임 타이틀을 인자로 받는 생성자.
	 * 인스턴스 초기화
	 * @param title
	 */
	public MainFrame(String title) {
		super(title);
		loginPanel = new LoginPanel(this);
		waitingPanel = new WaitingPanel(this);
		roomPanel = new RoomPanel(this);
		
		client = new DvaClient();
		
		cardPanel = new Panel();		
		cardLayout = new CardLayout();
		
	}
	
	// 인스턴스 메소드
	/** 카드패널에 패널들을 추가하고 카드패널을 프레임에 추가*/
	public void setContents() {
		cardPanel.setLayout(cardLayout);
		cardPanel.add(LOGIN, loginPanel);
		cardPanel.add(WAIT, waitingPanel);
		cardPanel.add(ROOM, roomPanel);
		
		add(cardPanel, BorderLayout.CENTER);

	}
	
	/** 화면을 중앙에 배치하는 메소드*/
	public void setCenter() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		
		int x = (dim.width - getSize().width)/2;
		int y = (dim.height - getSize().height)/2;
		setLocation(x, y);
	}
	
	/**
	 * 인자로 받은 이름의 패널을 cardPanel에 보여주는 메소드
	 * @param name 보여줄 패널의 이름
	 */
	public void changeCard(String name) {
		// 화면 크기 조정
		// 로그인 화면은 크기 조절 불가
		if(name.equals(LOGIN)) {
			setSize(300,500);
			setResizable(false);
		}
		else {
			setSize(800,500);
			setResizable(true);
		}
		setCenter();
		cardLayout.show(cardPanel, name);
	}
	
	/** 프로그램 종료 메소드 */
	public void finish() {
		//disconnect();
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
	/** 프레임에 이벤트를 등록하는 메소드*/
	public void eventRegist() {
		// 종료 이벤트
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
	}
	
	// 기타 메소드(나중에 위치 옮기는 것 고려)
	public void sendPrivate(String from, String to) {
		
	}
	
}