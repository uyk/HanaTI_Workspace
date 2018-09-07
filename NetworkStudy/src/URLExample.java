import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JOptionPane;

public class URLExample {
	public static void main(String[] args) {
		String urlString = "https://blog.naver.com/the_trip/221347106112";
		try {
			URL url = new URL(urlString);
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			
			InputStream in = url.openStream();
			System.out.println(in);
			/*
			byte[] buffer = new byte[1024];
			int count = 0;
			while( (count = in.read(buffer)) != -1) {
				String text = new String(buffer);
				System.out.println(text);
			}
			*/
			
//			InputStreamReader isr = new InputStreamReader(in, "UTF-8");	//MS949로 하면 깨짐
			InputStreamReader isr = new InputStreamReader(in);
			BufferedReader br = new BufferedReader(isr);
			String txt = null;
			while( (txt = br.readLine()) != null) {
				System.out.println(txt);
			}
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(null, "서버를 찾을 수 없습니다..");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
