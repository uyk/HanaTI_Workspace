package kr.or.kosta.boundary;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.kosta.entity.Account;
import kr.or.kosta.entity.AccountException;
import kr.or.kosta.entity.MinusAccount;

/**
 * 계좌 관리 프로그램.
 * 
 * AMSEventHandler : InputPanel에서 발생하는 Account 관련 이벤트 처리 클래스.
 * 
 * @author 유예겸
 *
 */

public class AMSEventHandler extends KeyAdapter implements ActionListener, ItemListener {
// 인스턴스 메소드
	InputPanel inputPanel;
	MainFrame mainFrame;
	
// 생성자
	/**
	 * 디폴트 생성자
	 */
	public AMSEventHandler() {
		this(new InputPanel());
	}
	/**
	 * inputPanel과 mainFrame을 초기화하는 생성자
	 * 
	 * @param inputPanel
	 */
	public AMSEventHandler(InputPanel inputPanel) {
		this.inputPanel = inputPanel;
		this.mainFrame = inputPanel.mainFrame;
	}
	
// 인스턴스 메소드
	/**
	 * 숫자로 된 계좌번호를 형식에 맞게 수정하여 반환하는 메소드
	 * 
	 * @param accountNum	계좌번호
	 * @return	계좌번호에 - 구분자를 추가하여 반환
	 */
	public String accountNumFormat(String accountNum) {
		return accountNum.substring(0, 4) + "-" + accountNum.substring(4, 8) + "-"
				+ accountNum.substring(8, 12);
	}
	
	/**
	 * 입력받은 계좌번호가 유효한지 검사하는 메소드.
	 * 유효하지 않으면 에러 다이어그램을 생성한다.
	 * 
	 * @param accountNum 계좌번호
	 * @return 유효하면 true, 그렇지 않으면 false
	 */
	public boolean isValidNum(String accountNum) {
		// 계좌번호 텍스트필드가 빈칸
		if (accountNum.equals("")) {
			JOptionPane.showMessageDialog(null, "계좌번호를 입력하세요", "알림", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		// 계좌번호 길이가 12자 아님
		else if(inputPanel.accountNumTF.getText().length() != 12) {
			JOptionPane.showMessageDialog(null, "계좌번호는 12자리 숫자만 가능합니다", "알림", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
		
	}
	
// 오버라이딩 메소드
	/**
	 * 텍스트필드에서 key입력이 발생했을 때 호출되는 메소드
	 */
	@Override
	public void keyTyped(KeyEvent e) {
		char inputC = e.getKeyChar();
		// 예금주명 필드에 키 입력됨
		if(e.getSource() == inputPanel.accountOwnerTF) {
			// 문자 입력이 아닐 경우
			if( inputC != '\b' && !(Character.isLetter(inputC) ) ){
				JOptionPane.showMessageDialog(null, "잘못된 입력입니다", "알림", JOptionPane.ERROR_MESSAGE);
				e.consume();
			}
		}
		// 그 외의 필드에 키 입력됨
		else {
			// 숫자 입력이 아닐 경우
			if( !(Character.isDigit(inputC)) && inputC != '\b') {
				JOptionPane.showMessageDialog(null, "숫자를 입력해주세요", "알림", JOptionPane.ERROR_MESSAGE);
				e.consume();
			}
			
		}
	}
	
	/**
	 * 버튼에서 ActionEvent가 발생했을 때 호출되는 메소드
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// 계좌정보 텍스트영역 초기화
		inputPanel.setTextArea();

		// 등록 버튼 눌림
		if (e.getSource() == inputPanel.newAccountB) {
			// 계좌번호, 예금주, 비밀번호, 입금금액 중 한 칸이라도 빈 칸이 있을 경우
			if (inputPanel.accountNumTF.getText().equals("") || inputPanel.accountOwnerTF.getText().equals("")
					|| inputPanel.passwdTF.getText().equals("") || inputPanel.depositTF.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "빈칸을 모두 채워주세요", "알림", JOptionPane.ERROR_MESSAGE);
			}
			
			// 계좌번호 유효성 검사
			else if( isValidNum(inputPanel.accountNumTF.getText()) ) {
				String accountNum = inputPanel.accountNumTF.getText();
				String accountOwner = inputPanel.accountOwnerTF.getText();
				int passwd = Integer.parseInt(inputPanel.passwdTF.getText());
				long restMoney = Long.parseLong(inputPanel.depositTF.getText());

				accountNum = accountNumFormat(accountNum);

				// account에 입력한 정보 저장
				Account account;

				// 마이너스 계좌인 경우
				if (inputPanel.borrowTF.isEnabled()) {
					long borrowMoney;
					// 대출금 필드가 빈칸이면 0원으로 설정
					if (inputPanel.borrowTF.getText().equals("")) {
						borrowMoney = 0L;
					} else
						borrowMoney = Long.parseLong(inputPanel.borrowTF.getText());
					account = new MinusAccount(accountNum, accountOwner, passwd, restMoney, borrowMoney);
				}
				// 입출금계좌인 경우
				else {
					account = new Account(accountNum, accountOwner, passwd, restMoney);
				}

				// accountManager의 계좌정보 테이블에 계좌정보 추가
				try {
					mainFrame.accountManager.add(account);
					JOptionPane.showMessageDialog(null, "계좌를 등록했습니다.", "알림", JOptionPane.INFORMATION_MESSAGE);
				} catch (AccountException e2) {
					JOptionPane.showMessageDialog(null, "이미 존재하는 계좌번호 입니다", "알림", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		// 조회버튼 눌림
		else if (e.getSource() == inputPanel.numSearchB) {
			String accountNum = inputPanel.accountNumTF.getText();
			
			// 유효 검사 후 accountManager의 searchByNumber를 호출하여 accountNum 계좌번호의 계좌 출력
			if(isValidNum(accountNum)) {
				accountNum = accountNumFormat(accountNum);
				Account account = mainFrame.accountManager.searchByNumber(accountNum);
				inputPanel.accountsListTA.append(inputPanel.accountFormat(account));
			}
		}

		// 삭제버튼 눌림
		else if (e.getSource() == inputPanel.numDeleteB) {
			String accountNum = inputPanel.accountNumTF.getText();

			// 유효 검사 후 accountManager의 remove를 호출하여 accountNum 계좌번호의 계좌 제거
			if(isValidNum(accountNum)) {
				accountNum = accountNumFormat(accountNum);
				if (mainFrame.accountManager.remove(accountNum))
					JOptionPane.showMessageDialog(null, accountNum + "계좌를 제거했습니다", "알림",
							JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, accountNum + "계좌를 제거하지 못했습니다.", "알림",
							JOptionPane.ERROR_MESSAGE);
			}
		}

		// 예금주명으로 검색
		else if (e.getSource() == inputPanel.ownerSearchB) {
			String accountOwner = inputPanel.accountOwnerTF.getText();

			// 예금주명 텍스트필드가 빈칸
			if (accountOwner.equals("")) {
				JOptionPane.showMessageDialog(null, "예금주명을 입력하세요", "알림", JOptionPane.ERROR_MESSAGE);
			}

			// 검색하여 계좌정보 텍스트영역에 출력
			else {
				ArrayList<Account> accountsOfowner = (ArrayList<Account>) (mainFrame.accountManager
						.serachByOwner(accountOwner));
				for (Object object : accountsOfowner) {
					inputPanel.accountsListTA.append(inputPanel.accountFormat((Account) object));
				}
			}
		}

		// 전체 조회
		else if (e.getSource() == inputPanel.allAccountB) {
			List<Account> list = mainFrame.accountManager.list();
			for (Object object : list) {
				inputPanel.accountsListTA.append(inputPanel.accountFormat((Account) object));
			}
		}

	}
	/**
	 *  Choice에서 이벤트가 발생했을 때 호출되는 메소드
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {
		// 마이너스 계좌를 선택했을 때만 대출금액 필드 활성화
		if (e.getItem().equals("마이너스계좌"))
			inputPanel.borrowTF.setEnabled(true);
		else
			inputPanel.borrowTF.setEnabled(false);
		inputPanel.borrowTF.setText("");
	}

}
