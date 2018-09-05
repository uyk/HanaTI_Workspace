import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStreamExample {
	static final String path = "C:\\KOSTA187\\설치프로그램\\staruml-5.0-with-cm.exe";

	public static void main(String[] args) throws IOException{
		// Node Stream
		InputStream fin = null;
		fin = new FileInputStream(path);
		
		// Filter Stream		
		BufferedInputStream in = null;
		in = new BufferedInputStream(fin);		// 512바이트 배열
		in.mark(0);
		
		System.out.println(in.read());
		in.read();
		in.read();
		in.read();
		in.read();
		in.skip(20);	// 20바이트 건너뜀
		
		in.reset();
		System.out.println(in.read());
		
	}

}
