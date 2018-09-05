import java.io.IOException;

public class StandardInOutExample {

	public static void main(String[] args) throws IOException {
//		System.out.println(System.in);
//		System.out.println(System.out);
		System.out.print("당신의 이름 : ");
		
		byte[] buffer = new byte[100];
		int count = System.in.read(buffer);
		
		// 문자 디코딩
		String name = new String(buffer, 0, count - 2 );

		System.out.println("입력한 이름은 " + name + "입니다.");
		
		// 숫자
		System.out.print("당신의 나이 : ");
		count = System.in.read(buffer);
		String age = new String(buffer, 0, count-2);
		System.out.println(Integer.parseInt(age) + 10);
		

	}

}
