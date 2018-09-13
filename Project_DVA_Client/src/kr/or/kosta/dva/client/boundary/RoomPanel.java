package kr.or.kosta.dva.client.boundary;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

import kr.or.kosta.dva.client.entity.DvaRoom;
import kr.or.kosta.dva.client.entity.Protocol;

/**
 * 채팅방 화면을 구현하는 패널
 * 
 * @author 유예겸
 *
 */
public class RoomPanel extends Panel {
	MainFrame frame;
	DvaRoom room;
	
	// 화면구성 인스턴스 변수
	Label roomNameL, userListL;
	TextArea chatTA;
	List userList;
	TextField newChatTF;
	Button sendB;
	
	RoomBottomPanel bottomPanel;
	
	// 레이아웃관련 인스턴스 변수
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	/**
	 * 패널이 부착된 프레임을 인자로 받는 생성자.
	 * 화면 출력 인스턴스들을 초기화하고 컨텐츠 배치 메소드 호출.
	 * 
	 * @param frame 패널이 부착된 프레임
	 */
	public RoomPanel(MainFrame frame) {
		this.frame = frame;
		
		roomNameL = new Label("새로운 대화방");
		userListL = new Label("유저 목록", Label.CENTER);
		chatTA = new TextArea();
		chatTA.setEditable(false);
		userList = new List();
		newChatTF = new TextField();
		sendB = new Button("전송");
		
		bottomPanel = new 	RoomBottomPanel(frame);
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		setContents();
		eventRegist();
	}

// getter, setter
	public DvaRoom getRoom() {
		return room;
	}

	public void setRoom(DvaRoom room) {
		this.room = room;
		chatTA.setText("");
		setHeader();

	}
	public void setRoomUserList() {
		userList.removeAll();
		for(int i = 0; i < room.getClients().size(); i++)
			userList.add(room.getClients().get(i));
		
	}
	/** 채팅방 정보 출력 */
	public void setHeader() {
		roomNameL.setText( String.format("방제 : %-60s 방장 : %-15s [ %d / %d ]", room.getRoomName(), room.getRoomOwner() 
				, room.getUserCount(), room.getCapacity()));
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

		// 제목 영역
		addToGridBag(roomNameL,		0, 0, 2, 1, 1, 0);
		addToGridBag(userListL, 	2, 0, 1, 1, 0, 0);

		// 메인 화면 영역
		addToGridBag(chatTA, 		0, 1, 2, 1, 1, 1);
		addToGridBag(userList, 		2, 1, 1, 2, 1, 1);
		
		//메시지 전송 영역
		addToGridBag(newChatTF, 	0, 2, 1, 1, 1, 0);
		addToGridBag(sendB, 		1, 2, 1, 1, 0, 0);
		
		// 버튼 영역
		addToGridBag(bottomPanel, 	0, 3, 3, 1, 0, 0);
	}

// 이벤트관련 메소드
	/**
	 * 컴포넌트에 이벤트를 등록하는 메소드
	 */
	public void eventRegist() {
		// 유저를 선택하면 쪽지보내기 버튼 활성화
		userList.addItemListener(new ItemListener() {	
			@Override
			public void itemStateChanged(ItemEvent e) {
				bottomPanel.whisperB.setEnabled(true);
			}
		});
		// 채팅창에 메시지 입력하고 엔터
		newChatTF.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendChat();
			}
		});
		// 전송버튼
		sendB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sendChat();
			}
		});
	}
	/**
	 * 서버에 메시지를 보내는 메소드
	 */
	public void sendChat() {
		if(newChatTF.getText().equals("")) return;
		
		String clientMessage = Protocol.CS_CHAT_MESSAGE + Protocol.DELEMETER
				+ frame.client.currentTime() + Protocol.DELEMETER +
				frame.client.getNickName() + Protocol.DELEMETER +
				newChatTF.getText();
		frame.client.sendMessage(clientMessage);
	}

	/**
	 * 서버로부터 채팅 메시지를 수신하여 출력하는 메소드
	 * @param chat
	 */
	public void newChat(String chat) {
		chatTA.append(chat);
		newChatTF.setText("");
	}
	/**
	 * 서버로부터 유저 목록을 받아 설정하는 메소드
	 * @param users 서버에서 받아온 유저 목록
	 */
	public void setRoomUsers(java.util.List<String> users) {
		room.setClients(users);
		room.setUserCount(room.getClients().size());
		userList.removeAll();
		for (String string : users) {
			userList.add(string);
		}
		setHeader();	//인원 수정
	}
	
	/** 대기실에 신규 유저 들어오면 추가하는 메소드 */
	public void newRoomUser(String user) {
		room.getClients().add(user);
		room.setUserCount(room.getClients().size());
		userList.add(user);

		setHeader();	//인원 수정
	}
	
	/** 대기실에서 유저가 나가면 제거하는 메소드 */
	public void outRoomUser(String user) {
		room.getClients().remove(user);
		room.setUserCount(room.getClients().size());
		userList.remove(user);

		setHeader();	//인원 수정
	}
	
	/** 방을 나가 대기실로 돌아가는 메소드 */
	public void outRoom() {	
		// 방 나간다고 서버에 알리기
		String clientMessage = Protocol.CS_ROOM_OUT + Protocol.DELEMETER +
				frame.client.currentTime() + Protocol.DELEMETER + 
				frame.client.getNickName();
		frame.client.sendMessage(clientMessage);
		frame.changeCard(MainFrame.WAIT, null);
		
	}
	/** 유저를 초대하기 위해 대기실 유저 목록을 요청하는 메소드 */
	public void sendInviteRequest() {
		String clientMessage = Protocol.CS_GET_LIST + Protocol.DELEMETER + 
				frame.client.currentTime() + Protocol.DELEMETER + 
				frame.client.getNickName() + Protocol.DELEMETER +
				Protocol.CS_ROOMUSERLIST + Protocol.INNER_DELEMETER + 
				Protocol.ANTEROOM;
		frame.client.sendMessage(clientMessage);
	}
	/** 유저를 방에 초대하는 메소드 */
	public void invite(java.util.List<String> users) {
		// 다이얼로그로 유저 리스트와 버튼 표시
		Panel panel = new Panel();
		List waitUsers = new List();
		
		for (String string : users) {
			waitUsers.add(string);
		}
		panel.add(waitUsers);
		
		String[] buttons = {"초대", "취소"};
		int result = JOptionPane.showOptionDialog(this, panel, "대기실 유저 초대", 
				JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, 
				null, buttons, null);
		
		// 유저 선택 후 초대 클릭
		if((result == 0) && (waitUsers.getSelectedIndex() != -1)) {
			String clientMessage = Protocol.CS_INVITE + Protocol.DELEMETER + 
					frame.client.currentTime() + Protocol.DELEMETER + 
					frame.client.getNickName() + Protocol.DELEMETER +
					waitUsers.getSelectedItem();
			frame.client.sendMessage(clientMessage);
		}
		else {
			System.out.println("[debug] 쪽지 보내기 취소");
		}
	}
}