package kr.or.kosta.boundary;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 계좌 관리 프로그램
 * 
 * MainFrame : 메인화면을 출력하는 클래스
 * 부모클래스 : Frame
 * 
 * @author 유예겸
 *
 */

public class MainFrame extends Frame {
// 인스턴스 메소드
	InputPanel inputPanel;
	//PrintPanel printPanel;
	
// 생성자
	/**
	 * 디폴트 생성자.
	 * inputPanel초기화, frame에 대한 기본적인 설정
	 */
	public MainFrame() {
		inputPanel = new InputPanel();

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				//finish();
				setVisible(false);
				dispose();
				System.exit(1);
			}
		});

		setContents();
		setSize(800,450);
		setVisible(true);
		setCenter();
		//printPanel = new PrintPanel();
	}
	
// 인스턴스 메소드
	/** 
	 * 프레임에 컴포넌트를 배치하는 메소드
	 */
	public void setContents() {
		add(inputPanel, BorderLayout.NORTH);
		//add(printPanel, BorderLayout.CENTER);
	}

	/**
	 * 프레임을 윈도우 중앙에 배치하는 메소드
	 */
	public void setCenter() {
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		System.out.println(dim);
		
		int x = (dim.width - this.getSize().width) / 2;
		int y = (dim.height - this.getSize().height) / 2;
		
		setLocation(x,y);
		
	}
	
// 테스트를 위한 메인	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame frame = new MainFrame();
	}
}
