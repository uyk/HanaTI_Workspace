package kr.or.kosta.boundary;

import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 계좌 관리 프로그램
 * 
 * InputPanel : 데이터의 입력을 위한 패널.
 * 부모클래스 : Panel
 * 
 * @author 유예겸
 *
 */
public class InputPanel extends Panel {
	
// 인스턴스 변수
	Label accountTypeL, accountNumL, accountOwnerL, passwdL, depositL, borrowL, accountsListL, moneyWonL;
	Choice accountTypeCh;
	TextField accountNumTF, accountOwnerTF, passwdTF, depositTF, borrowTF;
	Button numSearchB, numDeleteB, ownerSearchB, newAccountB, allAccountB;

	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	TextArea accountsList;

//생성자
	/**
	 * 디폴트 생성자. 각 컴포넌트와 레이아웃 변수 초기화.
	 */
	public InputPanel() {
		super();
		accountTypeL = new Label("계좌종류");
		accountNumL = new Label("계좌번호");
		accountOwnerL = new Label("예금주명");
		passwdL = new Label("비밀번호");
		depositL = new Label("입금금액");
		borrowL = new Label("대출금액");
		accountsListL = new Label("계좌목록");
		moneyWonL = new Label("(단위 : 원)");
		
		accountTypeCh = new Choice();
		accountTypeCh.add("전체");
		accountTypeCh.add("입출금계좌");
		accountTypeCh.add("마이너스 계좌");
		
		accountNumTF = new TextField(15);
		accountOwnerTF = new TextField(15);
		passwdTF = new TextField(15);
		depositTF = new TextField(15);
		borrowTF = new TextField(15);
		
		numSearchB = new Button("조회");
		numDeleteB = new Button("삭제");
		ownerSearchB = new Button("검색");
		newAccountB = new Button("신규등록");
		allAccountB = new Button("전체조회");
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		accountsList = new TextArea(
				"--------------------------------------------------------------------"
				+ "\n계좌종류\t 계좌번호\t 예금주명\t 현재잔액\t 대출금액"
				+ "\n====================================================================");
		
		setContents();
	}
	
	/**
	 * GridBag 레이아웃에 컴포넌트를 추가하는 메소드
	 * 
	 * @param component		추가할 컴포넌트
	 * @param gridx			컴포넌트가 추가될 위치의 x좌표
	 * @param gridy			컴포넌트가 추가될 위치의 y좌표
	 * @param gridwidth		컴포넌트가 차지할 x축 면적
	 * @param gridheight	컴포넌트가 차지할 y축 면적
	 * @param weightx		x축 여백에 대한 가중치
	 * @param weighty		y축 여백에 대한 가중치
	 */
	public void addToGridBag(Component component,  int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;

		gridBagConstraints.fill = GridBagConstraints.BOTH;	// 호리즌탈(가로채움), 버티컬(새로채움), BOTH(전체채움), NONE(디폴트)
		gridBagConstraints.insets = new Insets(5, 5, 2, 2);			//마진
		gridBagLayout.setConstraints(component, gridBagConstraints);
		
		add(component);
	}
	
	/**
	 * 패널에 컴포넌트를 배치하는 메소드
	 */
	public void setContents() {
		setLayout(gridBagLayout);
		
		// 계좌종류
		addToGridBag(accountTypeL,		0, 0, 1, 1, 0, 0);
		addToGridBag(accountTypeCh,		1, 0, 1, 1, 0, 0);
		addToGridBag(new Label(""),		2, 0, 3, 1, 0, 0);
		
		// 계좌번호
		addToGridBag(accountNumL,		0, 1, 1, 1, 0, 0);
		addToGridBag(accountNumTF,		1, 1, 1, 1, 0, 0);
		addToGridBag(numSearchB,		2, 1, 1, 1, 0, 0);
		addToGridBag(numDeleteB,		3, 1, 1, 1, 0, 0);
		//addToGridBag(new Label(""),		4, 1, 1, 1, 0, 0);
		
		// 예금주명
		addToGridBag(accountOwnerL,		0, 2, 1, 1, 0, 0);
		addToGridBag(accountOwnerTF,	1, 2, 1, 1, 0, 0);
		addToGridBag(ownerSearchB,		2, 2, 1, 1, 0, 0);
		addToGridBag(new Label(""),		3, 2, 3, 1, 0, 0);
		//addToGridBag(new Label(""),		4, 2, 1, 1, 0, 0);
		//addToGridBag(new Label(""),		4, 2, 1, 1, 0, 0);
		
		// 비밀번호, 입금금액
		addToGridBag(passwdL,			0, 3, 1, 1, 0, 0);
		addToGridBag(passwdTF,			1, 3, 1, 1, 0, 0);
		addToGridBag(depositL,			2, 3, 1, 1, 0, 0);
		addToGridBag(depositTF,			3, 3, 2, 1, 0, 0);
		
		// 대출금액, 신규등록, 전체조회
		addToGridBag(borrowL,			0, 5, 1, 1, 0, 0);
		addToGridBag(borrowTF,			1, 5, 1, 1, 0, 0);
		addToGridBag(newAccountB,		2, 5, 1, 1, 0, 0);
		addToGridBag(allAccountB,		3, 5, 1, 1, 0, 0);
		
		// 계좌목록, 단위
		addToGridBag(accountsListL,		0, 6, 1, 1, 0, 0);
		addToGridBag(moneyWonL,			4, 6, 1, 1, 0, 0);
		
		addToGridBag(accountsList, 0, 7, 5, 5, 0, 0);
	}
	
// 테스트를 위한 메인	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame = new Frame("GridBagLayout Mission");
		InputPanel panel = new InputPanel();

		frame.add(panel);
		frame.setSize(800,500);
//		frame.pack();
		frame.setVisible(true);
		
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//finish();
				frame.setVisible(false);
				frame.dispose();
				System.exit(1);
			}
		});
	}
	
	

}
