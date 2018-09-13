package kr.or.kosta.dva.client.boundary;

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

import kr.or.kosta.dva.client.entity.DvaRoom;

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
		userList = new List();
		newChatTF = new TextField();
		sendB = new Button("전송");
		
		bottomPanel = new 	RoomBottomPanel(frame);
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		setContents();
		eventRegist();
	}
	
	public DvaRoom getRoom() {
		return room;
	}

	public void setRoom(DvaRoom room) {
		this.room = room;
		roomNameL.setText(room.getRoomName());
	}
	public void setRoomUserList() {
		userList.removeAll();
		for(int i = 1; i < room.getClients().size(); i++)
			userList.add(room.getClients().get(i));
		
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
	
	/**
	 * 컴포넌트에 이벤트를 등록하는 메소드
	 */
	public void eventRegist() {		
		
	}
	
// 
	/**
	 * 서버로부터 유저 목록을 받아 설정하는 메소드
	 * @param users 서버에서 받아온 유저 목록
	 */
	public void setRoomUsers(java.util.List<String> users) {
		userList.removeAll();
		for (String string : users) {
			userList.add(string);
		}
	}
}