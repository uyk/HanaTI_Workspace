
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameFrame extends Frame implements Runnable{
	int x = 50, distance = 5;
	Toolkit toolkit;
	Image unit;
	
	public GameFrame(String title) {
		super(title);
		toolkit = Toolkit.getDefaultToolkit();
		unit = toolkit.createImage("C:\\KOSTA187\\res\\if_cat_sleep_185528.png");
	}
	public void setContents() {
	
		
	}
	
	public void eventRegist() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				gameStart();
			}
		});
	}

	public void gameStart() {
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void paint(Graphics g) {
		//super.paint(g);
		
		g.drawImage(unit, x, 50, this);
		toolkit.beep();
		System.out.println("paint called");
	}
	
	@Override
	public void repaint() {
		super.repaint();
	}

	@Override
	public void run() {
		Random random = new Random();
		while(true) {
			x += distance;
			repaint();
			try {
				Thread.sleep(random.nextInt(200)); 
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}	
}
