import java.io.IOException;
import java.util.Scanner;

public class ScannerExample {
	public static void main(String[] args) throws IOException{
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("당신의 이름 : ");
		System.out.println(scanner.nextLine());

		// 숫자
		System.out.print("당신의 나이 : ");
		System.out.println(scanner.nextInt());
	}	
}
