package graphics;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameFrame extends Frame {
	
	MyCanvas canvas;

	public GameFrame(String title) {
		super(title);
		canvas = new MyCanvas();
		add(canvas, BorderLayout.CENTER);
	}
	
	// 내부 클래스
	class MyCanvas extends Canvas implements MouseListener {
		Point point;

		MyCanvas() {
			addMouseListener(this);
		}
		
		public void paint(Graphics g) {
			System.out.println("paint() 호출됨");
			if (point != null) {
				int red = (int) (Math.random() * 256);
				int green = (int) (Math.random() * 256);
				int blue = (int) (Math.random() * 256);
				Color randomColor = new Color(red, green, blue);
				g.setColor(randomColor);
				g.fillOval(point.x, point.y, 50, 50);
			}
		}
		// 화면 지우기 기능을 없애기 위해 오버라이딩
		
		
		public void update(Graphics g) {
			//super.update(g);
			System.out.println("update() Called");
			paint(g);
		}
		
		public void mouseClicked(MouseEvent e) {
			point = e.getPoint();
			repaint();// 컴포넌트를 다시 그리기 위해 호출
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}

	public static void main(String[] args) {
		GameFrame f = new GameFrame("화면 갱신");
		f.setSize(600, 500);
		f.setVisible(true);

	}

}
