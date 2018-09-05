package io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedInputStream;

public class BufferedInputStreamExample {
	static final String path = "C:\\KOSTA187\\설치프로그램\\staruml-5.0-with-cm.exe";
	
	public static void main(String[] args) throws IOException {
		InputStream fin = null;
		fin = new FileInputStream(path);
		
		BufferedInputStream in = null;
		in = new BufferedInputStream(fin);
		
		
		
		in.read();
		in.read();
		in.read();
		in.mark(0);
		System.out.println(in.read());
		in.read();
		in.skip(50);	// 20바이트 건너뜀
		
		in.reset();
		System.out.println(in.read());
		
	}

}
