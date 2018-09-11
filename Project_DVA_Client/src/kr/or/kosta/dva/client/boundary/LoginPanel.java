package kr.or.kosta.dva.client.boundary;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 프로그램 실행시 처음 표시되는 로그인 패널
 * 
 * @author 유예겸
 *
 */
public class LoginPanel extends Panel {
	MainFrame frame;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	Label nickNameL, passwdL;
	TextField emailTF, passwdTF;
	Button loginB, registB;
	
	public LoginPanel(MainFrame frame) {
		this.frame = frame;
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		nickNameL = new Label("EMAIL");
		passwdL = new Label("PASSWD");
		emailTF = new TextField();
		passwdTF = new TextField();
		passwdTF.setEchoChar('*');
		loginB = new Button("LOGIN");
		registB = new Button("REGIST");
		
		setContents();
		eventRegist();
		
	}
	
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;
		gridBagConstraints.fill = gridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new Insets(4, 1, 4, 1);
		
		gridBagLayout.setConstraints(component, gridBagConstraints);		
		add(component);
	}
	
	public void setContents() {
		setLayout(gridBagLayout);
		add(new Label(" "),   	0, 0, 1, 1, 0, 0);
		add(nickNameL,   			1, 0, 1, 1, 0, 0);
		add(emailTF,  			2, 0, 1, 1, 1, 0);
		add(new Label(" "), 	3, 0, 1, 1, 0, 0);
		
		add(new Label(" "),		0, 1, 1, 1, 0, 0);
		add(passwdL,			1, 1, 1, 1, 0, 0);
		add(passwdTF,			2, 1, 1, 1, 1, 0);
		add(new Label(" "),		3, 1, 1, 1, 0, 0);
		
		Panel buttonPanel = new Panel();
		buttonPanel.add(loginB);
		buttonPanel.add(registB);
		
		add(buttonPanel, 		0, 2, 3, 1, 0, 0);
		
	}

	public void eventRegist() {
		
		loginB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("TT");
				frame.changeCard(frame.ROOM);
				
			}
		});
	}
}
