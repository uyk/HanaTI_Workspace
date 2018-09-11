package kr.or.kosta.dva.client.boundary;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomBottomPanel extends Panel{
	// 프레임 카드 변경을 위해 프레임 인스턴스를 가짐
	MainFrame frame;
	Button logoutB, waitB, inviteB, exitB;
	
	public RoomBottomPanel(MainFrame frame) {
		this.frame = frame;
		
		logoutB = new Button("로그아웃");
		waitB = new Button("대기실");
		inviteB = new Button("초대");
		exitB = new Button("종료");
		
		setContents();
		eventRegist();
	}
	
	public void setContents() {
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(logoutB);
		add(waitB);
		add(inviteB);
		add(exitB);
	}
	
	public void eventRegist() {
		logoutB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changeCard(MainFrame.LOGIN);
				
			}
		});
		waitB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changeCard(MainFrame.WAIT);
				
			}
		});
		inviteB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//frame.changeCard(MainFrame.ROOM);
				System.out.println("debug : invite");
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
