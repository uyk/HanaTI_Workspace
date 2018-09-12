package kr.or.kosta.dva.client.boundary;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WaitingBottomPanel extends Panel{
	// 프레임 카드 변경을 위해 프레임 인스턴스를 가짐
	MainFrame frame;
	Button logoutB, newRoomB, exitB;
	
	public WaitingBottomPanel(MainFrame frame) {
		this.frame = frame;
		
		logoutB = new Button("로그아웃");
		newRoomB = new Button("신규");
		exitB = new Button("종료");
		
		setContents();
		eventRegist();
	}
	
	public void setContents() {
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(logoutB);
		add(newRoomB);
		add(exitB);
	}
	
	public void eventRegist() {
		logoutB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changeCard(MainFrame.LOGIN, null);
				
			}
		});
		newRoomB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//frame.changeCard(MainFrame.ROOM);
				System.out.println("[debug] waitingBottomPanel new room");
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
