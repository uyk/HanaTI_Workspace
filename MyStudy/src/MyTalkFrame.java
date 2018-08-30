import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Window;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyTalkFrame extends Frame implements WindowListener{
	
	Panel cardLayoutPanel;
	MyLoginPanel loginPanel;
	MyMainPanel mainPanel;
	CardLayout cardLayout;

	
	public MyTalkFrame() {
		// TODO Auto-generated constructor stub
		loginPanel = new MyLoginPanel(this);
		mainPanel = new MyMainPanel(this);
		
		cardLayoutPanel = new Panel();
		cardLayout = new CardLayout();
		
		setContents();
		//setCenter();
		addWindowListener(this);
	}
	

	
	public void setContents() {
		cardLayoutPanel.setLayout(cardLayout);

		cardLayoutPanel.add("LOGIN", loginPanel);
		cardLayoutPanel.add("MAIN", mainPanel);
		add(cardLayoutPanel, BorderLayout.CENTER);

	}
	
	
	
	////////////////////////////////////////////////////////////////////////??
	public void setCenter() {
		double x = Window.getWindows()[0].getSize().getWidth();
		double y = Window.getWindows()[0].getSize().getHeight();
		System.out.println(x + ", " + y);
		x = (x - this.getWidth()) / 2;
		y = (y - this.getWidth()) / 2;
		
		setLocation((int)x, (int)y);
		
	}
	
	public void changeCard(String name) {
		cardLayout.show(cardLayoutPanel, name);
	}
	
	///////////////////////////////////////////////////////////
	@Override
 	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(1);
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	///////////////////////////////////////////////////////////////////////
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyTalkFrame frame = new MyTalkFrame();
		frame.setSize(400,700);
		frame.setCenter();
		frame.setVisible(true);

	}

}
