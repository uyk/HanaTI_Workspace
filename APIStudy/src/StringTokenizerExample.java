import java.util.StringTokenizer;

public class StringTokenizerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String date = "2018-08-23";
		String num = "1111 2222 3333 4444";
		
		StringTokenizer str = new StringTokenizer(date, "-");
		StringTokenizer str2 = new StringTokenizer(num);
		System.out.println(str.countTokens());
		
		while(str.hasMoreTokens()) {
			String token = str.nextToken();
			System.out.println(token);
		}
		while(str2.hasMoreTokens()) {
			String token = str2.nextToken();
			System.out.println(token);
		}

	}

}
