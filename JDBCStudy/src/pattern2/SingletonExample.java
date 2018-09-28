package pattern2;

import java.io.IOException;

public class SingletonExample {

	public static void main(String[] args) {
		Logger logger = Logger.getInstance();
		logger.log("테스트");
		
		try {
			Runtime.getRuntime().exec("C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe https://www.naver.com");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
