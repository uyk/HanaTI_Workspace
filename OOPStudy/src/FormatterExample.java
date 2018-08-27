import java.util.Formatter;

public class FormatterExample {
	public static void main(String[] args) {
		int number = 1234567;
		
		Formatter formatter = new Formatter();
		String formatedString = null;
		
		formatedString = formatter.format("%d", number).toString();
		System.out.println(formatedString);
		
		formatter = new Formatter();
		System.out.println(formatter.format("%,+20d", number));
		
		String name = "유예겸";
		formatter = new Formatter();
		System.out.println(formatter.format("%10s", name));
	
		formatter = new Formatter();
		System.out.println(formatter.format("%o", 150));
		
		formatter = new Formatter();
		System.out.println(formatter.format("%x", 150));
		
		// 도스콘솔 전용
		System.out.printf("%,+-10d\n", 198745);
		System.out.printf("%1$,-10d와 %2$,10d\n", 1000, 2000);

		// String 클래스의 클래스메소드 활용
		String fs = String.format("%,20.2f\n", 198745.678);
		System.out.println(fs);

	}
}
