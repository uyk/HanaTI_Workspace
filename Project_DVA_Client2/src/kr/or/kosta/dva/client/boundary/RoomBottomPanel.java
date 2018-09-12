package kr.or.kosta.dva.client.boundary;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class RoomBottomPanel extends Panel{
	// 프레임 카드 변경을 위해 프레임 인스턴스를 가짐
	MainFrame frame;
	Button logoutB, waitB, inviteB, exitB;
	
	public RoomBottomPanel(MainFrame frame) {
		this.frame = frame;
		
		waitB = new Button("대기실");
		inviteB = new Button("초대");
		logoutB = new Button("로그아웃");
		exitB = new Button("종료");
		
		setContents();
		eventRegist();
	}
	
	public void setContents() {
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(waitB);
		add(inviteB);
		add(logoutB);
		add(exitB);
	}
	
	public void eventRegist() {
		waitB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changeCard(MainFrame.WAIT, null);
				
			}
		});
		
		inviteB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Panel panel = new Panel();
				//panel.add(roomUsersList);
				String[] buttons = {"방 입장", "쪽지", "취소"};
				int result = JOptionPane.showOptionDialog(null, panel, "초대", 
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, 
						null, buttons, null);
				System.out.println("debug roomBottomPanel actionListener: invite");
			}
		});
		
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
