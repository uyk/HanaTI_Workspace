package kr.or.kosta.dva.client.boundary;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import kr.or.kosta.dva.client.entity.DvaRoom;
import kr.or.kosta.dva.client.entity.Protocol;

/**
 * 대기실 화면을 구현하는 패널
 * @author 유예겸
 *
 */
public class WaitingPanel extends Panel {
	MainFrame frame;
	java.util.List<DvaRoom> rooms;				// 방목록
	java.util.List<String> waitUsers;			// 대기실 유저 목록
	java.util.List<String> selectRoomUsers;		// 특정 방 유저 목록 
	//String selectedRoom;
	DvaRoom enterRoom;
	String clientMessage;
	
	// 화면구성 인스턴스 변수
	Choice searchType;
	TextField searchTF;
	Button searchB;
	Label roomL, waitL, roomUserL;
	List roomList, waitList, roomUserList;
	
	WaitingBottomPanel bottomPanel;
	
	// 레이아웃관련 인스턴스 변수
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	/**
	 * 패널이 부착된 프레임을 인자로 받는 생성자.
	 * 화면 출력 인스턴스들을 초기화하고 컨텐츠 배치 메소드 호출.
	 * 
	 * @param frame 패널이 부착된 프레임
	 */
	public WaitingPanel(MainFrame frame) {
		this.frame = frame;
		rooms = new ArrayList<DvaRoom>(); 
		waitUsers = new ArrayList<String>();
		selectRoomUsers = new ArrayList<String>();
		
		searchType = new Choice();
		searchType.add("대화방 제목");
		searchType.add("방장");
		searchType.add("참여자");
		
		searchTF = new TextField();
		
		searchB = new Button("검색");	
		
		roomL = new Label("번호");
		waitL = new Label("대기실 명단", Label.CENTER);
		roomUserL = new Label("채팅방 명단", Label.CENTER);
		
		roomList = new List();
		waitList = new List();
		roomUserList = new List();
		
		bottomPanel = new WaitingBottomPanel(frame);
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		//setRoomList();
		setContents();
		eventRegist();
	}
	
	
	/**
	 * GridBag 레이아웃에 컴포넌트를 추가하는 메소드
	 * 
	 * @param component  추가할 컴포넌트
	 * @param gridx      컴포넌트가 추가될 위치의 x좌표
	 * @param gridy      컴포넌트가 추가될 위치의 y좌표
	 * @param gridwidth  컴포넌트가 차지할 x축 면적
	 * @param gridheight 컴포넌트가 차지할 y축 면적
	 * @param weightx    x축 여백에 대한 가중치
	 * @param weighty    y축 여백에 대한 가중치
	 */
	public void addToGridBag(Component component, int gridx, int gridy, int gridwidth, int gridheight, 
			double weightx,	double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;

		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;

		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;

		gridBagConstraints.fill = GridBagConstraints.BOTH; // 호리즌탈(가로채움), 버티컬(새로채움), BOTH(전체채움), NONE(디폴트)
		gridBagConstraints.insets = new Insets(5, 5, 2, 2); // 마진
		gridBagLayout.setConstraints(component, gridBagConstraints);

		add(component);
	}
	
	/**
	 * 패널에 컴포넌트를 배치하는 메소드
	 */
	public void setContents() {
		setLayout(gridBagLayout);

		// 검색 영역
		addToGridBag(searchType,		0, 0, 1, 1, 0, 0);
		addToGridBag(searchTF, 			1, 0, 1, 1, 1, 0);
		addToGridBag(searchB,			2, 0, 1, 1, 0, 0);
		addToGridBag(new Label(""), 	3, 0, 2, 1, 0, 0);

		// 방 정보, 대기실 유저 라벨
		addToGridBag(roomL, 			0, 1, 1, 1, 0, 0);
		addToGridBag(new Label("제목"), 1, 1, 1, 1, 0, 0);
		addToGridBag(new Label("방장"), 2, 1, 1, 1, 0, 0);
		addToGridBag(new Label("인원"), 3, 1, 1, 1, 0, 0);
		addToGridBag(waitL, 			4, 1, 1, 1, 0, 0);
		
		// 방 정보, 대기실 유저 리스트
		addToGridBag(roomList, 			0, 2, 4, 3, 1, 1);
		addToGridBag(waitList, 			4, 2, 1, 1, 1, 1);
		
		// 방 유저 이름
		addToGridBag(roomUserL, 		4, 3, 2, 1, 0, 0);
		
		// 방 유저 리스트
		addToGridBag(roomUserList, 		4, 4, 2, 1, 1, 1);

		// 버튼 영역
		addToGridBag(bottomPanel, 		0, 5, 5, 1, 0, 0);
	}

	/**
	 * 컴포넌트에 이벤트를 등록하는 메소드
	 */
	public void eventRegist() {	
		/** 방 목록에서 방을 클릭했을 때 발생하는 이벤트*/
		roomList.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				//DvaRoom room = rooms.get(roomList.getSelectedIndex());				
				//selectedRoom = room.getRoomName();
				enterRoom = rooms.get(roomList.getSelectedIndex());
				
				// 방 정보 요청 메시지를 보냄			
				clientMessage = Protocol.CS_GET_LIST + Protocol.DELEMETER + 
						frame.client.currentTime() + Protocol.DELEMETER + 
						frame.client.getNickName() + Protocol.DELEMETER +
						Protocol.CS_ROOMUSERLIST + Protocol.INNER_DELEMETER +
						enterRoom.getRoomName();
				frame.client.sendMessage(clientMessage);
				//frame.client.testSendMessage(clientMessage);
				bottomPanel.enterB.setEnabled(true);

			}
		});
	}
	
	/**
	 * 방 목록을 받아와 list 영역에 표시하는 메소드
	 * @param rooms
	 */
	public void setRoomList(java.util.List<DvaRoom> rooms) {
		this.rooms = rooms;
		roomList.removeAll();					// awt 리스트 초기화
		for (int i = 0; i < rooms.size(); i++) {
			DvaRoom room = rooms.get(i);
			roomList.add(String.format("%-10d %-30s %-10s %s/%s", 
					i , room.getRoomName(),
					room.getRoomOwner(), 
					room.getUserCount(), room.getCapacity()));
		}
		
	}
	/** 대기실 유저 목록 설정 */
	public void setWaitUsers(java.util.List<String> users) {
		this.waitUsers = users;
		waitList.removeAll();
		for (int i = 1; i < users.size(); i++) {
			waitList.add(users.get(i));
		}
	}
	/** 특정 방 유저 목록 설정 */
	public void setRoomUsers(java.util.List<String> users) {
		this.selectRoomUsers = users;
		roomUserList.removeAll();
		for (int i = 0; i < users.size(); i++) {
			roomUserList.add(users.get(i));
		}
		System.out.println("[debug] setRoomUsers :" + users);
	}
	
	/** 선택한 방에 입장을 요청하는 메소드 */
	public void tryEnterSelectRoom() {	
		enterRoom.setClients(selectRoomUsers);
		
		// 방 입장 요청 보내기
		clientMessage = Protocol.CS_ENTRANCE + Protocol.DELEMETER +
				frame.client.currentTime() + Protocol.DELEMETER + 
				frame.client.getNickName() + Protocol.DELEMETER + 
				enterRoom.getRoomName();
		
		frame.client.sendMessage(clientMessage);
	}
	
	/** 선택한 방에 입장하는 메소드 */
	/*
	public void enterSelectRoom() {
		DvaRoom room = rooms.get(roomList.getSelectedIndex());
		room.setClients(selectRoomUsers);
		room.getClients().add(frame.client.getNickName());
		//frame.changeCard(MainFrame.ROOM, room);
	}*/
	
	/** 새로운 방에 입장을 요청하는 메소드 */
	/*
	public void tryEnterNewRoom(DvaRoom room) {
		room.getClients().add(frame.client.getNickName());
		//frame.changeCard(MainFrame.ROOM, room);
		
	}
	*/
	
	/** 방에 입장하는 메소드 */
	public void enterRoom() {
		enterRoom.getClients().add(frame.client.getNickName());
		frame.changeCard(MainFrame.ROOM, enterRoom);
	}
	
	/** 방을 생성하는 메소드 */
	public void createRoom() {
		// 다이얼로그로 방 이름과 인원을 입력받는다.
		Panel panel = new Panel();
		Label enterNameL = new Label("방 이름 : ");
		Label capacityL = new Label("최대 인원 : ");
		TextField enterNameTF = new TextField(20);
		TextField capacityTF = new TextField(20);
		
		// 인원 필드에는 숫자만 입력 가능
		capacityTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(e.getKeyChar() < '0' || e.getKeyChar() > '9') {
					JOptionPane.showMessageDialog(panel, "숫자만 입력하세요", "경고", JOptionPane.ERROR_MESSAGE);
					e.consume();
				}
			}
		});
		
		panel.add(enterNameL);
		panel.add(enterNameTF);
		panel.add(capacityL);
		panel.add(capacityTF);
		
		// 다이어그램 표시
		int result = JOptionPane.showConfirmDialog(this, panel, "방 생성", 
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		
		// 방 생성 요청
		if(result == 0) {
			enterRoom  = new DvaRoom(enterNameTF.getText(), frame.client.getNickName(), 
					1, Integer.parseInt(capacityTF.getText()));
			clientMessage = Protocol.CS_ROOM_ADD + Protocol.DELEMETER +
					frame.client.currentTime() + Protocol.DELEMETER +
					frame.client.getNickName() + Protocol.DELEMETER + 
					enterRoom.getRoomName() + Protocol.INNER_DELEMETER + 
					enterRoom.getCapacity();
			frame.client.sendMessage(clientMessage);
		}

	}
	/** 패널을 초기화 하는 메소드 */
	public void resetPanel() {
		rooms = new ArrayList<DvaRoom>(); 
		waitUsers = new ArrayList<String>();
		selectRoomUsers = new ArrayList<String>();
		
		enterRoom = null;
		clientMessage = null;
		
		roomList.removeAll();
		waitList.removeAll();
		roomUserList.removeAll();
	}
}