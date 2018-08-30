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

public class LayoutPractice extends Panel implements WindowListener{
   Label receiverl, attachmentl, titlel;
   Button findb, sendb, cancelb;
   TextField receiveTF, attatchmentTF, titleTF;
   TextArea contTA;
   
   GridBagLayout gridBagLayout;
   GridBagConstraints gridBagConstraints;
   Panel buttonPanel;
   
   public LayoutPractice() {
      receiverl = new Label("받는사람");
      attachmentl = new Label("첨부파일");
      titlel = new Label("제  목");
      
      findb = new Button("찾  기");
      sendb = new Button("보내기");
      cancelb = new Button("취  소");
      
      receiveTF = new TextField();
      attatchmentTF = new TextField();
      titleTF = new TextField();
      
      contTA = new TextArea();
      buttonPanel = new Panel();
      
      gridBagLayout = new GridBagLayout();
      gridBagConstraints = new GridBagConstraints();
   }
   
   public void setContents() {
      setLayout(gridBagLayout);
      
      addPanel(receiverl,      0, 0, 1, 1, 0, 0);
      addPanel(receiveTF,      1, 0, 1, 1, 0, 0);
    //  addPanel(new Label(" "), 2, 0, 1, 1, 0, 0);
      
      addPanel(attachmentl,    0, 1, 1, 1, 0, 0);
      addPanel(attatchmentTF,  1, 1, 1, 1, 1, 0);
      addPanel(findb,          3, 1, 1, 1, 0, 0);
      addPanel(new Label(" "), 4, 1, 1, 1, 1, 0);
      
      addPanel(titlel, 0, 2, 1, 1, 0,   0);
      addPanel(titleTF, 1, 2, 4, 1, 1, 0);
      
      addPanel(contTA, 0, 3, 5, 1, 1, 1);
      
      
      //addPanel(new Label(" "), 0, 4, 1, 1, 1, 1);
      buttonPanel.add(sendb);
      buttonPanel.add(cancelb);
      addPanel(buttonPanel, 0, 4, 5, 1, 0, 0);
      
//      addPanel(sendb, 1, 4, 1, 1, 0, 1);
//      addPanel(cancelb, 2, 4, 1, 1, 0, 1);
//      addPanel(new Label(" "), 3, 4, 1, 1, 1, 1);
      
   }
   
   private void addPanel(Component component, int gridx, int gridy, int gridwidth, int gridheight, double weightx, double weighty) {
      //시작
      gridBagConstraints.gridx = gridx; 
      gridBagConstraints.gridy = gridy;
      gridBagConstraints.gridwidth=gridwidth;
      gridBagConstraints.gridheight=gridheight;
      gridBagConstraints.weightx=weightx;
      gridBagConstraints.weighty=weighty;
      
      gridBagConstraints.fill = gridBagConstraints.BOTH;  //가중치 줘야 적용
      //gridBagConstraints.insets = new Insets(5, 5, 5, 5);
      
      gridBagLayout.setConstraints(component, gridBagConstraints);
      add(component);
   }
   
   public static void main(String[] args) {
      Frame frame = new Frame("gridBag Practice :D");
      
      LayoutPractice panel = new LayoutPractice();
      panel.setContents();
      frame.add(panel);
      frame.setSize(600, 400);;
      frame.setVisible(true);

		frame.addWindowListener(panel);
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
   
   
}