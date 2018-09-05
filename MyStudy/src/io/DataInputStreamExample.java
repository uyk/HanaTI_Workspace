package io;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInputStreamExample {
	static final String path = "example3.dat";
	
	public static void main(String[] args) throws IOException{
		boolean flag = false;
		char c = 0;
		int age = 0;
		double weight = 0;
		String message = null;
		
		DataInputStream in = new DataInputStream(new FileInputStream(path));
		flag = in.readBoolean();
		c = in.readChar();
		age = in.readInt();
		weight = in.readDouble();
		message = in.readUTF();
		
		in.close();
		System.out.println(flag + "," + c + "," + age + "," + weight + "," + message);
		System.out.println("썼음");
		
	}

}
