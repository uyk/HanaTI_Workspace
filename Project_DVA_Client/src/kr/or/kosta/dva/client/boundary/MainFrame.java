package kr.or.kosta.dva.client.boundary;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;

import kr.or.kosta.dva.client.entity.DvaClient;
import kr.or.kosta.dva.client.entity.DvaRoom;
import kr.or.kosta.dva.client.entity.Protocol;

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
		if(client != null) 		connect();
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
		case LOGIN :					// 로그인창으로 이동
			loginPanel.nickNameTF.setText("");
			setSize(300,500);
			setResizable(false);
			break;
		case ROOM :						// 채팅방으로 이동
			client.setLocation(room.getRoomName());
			roomPanel.setRoom(room);
			roomPanel.setRoomUserList();
			setTitle("::: DVA CHAT APP ::: \t< User : " + client.getNickName() + ">");
			setSize(800,500);
			setResizable(true);
			break;
		case WAIT :						// 대기실로 이동
			client.setLocation(Protocol.ANTEROOM);
			waitingPanel.resetPanel();
			setTitle("::: DVA CHAT APP ::: \t< User : " + client.getNickName() + ">");
			setSize(800,500);
			setResizable(true);
			break;
		}
		// 세 경우 모두
		setCenter();
		cardLayout.show(cardPanel, name);
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

	/** 프로그램 종료 메소드 */
	public void finish() {
		if(client != null) { 
			logoutEvent();
		}
		setVisible(false);
		dispose();
		System.exit(0);
	}
	
// 통신 메소드
	/**
	 * client의 서버와 연결하는 메소드 호출
	 */
	public void connect() {
		try {
			client.connectServer();
			client.recieveMessage();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "연결 실패", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/** 로그아웃 메소드 */
	public void logoutEvent() {
		String CSMessage = Protocol.CS_LOGOUT + Protocol.DELEMETER + 
				client.currentTime() + Protocol.DELEMETER + 
				client.getNickName();
		client.sendMessage(CSMessage);
		client.stopClient();
		waitingPanel.resetPanel();
		setClient(null);
		changeCard(MainFrame.LOGIN, null);
	}
	
	/** 로그인 메소드 */
	public void loginEvent(String nickName) {
		setClient(new DvaClient(this));
		String clientMessage = Protocol.CS_LOGIN + Protocol.DELEMETER
				+ client.currentTime() + Protocol.DELEMETER +
				nickName;
//		client.testSendMessage(clientMessage);
		client.sendMessage(clientMessage);
	}
	

// 대기실 패널의 컴포넌트를 조작하는 메소드
	public void WaitPanelRoomList(List<DvaRoom> rooms) {
		waitingPanel.setRoomList(rooms);
	}
	public void WaitPanelWaitUsers(List<String> users) {
		waitingPanel.setWaitUsers(users);
	}
	public void WaitPanelRoomUsers(List<String> users) {
		waitingPanel.setRoomUsers(users);
	}
	public void WaitPanelTryEnterSelectRoom() {
		waitingPanel.tryEnterSelectRoom();
	}
	/*
	public void WaitPanelEnterSelectRoom() {
		waitingPanel.enterSelectRoom();
	}
	public void WaitPanelEnterNewRoom(DvaRoom room) {
		waitingPanel.enterNewRoom(room);
	}*/
	public void WaitPanelEnterRoom(String roomName) {
		waitingPanel.enterRoom(roomName);
	}
	public void WaitPanelNewWaitUser(String user) {
		waitingPanel.newWaitUser(user);
	}
	public void WaitPanelOutWaitUser(String user) {
		waitingPanel.outWaitUser(user);
	}
	
// 채팅방 패널의 컴포넌트를 조작하는 메소드
	public void RoomPanelRoomUsers(List<String> users) {
		roomPanel.setRoomUsers(users);
	}
	public void RoomPanelNewWaitUser(String user) {
		roomPanel.newRoomUser(user);
	}
	public void RoomPanelOutWaitUser(String user) {
		roomPanel.outRoomUser(user);
	}
//	public void RoomPanelOutRoom() {		//바텀패널에서 바로 호출
//		roomPanel.outRoom();
//	}
	public void RoomPanelNewChat(String chat) {
		roomPanel.newChat(chat);
	}
	public void RoomPanelInvite(List<String> users) {
		roomPanel.invite(users);
	}
	
// 패널 공통 메소드
	/**
	 * 특정 사용자에게 쪽지를 보내는 메소드
	 * @param reciever 쪽지를 받을 대상
	 */
	public void sendWhisper(String reciever) {
		// 다이얼로그로 유저 리스트와 버튼 표시
		Panel panel = new Panel();
		TextArea whisperTA = new TextArea(2,1);
		panel.setLayout(new BorderLayout());
		panel.add(new Label("받는사람 : " + reciever), BorderLayout.NORTH);
		panel.add(whisperTA, BorderLayout.CENTER);
		String[] buttons = {"쪽지", "취소"};
		int result = JOptionPane.showOptionDialog(this, panel, "쪽지 발신", 
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, 
				null, buttons, null);
		
		// 선택한 버튼 분석
		if(result == 0) {
			if(whisperTA.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "메시지가 빈칸입니다.", "경고", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String clientMessage = Protocol.CS_WHISPER + Protocol.DELEMETER + 
					client.currentTime() + Protocol.DELEMETER + 
					client.getNickName() + Protocol.DELEMETER +
					reciever + Protocol.INNER_DELEMETER+ 
					whisperTA.getText() ;
			client.sendMessage(clientMessage);
		}
		else {
			System.out.println("[debug] 쪽지 보내기 취소");
		}
	}
	/**
	 * 수신한 쪽지를 보여주는 메소드
	 */
	public void recieveWhisper(String sender, String message) {
		Panel panel = new Panel();
		TextArea messageTA = new TextArea(message, 2,1, TextArea.SCROLLBARS_NONE);
		TextArea replyTA = new TextArea(2,1);

		messageTA.setEditable(false);
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(new Label("보낸사람 : " + sender));
		panel.add(messageTA);
		panel.add(new Label("답장"));
		panel.add(replyTA);
		
		String[] buttons = {"답장 전송", "취소"};
		int result = JOptionPane.showOptionDialog(this, panel,"쪽지 수신", 
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, 
				null, buttons, null);

		// 선택한 버튼 분석
		if(result == 0) {
			if(replyTA.getText().equals("")) {
				JOptionPane.showMessageDialog(this, "메시지가 빈칸입니다.", "경고", JOptionPane.ERROR_MESSAGE);
				return;
			}
			String clientMessage = Protocol.CS_WHISPER + Protocol.DELEMETER + 
					client.currentTime() + Protocol.DELEMETER + 
					client.getNickName() + Protocol.DELEMETER +
					sender + Protocol.INNER_DELEMETER+
					replyTA.getText() ;
			client.sendMessage(clientMessage);
		}
		else {
			System.out.println("[debug] 쪽지 보내기 취소");
		}
	}
	
	/**
	 * 초대 메시지를 보여주는 메소드
	 */
	public void recieveInvite(String sender, String roomName) {
		String clientMessage = null;
		String[] buttons = {"승락", "거절"};
		int result = JOptionPane.showOptionDialog(this, 
				"[ " + sender + " ] 님이 [ "+ roomName + " ]방으로 초대했습니다.", 
				"초대", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, 
				null, buttons, null);
		// 초대 승낙
		if(result == 0) {
			clientMessage = Protocol.CS_INVITE_OK + Protocol.DELEMETER + 
					client.currentTime() + Protocol.DELEMETER + 
					client.getNickName() + Protocol.DELEMETER +
					roomName;
		}
		// 초대 거절
		else {
			clientMessage = Protocol.CS_WHISPER + Protocol.DELEMETER + 
					client.currentTime() + Protocol.DELEMETER + 
					client.getNickName() + Protocol.DELEMETER +
					sender;
		}
		client.sendMessage(clientMessage);
	}
}