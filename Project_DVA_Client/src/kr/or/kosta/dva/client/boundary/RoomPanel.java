package kr.or.kosta.dva.client.boundary;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
				frame.changeCard(frame.LOGIN);
				
			}
		});
	}
}
