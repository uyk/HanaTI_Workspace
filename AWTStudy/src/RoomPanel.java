import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RoomPanel extends Panel implements ActionListener{
	
	TalkFrame frame;
	Label tempL;
	Button logoutB;
	
	public RoomPanel() {
		this(new TalkFrame());
	}
	public RoomPanel(TalkFrame frame) {
		this.frame = frame;
		tempL = new Label("This is Test Panel", Label.CENTER);
		logoutB = new Button("LOGOUT");
		setContents();
	}
	
	public void setContents() {
		setLayout(new BorderLayout());
		Panel panel = new Panel();
		panel.add(logoutB);
		
		add(tempL, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		logoutB.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("AA");
		frame.changeCard("LOGIN");
	}
	
	public static void main(String[] args) {
		Frame frame = new Frame("메인화면");
		RoomPanel mainPanel = new RoomPanel();
		
		frame.add(mainPanel);
		frame.setSize(300, 500);
		frame.pack();
		frame.setVisible(true);
	}


}
