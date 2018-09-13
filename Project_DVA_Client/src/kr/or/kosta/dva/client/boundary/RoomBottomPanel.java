package kr.or.kosta.dva.client.boundary;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;

public class RoomBottomPanel extends Panel{
	// 프레임 카드 변경을 위해 프레임 인스턴스를 가짐
	MainFrame frame;
	Button waitB, inviteB, whisperB, logoutB, exitB;
	
	public RoomBottomPanel(MainFrame frame) {
		this.frame = frame;
		
		waitB = new Button("대기실");
		inviteB = new Button("초대");
		whisperB = new Button("쪽지");
		logoutB = new Button("로그아웃");
		exitB = new Button("종료");
		
		whisperB.setEnabled(false);
		setContents();
		eventRegist();
	}
	
	public void setContents() {
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(waitB);
		add(inviteB);
		add(whisperB);
		add(logoutB);
		add(exitB);
	}
	
	public void eventRegist() {
		// 대기실로 돌아가는 버튼
		waitB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.roomPanel.outRoom();
			}
		});
		
		// 대기실의 유저 초대 버튼
		inviteB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.roomPanel.sendInviteRequest();
				System.out.println("debug roomBottomPanel actionListener: invite");
			}
		});
		
		// 쪽지를 보내는 버튼
		whisperB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.sendWhisper(frame.roomPanel.userList.getSelectedItem());
			}
		});
		
		// 로그아웃 버튼
		logoutB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.logoutEvent();
			}
		});
		
		// 프로그램 종료 버튼
		exitB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.finish();
				
			}
		});
	}

}