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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ko.or.kosta.entity.Account;
import ko.or.kosta.entity.AccountException;
import ko.or.kosta.entity.MinusAccount;

/**
 * 계좌 관리 프로그램
 * 
 * InputPanel : 데이터의 입력을 위한 패널.
 * 부모클래스 : Panel
 * 
 * @author 유예겸
 *
 */
public class InputPanel extends Panel implements ActionListener{
	
// 인스턴스 변수
	Label accountTypeL, accountNumL, accountOwnerL, passwdL, depositL, borrowL, accountsListL, moneyWonL;
	Choice accountTypeCh;
	TextField accountNumTF, accountOwnerTF, passwdTF, depositTF, borrowTF;
	Button numSearchB, numDeleteB, ownerSearchB, newAccountB, allAccountB;
	TextArea accountsListTA;

	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	MainFrame mainFrame;
	final String header = "--------------------------------------------------------------------"
			+ String.format("\n %-10s %-10s %-10s %-10s %s", "계좌종류", "계좌번호", "예금주명","현재잔액", "대출금액")
			+ "\n====================================================================\n";

// 생성자
	/**
	 * 디폴트 생성자. 다른 생성자 호출
	 */
	public InputPanel() {
		this(new MainFrame());
	}
	
	/**
	 * 프레임을 매개변수로 받는 생성자.
	 * 인스턴스 변수 초기화
	 * @param mainFrame
	 */
	public InputPanel(MainFrame mainFrame) {
		super();
		this.mainFrame = mainFrame;
		
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
		accountTypeCh.add("마이너스계좌");
		
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

		accountsListTA = new TextArea(header);
		borrowTF.setEnabled(false);
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		
		setContents();
		eventRegist();
	}
	
// 인스턴스 메소드
// 배치 관련
	/**
	 * account 계좌의 정보를 출력 포맷에 맞추어 문자열로 반환하는 메소드
	 * 
	 * @param account	문자열로 출력하고자 하는 계좌 정보
	 * @return	계좌 타입에 따라 계좌의 정보를 문자열로 반환
	 */
	private String accountFormat(Account account) {
		if(account instanceof MinusAccount) 
			return String.format("%-14s %14s %14s %14s %14s\n", 
					"마이너스" , account.getAccountNum(), account.getAccountOwner(), account.getRestMoney(),
					((MinusAccount)account).getBorrowMoney());
		else 
			return String.format("%-14s %14s %14s %14s\n", 
					"입출금" , account.getAccountNum(), account.getAccountOwner(), account.getRestMoney());
	}
	
	/**
	 * 계좌정보 텍스트 영역을 초기화하는 메소드
	 */
	private void setTextArea() {
		accountsListTA.setText(header);
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
		
		addToGridBag(accountsListTA, 0, 7, 5, 5, 0, 0);
	}

// 이벤트 관련
	/**
	 * 컴포넌트에 이벤트를 등록하는 메소드
	 */
	public void eventRegist() {
		// 계좌종류 선택 이벤트
		accountTypeCh.addItemListener(new ItemListener() {			
			@Override
			public void itemStateChanged(ItemEvent e) {
				// 마이너스 계좌를 선택했을 때만 대출금엑 필드 활성화
				if (e.getItem().equals("마이너스계좌"))
					borrowTF.setEnabled(true);
				else 
					borrowTF.setEnabled(false);
			}
		});
		// 신규등록	
		newAccountB.addActionListener(this);
		// 계좌번호로 조회
		numSearchB.addActionListener(this);
		// 계좌번호로 조회하여 삭제
		numDeleteB.addActionListener(this);
		// 예금주명으로 조회
		ownerSearchB.addActionListener(this);

	}
	/**
	 * ActionEvent가 발생했을 때 처리하는 메소드
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// 계좌정보 텍스트영역 초기화
		setTextArea();
		
		// 등록 버튼 눌림
		if(e.getSource() == newAccountB) {
			System.out.println("Adding New Account");
			// 계좌번호, 예금주, 비밀번호, 입금금액 중 한 칸이라도 빈 칸이 있을 경우
			if ( accountNumTF.getText().equals("") || accountOwnerTF.getText().equals("")
					|| passwdTF.getText().equals("") || depositTF.getText().equals("")) {
				JOptionPane.showMessageDialog(null,"빈칸을 모두 채워주세요", "알림", JOptionPane.ERROR_MESSAGE);
			}
			// 모든 필드가 채워져 있는 경우
			else {
				String accountNum = accountNumTF.getText();
				String accountOwner = accountOwnerTF.getText();
				int passwd = Integer.parseInt(passwdTF.getText());
				long restMoney = Long.parseLong(depositTF.getText());

				// account에 입력한 정보 저장
				Account account;
				
				// 마이너스 계좌인 경우
				if(borrowTF.isEnabled()) {
					long borrowMoney;
					// 대출금 필드가 빈칸이면 0원으로 설정
					if (borrowTF.getText().equals("")) {
						System.out.println("enter");
						borrowMoney = 0L;
					}
					else borrowMoney = Long.parseLong(borrowTF.getText());
					account = new MinusAccount(accountNum, accountOwner, passwd, restMoney, borrowMoney);
				}
				// 입출금계좌인 경우
				else {
					account = new Account(accountNum, accountOwner, passwd, restMoney);
				}
				
				System.out.println(account);
				
				// accountManager의 계좌정보 테이블에 계좌정보 추가
				try {
					mainFrame.accountManager.add(account);
					JOptionPane.showMessageDialog(null,"계좌를 등록했습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
				} catch (AccountException e2) {
					System.out.println(e2);
					JOptionPane.showMessageDialog(null,"이미 존재하는 계좌번호 입니다", "알림", JOptionPane.ERROR_MESSAGE);
				}
			}
			System.out.println("After Adding : " + mainFrame.accountManager.toString());
		}
		
		// 조회버튼 눌림
		else if(e.getSource() == numSearchB) {
			String accountNum = accountNumTF.getText();
			System.out.println("Searching By Number");
			
			// 계좌번호 텍스트필드가 빈칸
			if (accountNum.equals("")) {
				JOptionPane.showMessageDialog(null,"계좌번호를 입력하세요", "알림", JOptionPane.ERROR_MESSAGE);
			}
			// 검색하여 계좌정보 텍스트영역에 출력
			else {
				Account account = mainFrame.accountManager.searchByNumber(accountNum);
				accountsListTA.append(accountFormat(account));
			}
		}
		
		// 삭제버튼 눌림
		else if(e.getSource() == numDeleteB) {
			String accountNum = accountNumTF.getText();
			System.out.println("Delete By Number");
			
			// 계좌번호 텍스트필드가 빈칸
			if (accountNum.equals("")) {
				JOptionPane.showMessageDialog(null,"계좌번호를 입력하세요", "알림", JOptionPane.ERROR_MESSAGE);
			}
			
			// 빈칸이 아닐 경우 accountManager의 remove를 호출하여 accountNum 계좌번호의 계좌 제거
			else {
				if( mainFrame.accountManager.remove(accountNum))
					JOptionPane.showMessageDialog(null, accountNum + "계좌를 제거했습니다", "알림", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, accountNum + "계좌를 제거하지 못했습니다.", "알림", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		// 예금주명으로 검색
		else if(e.getSource() == ownerSearchB) {
			String accountOwner = accountOwnerTF.getText();
			System.out.println("Search By Owner");
			
			// 예금주명 텍스트필드가 빈칸
			if (accountOwner.equals("")) {
				JOptionPane.showMessageDialog(null,"예금주명을 입력하세요", "알림", JOptionPane.ERROR_MESSAGE);
			}
			
			// 검색하여 계좌정보 텍스트영역에 출력
			else {
				ArrayList<Account> accountsOfowner = (ArrayList<Account>)(mainFrame.accountManager.serachByOwner(accountOwner));
				for (Object object : accountsOfowner) {
					System.out.println(((Account)object).toString());
					accountsListTA.append(accountFormat((Account)object));
				}
			}
		}		
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
