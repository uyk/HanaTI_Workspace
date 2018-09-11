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
import java.util.ArrayList;

import javax.swing.JOptionPane;

import kr.or.kosta.dva.client.entity.DvaClient;
import kr.or.kosta.dva.client.entity.DvaRoom;
import kr.or.kosta.dva.client.entity.Protocol;

/**
 * 대기실 화면을 구현하는 패널
 * @author 유예겸
 *
 */
public class WaitingPanel extends Panel {
	MainFrame frame;
	//Hashtable<String, Room> rooms;
	java.util.List<DvaRoom> rooms;
	java.util.List<DvaClient> waitUsers;
	java.util.List<DvaClient> roomUsers;
	
	// 화면구성 인스턴스 변수
	Choice searchType;
	TextField searchTF;
	Button searchB;
	Label roomL, waitL;
	List roomList, waitList;
	
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
		//rooms = new Hashtable<String, Room>();
		rooms = new ArrayList<DvaRoom>();
		
		searchType = new Choice();
		searchType.add("대화방 제목");
		searchType.add("방장");
		searchType.add("참여자");
		
		searchTF = new TextField();
		
		searchB = new Button("검색");	
		
		roomL = new Label("번호");
		waitL = new Label("대기실 명단", Label.CENTER);
		
		roomList = new List();
		process();
		waitList = new List();
		
		bottomPanel = new WaitingBottomPanel(frame);
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
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
		addToGridBag(searchType,	0, 0, 1, 1, 0, 0);
		addToGridBag(searchTF, 		1, 0, 1, 1, 1, 0);
		addToGridBag(searchB,		2, 0, 1, 1, 0, 0);
		addToGridBag(new Label(""), 3, 0, 3, 1, 0, 0);

		// 메인 화면 영역
		addToGridBag(roomL, 		0, 1, 1, 1, 0, 0);
		addToGridBag(new Label("제목"), 1, 1, 1, 1, 0, 0);
		addToGridBag(new Label("방장"), 2, 1, 1, 1, 0, 0);
		addToGridBag(new Label("인원"), 3, 1, 1, 1, 0, 0);
		addToGridBag(waitL, 		4, 1, 2, 1, 0, 0);
		
		addToGridBag(roomList, 		0, 2, 4, 1, 1, 1);
		addToGridBag(waitList, 		4, 2, 2, 1, 1, 1);
		
		// 버튼 영역
		addToGridBag(bottomPanel, 	0, 3, 6, 1, 0, 0);
	}
	
	/**
	 * 컴포넌트에 이벤트를 등록하는 메소드
	 */
	public void eventRegist() {		
		roomList.addItemListener(new ItemListener() {		
			@Override
			public void itemStateChanged(ItemEvent e) {
				DvaRoom room = rooms.get(roomList.getSelectedIndex());
				Panel panel = new Panel();
				
				String[] buttons = {"방 입장", "쪽지", "취소"};
				int result = JOptionPane.showOptionDialog(null, panel, room.getRoomName(), JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, buttons, null);
				switch(result) {
				case 0:
					frame.changeCard(MainFrame.ROOM);
					break;
				case 1:
					//frame.sendPrivate(frame.client.getName(),  to);
					break;
				case 2:
					break;
				}
//				Panel panel = new Panel();
//				JOptionPane.showConfirmDialog(
//					    null, panel, "CPM Program", JOptionPane.OK_CANCEL_OPTION);
			}
		});
	}

	/**
	 *  서버로부터 받은 메시지를 처리하는 메소드
	 */
	public void process() {
		// 서버로 부터 받은 방리스트 메시지 샘플
//		String message = "2001☆☆2018-09-11 오후 05:43:06☆☆나"
//				+ "☆☆방제목 샘플1★★유예겸★★5★★15"
//				+ "☆☆방제목 샘플2★★김예겸★★5★★15"
//				+ "☆☆방제목 샘플3★★이예겸★★5★★15"
//				+ "☆☆방제목 샘플4★★최예겸★★5★★15";
		
		String message = "2001☆☆2018-09-11 오후 05:43:06☆☆나"
		+ "☆☆방제목 샘플1★★유예겸★★5★★15"
		+ "★★방제목 샘플2★★김예겸★★5★★15"
		+ "★★방제목 샘플3★★이예겸★★5★★15"
		+ "★★방제목 샘플4★★최예겸★★5★★15";
		                                     
		String[] tokens = message.split(Protocol.DELEMETER);
		int protocol = Integer.parseInt(tokens[0]);
		String time = tokens[1];
		String nickName = tokens[2];

		switch (protocol) { 
		case Protocol.SC_ROOMLIST :
			
			rooms.clear();
			roomList.removeAll();

		 	// tokens[3] : 방제목 샘플1★★유예겸★★5★★15.....
			String[] roomTokens = tokens[3].split(Protocol.INNER_DELEMETER);
			
			for (int i = 0; i < roomTokens.length; i += 4) {
				DvaRoom room = new DvaRoom(roomTokens[i], roomTokens[i+1], 
						Integer.parseInt(roomTokens[i+2]), 
						Integer.parseInt(roomTokens[i+3]));
				rooms.add(room);
				roomList.add(String.format("%-10d %-30s %-10s %s/%s", 
						(i / 4) + 1, room.getRoomName(),
						room.getRoomOwner(), 
						room.getUserCount(), room.getCapacity()));
			}
			break;

		case Protocol.SC_ROOMUSERLIST :
			// 유저 목록 받음
			//user
			break;
		}
	}
}
