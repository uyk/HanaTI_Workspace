import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyLoginPanel extends Panel implements ActionListener{
	MyTalkFrame frame;
	Label emailL,pwL;
	TextField emailTF, pwTF;
	Button loginB, registB;
	Panel buttonPanel;
	
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	public MyLoginPanel(MyTalkFrame frame) {
		this.frame = frame;
		emailL = new Label("EMAIL");
		pwL = new Label("PASSWD");
		emailTF = new TextField();
		pwTF = new TextField();
		loginB = new Button("LOGIN");
		registB = new Button("REGIST");
		
		buttonPanel = new Panel();
		
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
		
		setContents();
		loginB.addActionListener(this);
	}
	
	public void setContents() {
		setLayout(gridBagLayout);
		addToGridBag(emailL, 		0, 0, 1, 1, 0, 0);
		addToGridBag(emailTF, 		1, 0, 1, 1, 1, 0);
		addToGridBag(new Label(""), 2, 0, 1, 1, 0, 0);
		addToGridBag(pwL, 0, 1, 1, 1, 0, 0);
		addToGridBag(pwTF, 1, 1, 1, 1, 1, 0);
		
		buttonPanel.add(loginB);
		buttonPanel.add(registB);
		addToGridBag(buttonPanel, 0, 2, 3, 1, 1, 0);
		
	}
	
	private void addToGridBag(Component component,  int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;

		gridBagConstraints.fill = GridBagConstraints.BOTH;	// 호리즌탈(가로채움), 버티컬(새로채움), BOTH(전체채움), NONE(디폴트)
		gridBagConstraints.insets = new Insets(5, 20, 2, 2);			//마진
		gridBagLayout.setConstraints(component, gridBagConstraints);
		
		//super.add(component);
		add(component);
	
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println("login");
		frame.changeCard("MAIN");
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame = new Frame();
		//MyLoginPanel panel = new MyLoginPanel();
		//frame.add(panel);
		frame.setSize(400, 700);
		frame.setVisible(true);

	}


}
