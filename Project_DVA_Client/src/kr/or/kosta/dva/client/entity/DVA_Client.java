package kr.or.kosta.dva.client.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DVA_Client extends Client {

	private String currentTime() {
		LocalDateTime DateTime = LocalDateTime.now();
		DateTimeFormatter formmat = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm:ss");
		return (formmat.format(DateTime));
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
