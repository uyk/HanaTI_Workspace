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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.ArrayList;
import java.util.StringTokenizer;

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
	java.util.List<DvaRoom> currentRooms;		// 방목록
	java.util.List<String> waitUsers;			// 대기실 유저 목록
	java.util.List<String> selectRoomUsers;		// 특정 방 유저 목록 

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

//생성자
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
		
		searchTF = new TextField();
		
		searchB = new Button("검색");	
		
		roomL = new Label(String.format("%-15s %-75s %-25s %s", "번호",
				"방 이름", "방장", "인원"));
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
	
	
	
// 배치관련 메소드
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
		addToGridBag(roomL, 			0, 1, 4, 1, 0, 0);
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
		/** 검색창에서 엔터를 입력하면 발생하는 이벤트 */
		searchTF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchRoom();
				
			}
		});
		/** 검색 버튼을 눌렀을 때 발생하는 이벤트 */
		searchB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				searchRoom();
			}
		});
		/** 방 목록에서 방을 클릭했을 때 발생하는 이벤트*/
		roomList.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// 리스트에서 선택한 영역을 텍스트로 반환
				String roomInfo = roomList.getSelectedItem();
				// 공백으로 분리
				StringTokenizer st = new StringTokenizer(roomInfo, " ");
				java.util.List<String> tokens = new ArrayList<>();
				while(st.hasMoreTokens()) {
					tokens.add(st.nextToken());
				}
				// 뒤에서 두번째가 방장
				String roomOwner = tokens.get(tokens.size() - 2);
				System.out.println("[debug] 이름 : " + roomOwner);
				
				// 방장이름으로 선택한 방 정보를 찾아 enterRoom에 저장
				for (DvaRoom dvaRoom : rooms) {
					if(dvaRoom.getRoomOwner().equals(roomOwner)) {
						enterRoom = dvaRoom;
					}
				}
				
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
		/** 대기실 유저와 방 유저 둘 중 한군데만 선택될 수 있음 */
		/** 대기실 유저 목록에서 유저를 클릭했을 때 발생하는 이벤트 */
		waitList.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// 방 유저 목록에 선택된 유저가 있으면 선택 해제
				if(roomUserList.getSelectedIndex() != -1) {
					roomUserList.deselect(roomUserList.getSelectedIndex());
				}
				bottomPanel.whisperB.setEnabled(true);
			}
		});
		/** 방 유저 목록에서 유저를 클릭했을 때 발생하는 이벤트 */
		roomUserList.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				// 방 유저 목록에 선택된 유저가 있으면 선택 해제
				if(waitList.getSelectedIndex() != -1) {
					waitList.deselect(waitList.getSelectedIndex());
				}
				bottomPanel.whisperB.setEnabled(true);
			}
		});
	}
	
// 데이터 관련 메소드
	/** 
	 * 방 정보 목록을 포매팅하여 리스트에 출력하는 메소드
	 */
	public void formatRoomList(java.util.List<DvaRoom> rooms) {
		roomList.removeAll();					// awt 리스트 초기화
		for (int i = 0; i < rooms.size(); i++) {
			DvaRoom room = rooms.get(i);
			int nb = room.getRoomName().getBytes().length;
			int ob= room.getRoomOwner().getBytes().length;
			nb = 80 - nb;
			ob = 30 - ob;
			roomList.add(String.format("%-15d %-"+nb+"s %-"+ob+"s %s/%s", 
					i + 1, room.getRoomName(),
					room.getRoomOwner(), 
					room.getUserCount(), room.getCapacity()));
		}
	}
	/**
	 * 방 목록을 받아와 저장하고 리스트에 출력
	 * @param rooms	방 정보 목록
	 */
	public void setRoomList(java.util.List<DvaRoom> rooms) {
		this.rooms = rooms;
		formatRoomList(rooms);
		
	}
	/** 대기실 유저 목록 설정 */
	public void setWaitUsers(java.util.List<String> users) {
		this.waitUsers = users;
		waitList.removeAll();
		for (int i = 0; i < users.size(); i++) {
			waitList.add(users.get(i));
		}
	}
	/** 선택한 방 유저 목록 설정 */
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
	
	/** 방에 입장하는 메소드 */
	public void enterRoom(String roomName) {
		for (DvaRoom dvaRoom : rooms) {
			if(dvaRoom.getRoomName().equals(roomName))
				enterRoom = dvaRoom;
		}
		enterRoom.getClients().add(frame.client.getNickName());
		frame.changeCard(MainFrame.ROOM, enterRoom);
	}
	
	/** 대기실에 신규 유저 들어오면 추가하는 메소드 */
	public void newWaitUser(String user) {
		waitUsers.add(user);
		waitList.add(user);
		
	}
	
	/** 대기실에서 유저가 나가면 제거하는 메소드 */
	public void outWaitUser(String user) {
		waitUsers.remove(user);
		waitList.remove(user);
		
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
				char c = e.getKeyChar();
				if(c != '\b' && (e.getKeyChar() < '0' || e.getKeyChar() > '9')) {
					JOptionPane.showMessageDialog(panel, "숫자만 입력하세요", "경고", JOptionPane.ERROR_MESSAGE);
					e.consume();
				}
			}
		});
		
		// 방장 필드에는 공백 불가
		enterNameTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if(!(c+"").matches("^[ㄱ-ㅣ0-9가-힣a-zA-Z\\s]") && c != '\b') {
					JOptionPane.showMessageDialog(panel, "유효하지 않은 문자입니다", "경고", JOptionPane.ERROR_MESSAGE);
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
			// 빈칸이 있을경우 종료
			if ( enterNameTF.getText().equals("") || capacityTF.getText().equals("")) {
				JOptionPane.showMessageDialog(frame, "빈칸을 모두 입력하세요.", "경고", JOptionPane.ERROR_MESSAGE);
				return;
			}
			// 수용인원이 너무 클 경우
			if (Integer.parseInt(capacityTF.getText()) > 40) {
				JOptionPane.showMessageDialog(frame, "최대 수용 인원은 40입니다.", "경고", JOptionPane.ERROR_MESSAGE);
				return;
			}
			enterRoom  = new DvaRoom(enterNameTF.getText(), frame.client.getNickName(), 1,
					Integer.parseInt(capacityTF.getText()));
			clientMessage = Protocol.CS_ROOM_ADD + Protocol.DELEMETER +
					frame.client.currentTime() + Protocol.DELEMETER +
					frame.client.getNickName() + Protocol.DELEMETER + 
					enterRoom.getRoomName() + Protocol.INNER_DELEMETER + 
					enterRoom.getCapacity();
			frame.client.sendMessage(clientMessage);
		}


	}
	
	/** 방 이름 또는 방장으로 검색하는 메소드 */
	public void searchRoom() {
		java.util.List<DvaRoom> searchedRooms = new ArrayList<DvaRoom>();
		String text = searchTF.getText();
		// 검색 영역이 빈칸이면 전체 출력
		if(searchTF.getText().equals("")) {
			formatRoomList(rooms);
		}
		//검색 조건
		switch(searchType.getSelectedIndex()) {
		// 제목
		case 0 :
			for (DvaRoom dvaRoom : rooms) {
				if(dvaRoom.getRoomName().contains(text)) {
					searchedRooms.add(dvaRoom);
				}
			}
			break;
		// 방장
		case 1 : 
			for (DvaRoom dvaRoom : rooms) {
				if(dvaRoom.getRoomOwner().contains(text)) {
					searchedRooms.add(dvaRoom);
				}
			}
			break;
		}
		formatRoomList(searchedRooms);
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