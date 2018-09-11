package kr.or.kosta.dva.client.boundary;

import java.awt.Dialog;
import java.awt.Frame;
import java.awt.List;
import java.awt.Panel;

import javax.swing.BoxLayout;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserListDialog extends Panel {
	public static void main(String[] args) {

		/*

		JTextField projnameField = new JTextField(10);
		JTextField nField = new JTextField(5);
		JTextField mField = new JTextField(5);
		JTextField alphaField = new JTextField(5);
		JTextField kField = new JTextField(5);

		JFileChooser inputfile = new JFileChooser();
		inputfile.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

		//File file = inputfile.getSelectedFile();
		//String fullpath = file.getAbsolutePath();

		JPanel myPanel = new JPanel();
	

		myPanel.add(new JLabel("Project Name:"));
		myPanel.add(projnameField);

		myPanel.add(new JLabel("Number of instances:"));
		myPanel.add(nField);

		myPanel.add(new JLabel("Number of attributes:"));
		myPanel.add(mField);

		myPanel.add(new JLabel("Alpha:"));
		myPanel.add(alphaField);

		myPanel.add(new JLabel("Number of patterns:"));
		//myPanel.add(kField);
//
		myPanel.add(new JLabel("Please select your datset:"));
		//myPanel.add(inputfile);

		myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
		*/
		//Frame frame = new Frame();
		//Dialog dialog= new Dialog(frame, "타이틀");
		
		List userList = new List();
		userList.add("유예겸");
		
		//frame.setSize(300, 500);
		//frame.setVisible(true);	
		
		
		//dialog.
		
		
		Panel myPanel = new Panel();
		myPanel.add(userList);

		//myPanel.add(userList);
		
		int ans = JOptionPane.showConfirmDialog(null, myPanel, "확인", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
		System.out.println("ans = " + ans); //예는 0, 아니오는 1을 리턴함
		//System.out.println(result);
	}
}
