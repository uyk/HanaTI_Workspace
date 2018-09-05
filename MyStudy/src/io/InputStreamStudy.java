package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamStudy {
	static final String path = "C:\\KOSTA187\\설치프로그램\\staruml-5.0-with-cm.exe";
	
	public static void main(String[] args) {
		InputStream in = null;
		try {
			
			in = new FileInputStream(path);
		
			System.out.println(in.available());
			
			int b = 0;
			while( ( b = in.read() ) != -1 ) {
				System.out.println(b);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
