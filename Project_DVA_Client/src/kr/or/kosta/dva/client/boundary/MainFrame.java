package kr.or.kosta.dva.client.boundary;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.kosta.dva.client.entity.DvaClient;
import kr.or.kosta.dva.client.entity.DvaRoom;

/**
 * 카드레이아웃으로 패널을 패치하는 cardPanel을 가진 메인 프레임.
 * 
 * @author 유예겸
 *
 */
public class MainFrame extends Frame{
	// 패널 이름 상수
	public static final String LOGIN = "LOGIN";		// 로그인 화면
	public static final String WAIT = "WAIT";		// 대기실 화면
	public static final String ROOM = "ROOM";		// 채팅방 화면
	
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
		
		cardPanel = new Panel();		
		cardLayout = new CardLayout();
		
	}
	
// getter, setter
	/** 클라이언트 get 메소드 */
	public DvaClient getClient() {
		return client;
	}
	
	/**
	 * 클라이언트 set 메소드
	 * @param client
	 */
	public void setClient(DvaClient client) {
		this.client = client;
		connect();
	}
	
// 화면 배치 메소드
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
	public void changeCard(String name, DvaRoom room) {
		// 화면 크기 조정
		// 로그인 화면은 크기 조절 불가
		switch(name) {
		case LOGIN :					// 로그인패널
			setSize(300,500);
			setResizable(false);
			break;
		case ROOM :						// 채팅방 패널
			roomPanel.setRoom(room);
			roomPanel.setRoomUserList();
		case WAIT :						// 대기실&채팅방
			setTitle("::: DVA CHAT APP ::: \t< User : " + client.getNickName() + ">");
			setSize(800,500);
			setResizable(true);
			break;
		}
		// 세 경우 모두
		setCenter();
		cardLayout.show(cardPanel, name);
	}
	
	/** 프로그램 종료 메소드 */
	public void finish() {
		client.stopClient();
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
	
// 통신 메소드
	public void connect() {
		try {
			client.connectServer();
			client.recieveMessage();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "연결 실패", JOptionPane.ERROR_MESSAGE);
		}
	}
	// roomList() 
	public void WaitPanelRoomList(List<DvaRoom> rooms) {
		waitingPanel.setRoomList(rooms);
	}
	public void WaitPanelWaitUsers(List<String> users) {
		waitingPanel.setWaitUsers(users);
	}
	public void WaitPanelRoomUsers(List<String> users) {
		waitingPanel.setRoomUsers(users);
	}
	
}
