import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Random;

public class UserFrame extends Frame implements MouseListener, WindowListener{
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
	
	public void eventRegist() {
		eButton.addMouseListener(this);
		wButton.addMouseListener(this);
		sButton.addMouseListener(this);
		nButton.addMouseListener(this);
		cButton.addMouseListener(this);
		addWindowListener(this);
	}

	
	// MouseListener 인터페이스의 추상메소드 구현
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("마우스 클릭되었습니다.");
		Object eventSource = e.getSource();
		if(eventSource instanceof Button) {
			Button button = (Button)eventSource;
			Random random = new Random();
			int r = random.nextInt(255);
			int g = random.nextInt(255);
			int b = random.nextInt(255);
			button.setBackground(new Color(r, g, b));
			System.out.println("r : " + r + ", g : "+ g + ", b : "+ b);
		
		}
		if(eventSource == eButton) {
			System.out.println("eButton 클릭");
		}
		else if(eventSource == wButton) {
			System.out.println("wButton 클릭");
		}
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("mouseEntered Called");
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("mouseExited Called");
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("mousePressed Called");
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
//		System.out.println("mouseReleased Called");
	}
	
	// WindowListener 인터페이스의 추상메소드 구현

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("활성화");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		setVisible(false);
		dispose();			// os에 그래픽 리소스 반납
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("비활성화");
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("최소화 해제");
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("최소화");
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		System.out.println("창 열림");
	}

	public static void main(String[] args) {
		UserFrame frame = new UserFrame("User Frame Title");
		frame.setContents();
		frame.eventRegist();
		
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
}
