package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample2 {
	static final String path = "C:\\KOSTA187\\설치프로그램\\staruml-5.0-with-cm.exe";
	
	public static void main(String[] args) {
		InputStream in = null;
		
		try {
			in = new FileInputStream(path);
			System.out.println(in.available());
			
			byte[] buffer = new byte[ 4 * 1024 ];
			//int count = in.read(buffer);
			//System.out.println(count);
			//for(byte b : buffer) 
			//	System.out.println(b);
			
			int count = 0;
			while ( (count = in.read(buffer)) != -1) {
				System.out.println(count);
				
			}
		} catch (IOException e){
			
		}
	}
}
