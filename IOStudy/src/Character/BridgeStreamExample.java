package Character;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BridgeStreamExample {

	public static void main(String[] args) throws IOException {
//		System.out.println(System.in);
//		System.out.println(System.out);
		System.out.print("당신의 이름 : ");
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		byte[] buffer = new byte[100];
		int count = System.in.read(buffer);
		
		// 문자 디코딩
		String name = new String(buffer, 0, count - 2 );

		System.out.println("입력한 이름은 " + name + "입니다.");
		
		// 숫자
		System.out.print("당신의 나이 : ");
		count = System.in.read(buffer);
		String age = new String(buffer, 0, count-2);
		System.out.println(2018 - Integer.parseInt(age) + 1);
		

	}

}
