package kr.or.kosta.dva.client.boundary;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Panel;

public class WaitingBottomPanel extends Panel{
	Button logoutB, enterB, newRoomB, exitB;
	
	public WaitingBottomPanel() {
		logoutB = new Button("로그아웃");
		enterB = new Button("입장");
		newRoomB = new Button("신규");
		exitB = new Button("종료");
		
		setContents();
	}
	
	public void setContents() {
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(logoutB);
		add(enterB);
		add(newRoomB);
		add(exitB);
	}
}
