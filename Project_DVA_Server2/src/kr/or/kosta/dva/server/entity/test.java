package kr.or.kosta.dva.server.entity;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "가,나,다,라,마,바,사";
		String[] spleited = test.split(",",3);
		for (String string : spleited) {
			System.out.println(string);
		}

		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm:ss");
		System.out.println(formmat1.format(ldt));
	}

}
