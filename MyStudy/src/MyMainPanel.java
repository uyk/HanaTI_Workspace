import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMainPanel extends Panel implements ActionListener{

	MyTalkFrame frame;
	Label label;
	Button button;
	
	public MyMainPanel(MyTalkFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
		label = new Label("This is a test!", Label.CENTER);
		button = new Button("LOGOUT");
		setContents();
		button.addActionListener(this);
	
	}
	public void setContents() {
		setLayout(new BorderLayout());
		add(label, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		frame.changeCard("LOGIN");
		
	}
	/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame = new Frame();
		//MyMainPanel panel = new MyMainPanel();
		
		//frame.add(panel);
		frame.setSize(400, 700);
		frame.setVisible(true);
	}*/

}
