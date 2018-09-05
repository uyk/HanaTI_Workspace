package io;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Calendar;

public class PrintStreamExample {
	static  final String path = "example4.dat";
	
	public static void main(String[] args) throws IOException{
		boolean flag = false;
		char c = '김';
		int age = 30;
		double weight = 100.0;
		String message = "입출력 프로그램입니다";
		Calendar now = Calendar.getInstance();
		
		PrintStream out = new PrintStream(path);
		out.println(flag);
		out.println(c);
		out.println(age);
		out.println(weight);
		out.println(message);
		out.printf("%1$tF %1$tT", now);
		
		out.close();
		System.out.println("썼음");
	}

}
