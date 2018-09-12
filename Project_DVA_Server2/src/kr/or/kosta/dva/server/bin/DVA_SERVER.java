package kr.or.kosta.dva.server.bin;

import java.io.IOException;

import kr.or.kosta.dva.server.boundary.MainFrame;
import kr.or.kosta.dva.server.entity.DvaServer;

/**
 * DVA 서버 프로그램 어플리케이션 클래스
 * @author 남수현
 */
public class DVA_SERVER {
	
	public static void main(String[] args) {
//		MainFrame frame = new MainFrame();
//		frame.setContents();
//		frame.setSize(1000, 700);
//		frame.setResizable(true);
//		frame.setCenter();
//		frame.setVisible(true);
//		서버 생성
		DvaServer dvaServer = new DvaServer();
//		dvaServer.setFrame(frame);
		try {
			//서버 구동
			dvaServer.startUp();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
