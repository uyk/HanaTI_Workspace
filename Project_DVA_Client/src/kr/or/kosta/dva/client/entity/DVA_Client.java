package kr.or.kosta.dva.client.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DVA_Client extends Client{

	 private String currentTime() {
		 
	       Date today = new Date();
	       System.out.println(today);
	       SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd a hh:mm:ss");
	       return format.format(today);
	 }
	 
	@Override
	protected void recieveMessage() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void sendMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void process(String message) {
		// TODO Auto-generated method stub
		
	}

}
