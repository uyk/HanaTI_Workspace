import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JOptionPane;

public class InputStreamExample2 {
	static final String path = "C:\\KOSTA187\\설치프로그램\\staruml-5.0-with-cm.exe";

	public static void main(String[] args) {
		InputStream in = null;
		File file = new File(path);
		if(!file.exists()) {
			JOptionPane.showMessageDialog(null, "no file");
			return;
		}
		try {
			in = new FileInputStream(path);
			System.out.println(in.available());

			// byte[](버퍼)단위로 입력
			byte[] buffer = new byte[4*1024];
			//int count= in.read(buffer);		// 읽은 크기(0 ~ 4*1024)
			/* 개념잡기위해 해본 것
			System.out.println(count);
			for (byte b : buffer) {
				System.out.println(b);
			}
			*/
			int count = 0;
			//int totalCount = 0;
			while( (count = in.read(buffer)) != -1) {
				System.out.println(count);
				//totalCount += count;
			}
			System.out.println(in.available());
			//System.out.println(totalCount() + " 바이트 파일 읽기 끝");
			System.out.println(file.length() + " 바이트 파일 읽기 끝");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(in != null) 	in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
