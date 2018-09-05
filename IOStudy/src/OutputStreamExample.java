
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamExample {
	static final String path = "example.dat";

	public static void main(String[] args) throws IOException {
		// true : 뒤에 추가(덮어씀x)
		OutputStream out = new FileOutputStream(path, false);
//		out.write(65);
//		out.close();
//		System.out.println("파일에 1바이트 씀");
		
		byte[] buffer = new byte[128];
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = (byte)i;
			
		}
		//out.write(buffer, 0, buffer.length);
		out.write(buffer);
		System.out.println("파일에 128바이트 작성");
	}

}
