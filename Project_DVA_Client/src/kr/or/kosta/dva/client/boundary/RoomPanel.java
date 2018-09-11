package kr.or.kosta.dva.client.boundary;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Choice;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 채팅방 화면
 * @author 유예겸
 *
 */
public class RoomPanel extends Panel {
	MainFrame frame;
	Label loginL;
	
	Button logoutB;
	
	public RoomPanel(MainFrame frame) {
		this.frame = frame;
		loginL = new Label("This is Test Panel", Label.CENTER);
		logoutB = new Button("LOGOUT");
		setContents();
	}
	
	public void setContents() {
		setLayout(new BorderLayout());
		Panel panel = new Panel();
		panel.add(logoutB);
		
		add(loginL, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		logoutB.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changeCard(MainFrame.LOGIN);
				
			}
		});
	}
}
