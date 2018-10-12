import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
	static {
		String path = "config.properties";
		
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream(path));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		prop.put("last", "lastValue");
		System.out.println(prop.getProperty("name1"));
	}
	public static void main(String[] args) throws FileNotFoundException, IOException {
		System.out.println("프로그램 시작");
	}
}
