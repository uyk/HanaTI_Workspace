import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamExample {
	static final String path = "C:\\KOSTA187\\설치프로그램\\staruml-5.0-with-cm.exe";

	public static void main(String[] args) {
		InputStream in = null;
		try {
			in = new FileInputStream(path);
			System.out.println(in.available());
			
//			int b = in.read();
//			System.out.println(b);
			
			int b = 0;
			while ( (b = in.read()) != -1) {
				System.out.println(b);
			}
			//in.close();		// 예외 발생하면 안닫힘
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
