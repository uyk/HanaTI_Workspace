package io;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamExample {
	static final String path = "example2.dat";

	public static void main(String[] args) throws IOException{
		FileOutputStream fos = new FileOutputStream(path);
		BufferedOutputStream out = new BufferedOutputStream(fos);
		
		byte[] data = {5,6,7,8,9};
		
		out.write(10);
		out.write(20);
		out.write(data);
		out.flush();
		System.out.println("끝");

	}

}
