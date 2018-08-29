import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;

public class UserFrame extends Frame {
	Button nButton, eButton, wButton, sButton, cButton;

	public UserFrame() {
		this("이름없음");
	}
	public UserFrame(String title) {
		super(title);
		this.eButton = new Button("EAST");
		this.wButton = new Button("WEST");
		this.sButton = new Button("SOUTH");
		this.nButton = new Button("NORTH");
		this.cButton = new Button("CENTER");
	}
	// 화면 배치
	public void setContents() {
		// 레이아웃매니저 교체
		this.setLayout(new FlowLayout());
		add(eButton, BorderLayout.EAST);
		add(wButton, BorderLayout.WEST);
		add(sButton, BorderLayout.SOUTH);
		add(nButton, BorderLayout.NORTH);
		add(cButton, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		UserFrame frame = new UserFrame("User Frame Title");
		frame.setContents();
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
}
