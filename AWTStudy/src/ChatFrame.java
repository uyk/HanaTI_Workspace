import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.Toolkit;

public class ChatFrame extends Frame {
	Label serverL;
	TextField serverTF, inputTF;
	Button connectB, sendB;
	TextArea messageTA;
	List userList;

	public ChatFrame() {
		this("이름없음");
	}
	public ChatFrame(String title) {
		super(title);
		serverL = new Label("서버");
		serverTF = new TextField();
		inputTF = new TextField();
		connectB = new Button("연결...");
		sendB = new Button("전송");
		messageTA = new TextArea();
		userList = new List();
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
	 
	public static void main(String[] args) {
		ChatFrame frame = new ChatFrame("KoTalk");
		frame.setContents();
		frame.setSize(400, 500);
		frame.setCenter();
		frame.setVisible(true);
	}
}
