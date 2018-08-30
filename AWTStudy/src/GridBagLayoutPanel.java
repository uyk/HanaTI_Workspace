import java.awt.Button;
import java.awt.Component;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
//import java.awt.Insets;
import java.awt.Panel;

public class GridBagLayoutPanel extends Panel {
	Button button1, button2, button3;
	GridBagLayout gridBagLayout;
	GridBagConstraints gridBagConstraints;
	
	public GridBagLayoutPanel() {
		button1 = new Button("Button 1");
		button2 = new Button("Button 2");
		button3 = new Button("Button 3");
		gridBagLayout = new GridBagLayout();
		gridBagConstraints = new GridBagConstraints();
	}
	public void setContents() {
		setLayout(gridBagLayout);
		add(button1, 0, 0, 1, 1, 0, 0);
		add(button2, 1, 0, 1, 1, 1, 0);
		add(button3, 0, 1, 2, 1, 1, 1);

	}
	
	private void add(Component component, int gridx, int gridy, int gridwidth, int gridheight, 
			double weightx, double weighty) {
		gridBagConstraints.gridx = gridx;
		gridBagConstraints.gridy = gridy;
		gridBagConstraints.gridwidth = gridwidth;
		gridBagConstraints.gridheight = gridheight;
		
		gridBagConstraints.weightx = weightx;
		gridBagConstraints.weighty = weighty;

		gridBagConstraints.fill = GridBagConstraints.BOTH;	// 호리즌탈(가로채움), 버티컬(새로채움), BOTH(전체채움), NONE(디폴트)
		//gridBagConstraints.insets = new Insets(5, 5, 5, 5);			//마진
		gridBagLayout.setConstraints(component, gridBagConstraints);
		
		//super.add(component);
		add(component);
	
	}
	public static void main(String[] args) {
		Frame frame = new Frame("Grid Layout Exmaple");
		
		GridBagLayoutPanel panel = new GridBagLayoutPanel();
		panel.setContents();
		
		frame.add(panel);
//		frame.setSize(800,800);
		frame.pack();
		frame.setVisible(true);
		
	}
	
}
