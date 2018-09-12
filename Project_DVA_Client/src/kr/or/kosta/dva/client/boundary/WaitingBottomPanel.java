package kr.or.kosta.dva.client.boundary;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import kr.or.kosta.dva.client.entity.DvaRoom;
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
	
	public WaitingBottomPanel(MainFrame frame) {
		this.frame = frame;
		
		enterB = new Button("입장");
		enterB.setEnabled(false);
		newRoomB = new Button("신규");
		whisperB = new Button("쪽지");
		logoutB = new Button("로그아웃");
		exitB = new Button("종료");
		
		setContents();
		eventRegist();
	}
	
	public void setContents() {
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(enterB);
		add(newRoomB);
		add(whisperB);
		add(logoutB);
		add(exitB);
	}
	
	public void eventRegist() {
		enterB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.waitingPanel.enterRoom();
				System.out.println("[debug] waitingBottomPanel new room");
			}
		});
		
		newRoomB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.waitingPanel.createRoom();
			}
		});
		
		whisperB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		
		logoutB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changeCard(MainFrame.LOGIN, null);
				
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
