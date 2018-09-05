package Character;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

	public static void main(String[] args) throws IOException{
		String path = "example5.txt";
		String message = "배고프다..........";
		FileWriter out = new FileWriter(path);
		
		/*
		//char[] chars = new char[message.length()];
		char[] chars = new char[100];
		
		message.getChars(0, message.length(), chars, 0);
		out.write(chars);
		out.close();
		*/
		
		BufferedWriter bw = new BufferedWriter(out);
		bw.write(message);
		bw.close();

	}

}
