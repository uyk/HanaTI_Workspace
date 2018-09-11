package kr.or.kosta.dva.client.boundary;

import java.awt.Button;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
	
	Label nickNameL;
	TextField nickNameTF;
	Button loginB;
	
	// 생성자
	/**
	 * 패널이 부착되는 프레임을 인자로 받는 생성자.
	 * 인스턴스 변수들을 초기화하고 패널에 컨텐츠를 부착하는 setContents 메소드와
	 * 이벤트를 컴포넌트에 등록하는 eventRegist 메소드를 호출한다.
	 * @param frame	패널이 부착된 프레임
	 */
	public LoginPanel(MainFrame frame) {
		this.frame = frame;
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		nickNameL = new Label("Nick Name");
		nickNameTF = new TextField(20);
		loginB = new Button("LOGIN");
		
		setContents();
		eventRegist();
		
	}
	
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		
		gridBagLayout.setConstraints(component, gridBagConstraints);		
		add(component);
	}
	
	public void setContents() {
		setLayout(gridBagLayout);
		add(nickNameL,   		1, 0, 1, 1);
		add(nickNameTF,  		2, 0, 1, 1);
		
		Panel buttonPanel = new Panel();
		buttonPanel.add(loginB);
		
		add(buttonPanel, 		0, 1, 3, 1);
		
	}

	public void eventRegist() {
		
		loginB.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.changeCard(MainFrame.WAIT);
				
			}
		});
	}
}
