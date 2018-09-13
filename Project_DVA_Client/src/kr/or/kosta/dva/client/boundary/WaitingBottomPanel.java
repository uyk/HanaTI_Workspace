package kr.or.kosta.dva.client.boundary;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Waiting Panel에 부착되는 패널 클래스.
 * 입장, 신규, 쪽지, 로그아웃, 종료 버튼을 처리한다.
 * @author 유예겸
 *
 */
public class WaitingBottomPanel extends Panel{
	// 프레임 카드 변경을 위해 프레임 인스턴스를 가짐
	MainFrame frame;
	Button enterB, newRoomB, whisperB, logoutB, exitB;
	
	/**
	 * 생성자. 인스턴스 초기화, 컨텐츠 세팅, 이벤트 등록.
	 * @param frame
	 */
	public WaitingBottomPanel(MainFrame frame) {
		this.frame = frame;
		
		enterB = new Button("입장");
		newRoomB = new Button("신규");
		whisperB = new Button("쪽지");
		logoutB = new Button("로그아웃");
		exitB = new Button("종료");

		enterB.setEnabled(false);
		whisperB.setEnabled(false);
		setContents();
		eventRegist();
	}
	
	/**
	 * 컴포넌트를 패널에 추가하는 메소드.
	 */
	public void setContents() {
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(enterB);
		add(newRoomB);
		add(whisperB);
		add(logoutB);
		add(exitB);
	}
	/**
	 * 컴포넌트에 이벤트를 등록하는 메소드
	 */
	public void eventRegist() {
		// 선택한 방에 입장하는 메소드
		enterB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.waitingPanel.tryEnterSelectRoom();
			}
		});
		// 새로운 방을 생성하는 메소드
		newRoomB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.waitingPanel.createRoom();
			}
		});
		
		// 쪽지를 보내는 메소드
		whisperB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String reciever = null;
				if(frame.waitingPanel.waitList.getSelectedIndex() != -1)
					reciever = frame.waitingPanel.waitList.getSelectedItem();
				else
					reciever = frame.waitingPanel.roomUserList.getSelectedItem();
				frame.sendWhisper(reciever);
			}
		});
		
		// 로그아웃 메소드
		logoutB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.logoutEvent();				
			}
		});
		
		exitB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.finish();
				
			}
		});
	}
}