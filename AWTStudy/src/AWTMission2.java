import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AWTMission2 extends Panel implements WindowListener{
	
	Label recieverLabel, fileLabel, subjectLabel;
	TextField recieverTextField, fileTextField, subjectTextField;
	Button searchButton, sendButton, cancelButton;
	TextArea contentsTextArea;
	Panel topPanel, centerPanel, bottomPanel;

	GridBagLayout gridBagLayoutTop;
	GridBagConstraints gridBagConstraintsTop;

	
	public AWTMission2() {
		super();
		// TODO Auto-generated constructor stub
		
		recieverLabel = new Label("Reciever");
		fileLabel = new Label("File");
		subjectLabel = new Label("Subject");
	
		recieverTextField = new TextField(30);
		fileTextField = new TextField(30);
		subjectTextField = new TextField(60);
		
		searchButton = new Button("Search");
		sendButton = new Button("Send");
		cancelButton = new Button("Cancel");
		
		contentsTextArea = new TextArea();
		
		topPanel = new Panel();
		//centerPanel = new Panel();
		bottomPanel = new Panel();
		
		gridBagLayoutTop = new GridBagLayout();
		gridBagConstraintsTop = new GridBagConstraints();
	}
	
	public void setContents() {
		setLayout(new BorderLayout());
		topPanel.setLayout(gridBagLayoutTop);
		
		
		addToGridBag(recieverLabel,      0, 0, 1, 1, 0, 0);
		addToGridBag(recieverTextField,   1, 0, 2, 1, 1, 0);
		
		addToGridBag(fileLabel,      0, 1, 1, 1, 0, 0);
		addToGridBag(fileTextField,  1, 1, 2, 1, 1, 0);
		addToGridBag(searchButton,   3, 1, 1, 1, 0, 0);
		addToGridBag(new Label(),    4, 1, 1, 1, 1, 0);
		
		addToGridBag(subjectLabel,      0, 2, 1, 1, 0, 0);
		addToGridBag(subjectTextField,  1, 2, 5, 1, 1, 0);
		
		//centerPanel.add(contentsTextArea);
		
		bottomPanel.add(sendButton);
		bottomPanel.add(cancelButton);

		
		add(topPanel, BorderLayout.NORTH);
		//add(centerPanel, BorderLayout.CENTER);
		add(contentsTextArea, BorderLayout.CENTER);
		add(bottomPanel, BorderLayout.SOUTH);
		
		}
	private void addToGridBag(Component component,  int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty) {
		gridBagConstraintsTop.gridx = gridx;
		gridBagConstraintsTop.gridy = gridy;
		
		gridBagConstraintsTop.gridwidth = gridwidth;
		gridBagConstraintsTop.gridheight = gridheight;
		
		gridBagConstraintsTop.weightx = weightx;
		gridBagConstraintsTop.weighty = weighty;

		gridBagConstraintsTop.fill = GridBagConstraints.BOTH;	// 호리즌탈(가로채움), 버티컬(새로채움), BOTH(전체채움), NONE(디폴트)
		gridBagConstraintsTop.insets = new Insets(5, 5, 2, 2);			//마진
		gridBagLayoutTop.setConstraints(component, gridBagConstraintsTop);
		
		//super.add(component);
		topPanel.add(component);
	
	}
/*
	private void addToGridBag(Component component, Panel panel, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;

		gridBagConstraints.fill = GridBagConstraints.BOTH;	// 호리즌탈(가로채움), 버티컬(새로채움), BOTH(전체채움), NONE(디폴트)
		gridBagConstraints.insets = new Insets(5, 5, 2, 2);			//마진
		gridBagLayout.setConstraints(component, gridBagConstraints);
		
		//super.add(component);
		add(component);
	
	}
	*/
	
	private void addToGridBag(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty, Insets insets) {
		gridBagConstraintsTop.gridx = gridx;
		gridBagConstraintsTop.gridy = gridy;
		
		gridBagConstraintsTop.gridwidth = gridwidth;
		gridBagConstraintsTop.gridheight = gridheight;
		
		gridBagConstraintsTop.weightx = weightx;
		gridBagConstraintsTop.weighty = weighty;

		gridBagConstraintsTop.fill = GridBagConstraints.BOTH;	// 호리즌탈(가로채움), 버티컬(새로채움), BOTH(전체채움), NONE(디폴트)
		gridBagConstraintsTop.insets = insets;			//마진
		gridBagLayoutTop.setConstraints(component, gridBagConstraintsTop);
		
		//super.add(component);
		add(component);
	
	}
	
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
		setVisible(false);
		System.exit(0);
		
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


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Frame frame = new Frame("GridBagLayout Mission");
		AWTMission2 panel = new AWTMission2();
		
		panel.setContents();
		frame.add(panel);
		frame.setSize(800,500);
//		frame.pack();
		frame.setVisible(true);
		frame.addWindowListener(panel);
	}
}