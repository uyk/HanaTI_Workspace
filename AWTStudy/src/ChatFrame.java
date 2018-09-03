import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

public class ChatFrame extends Frame {
	Label serverL;
	TextField serverTF, inputTF;
	Button connectB, sendB;
	TextArea messageTA;
	List userList;
	
	MenuBar menuBar;
	Menu menu;
	MenuItem newMI, exitMI;

	public ChatFrame() {
		this("이름없음");
	}
	public ChatFrame(String title) {
		super(title);
		serverL = new Label("서버");
		serverTF = new TextField();
		inputTF = new TextField();
		connectB = new Button("연결...") {
			@Override
			public void paint(Graphics g) {
				g.drawLine(10, 10, 50, 50);
			}
		};
		sendB = new Button("전송");
		messageTA = new TextArea();
		userList = new List();
		
		userList.add("말미잘");
		userList.add("꼴뚜기");
		userList.add("머저리");
		userList.add("날라리");
		
		menuBar = new MenuBar();
		menu = new Menu("File");
		newMI = new MenuItem("New");
		newMI.setShortcut(new MenuShortcut(KeyEvent.VK_1));;
		exitMI = new MenuItem("Exit");
		exitMI.setShortcut(new MenuShortcut(KeyEvent.VK_2));
	}
	// 화면 배치
	public void setContents() {
		// 레이아웃매니저 교체
		//this.setLayout(new FlowLayout());

//		connectB.setBackground(new Color(199, 230, 122));
//		connectB.setForeground(Color.RED);
//		sendB.setBackground(Color.BLUE);
		connectB.setFont(new Font("나눔명조", Font.BOLD, 20));
		
		Panel northP = new Panel();
		northP.setLayout(new BorderLayout());
		northP.add(serverL, BorderLayout.WEST);
		northP.add(serverTF, BorderLayout.CENTER);
		northP.add(connectB, BorderLayout.EAST);
		
		Panel southP = new Panel();
		southP.setLayout(new BorderLayout());
		southP.add(inputTF, BorderLayout.CENTER);
		southP.add(sendB, BorderLayout.EAST);
		
		add(northP, BorderLayout.NORTH);
		add(messageTA, BorderLayout.CENTER);
		add(userList, BorderLayout.EAST);
		add(southP, BorderLayout.SOUTH);
		
//		setColorAll(Color.BLUE);
		
		setLocation(100, 100);
		setMenuBar(menuBar);
		menuBar.add(menu);
		menu.add(newMI);
		menu.addSeparator();
		menu.add(exitMI);
		
	}
	public void setCenter() {
//		Runtime.getRuntime().exec(command);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(dim);
		
		int x = (dim.width - this.getSize().width) / 2;
		int y = (dim.height - this.getSize().height) / 2;
		
		setLocation(x,y);
		
	}
	
	private void setColorAll(Color bg) {
		Component[] components = getComponents();
		for (Component component : components) {
			if(component instanceof Panel) {
				Component[] cs = ((Panel) component).getComponents();
				for (Component c : cs) {
					c.setBackground(bg);
				}
			}
			component.setBackground(bg);
		}
	}
	
	public void finish() {
		setVisible(false);
		dispose();
		System.exit(1);
	}
	
	public void appendMessage() {
		String message = inputTF.getText();
		messageTA.append("\n" + message);
		inputTF.setText("");
	}
	public void eventRegist() {
		/* 이름있는 지역 내부 클래스*/
		/*
		class Exiter extends WindowAdapter{
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		}
		addWindowListener(new Exiter());
		*/
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		inputTF.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				appendMessage();
			}
		});
		serverTF.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				System.out.println(KeyEvent.VK_K);
				System.out.println(KeyEvent.VK_ENTER);				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		inputTF.addTextListener(new TextListener() {
			
			@Override
			public void textValueChanged(TextEvent e) {
				// TODO Auto-generated method stub
				System.out.println(inputTF.getText());
			}
		});
		userList.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String name = userList.getSelectedItem();
//					JOptionPane.showMessageDialog(null, name + "님 선택", "알림", JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(null, name + "님 선택", "알림", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		
		exitMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				finish();
				
			}
		});
		
	}
	
	
	/** 멤버 내부 클래스를 이용한 이벤트 처리
	 * 
	 * @param args
	 */
	/*
	class Exiter extends WindowAdapter{
		@Override
		public void windowClosing(WindowEvent e) {
			finish();
		}
	}
	*/
	 
	public static void main(String[] args) {
		ChatFrame frame = new ChatFrame("KoTalk");
		frame.setContents();
		frame.setSize(400, 500);
		frame.setCenter();
		frame.eventRegist();
		frame.setVisible(true);
	}
}
