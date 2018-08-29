import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;

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
		serverL = new Label("Server");
		serverTF = new TextField();
		inputTF = new TextField();
		connectB = new Button("Connect...");
		sendB = new Button("Send...");
		messageTA = new TextArea();
		userList = new List();
	}
	// 화면 배치
	public void setContents() {
		// 레이아웃매니저 교체
		//this.setLayout(new FlowLayout());
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
		
		
	}
	
	public static void main(String[] args) {
		ChatFrame frame = new ChatFrame("KoTalk");
		frame.setContents();
		frame.setSize(400, 500);
		frame.setVisible(true);
	}
}
