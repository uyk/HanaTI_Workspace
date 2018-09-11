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

/**
 * 대기실 화면을 구현하는 패널
 * @author 유예겸
 *
 */
public class WaitingPanel extends Panel {
	MainFrame frame;
	
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
		
		searchType = new Choice();
		searchType.add("대화방 제목");
		searchType.add("방장");
		searchType.add("참여자");
		
		searchTF = new TextField();
		
		searchB = new Button("검색");	
		
		roomL = new Label("번호");
		waitL = new Label("대기실 명단", Label.CENTER);
		
		roomList = new List();
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
		
	}
}
