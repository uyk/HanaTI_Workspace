package io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamExample {
	static final String path = "example.dat";
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		OutputStream out = new FileOutputStream(path, false);
		//out.write(127);
		//out.close();
		
		byte[] buffer = new byte[128];
		for(int i = 0; i < buffer.length; i++) {
			buffer[i] = (byte)i;
		}
		out.write(buffer);
		System.out.println("파일에 128파이트 작성");

	}

}
