package kr.or.kosta.dva.client.bin;

import kr.or.kosta.dva.client.boundary.MainFrame;
import kr.or.kosta.dva.client.entity.DvaClient;

public class DVA {

	public static void main(String[] args) {
		MainFrame frame = new MainFrame("::: DVA CHAT APP :::");
		frame.eventRegist();
		frame.setContents();
		frame.setSize(300, 500);
		frame.setResizable(false);
		frame.setCenter();
		frame.setVisible(true);	
		
		DvaClient dvaClient = new DvaClient(frame);
		
		frame.setClient(dvaClient);
		//ChatClient chatClient = new ChatClient(frame);
		
		//frame.setChatClient(chatClient);
	}

}
