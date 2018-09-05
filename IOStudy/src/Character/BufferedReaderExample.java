package Character;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class BufferedReaderExample {

	public static void main(String[] args) throws IOException{
		String path = "src/BufferedInputStreamExample.java";
		FileReader in = new FileReader(path);
	
//		char[] buffer = new char[1024];
//		int count = 0;
//		while( (count = in.read(buffer)) != -1 ) {
//			for (char c : buffer) {
//				System.out.print(c);
//			}
//		}
		
		BufferedReader br = new BufferedReader(in);
//		String txt = br.readLine();
//		System.out.println(txt);
		
		String txt = null;
		while( (txt = br.readLine()) != null) {
			//System.out.print(new LineNumberReader(in).getLineNumber());
			System.out.println(txt);
		}
	}

}
