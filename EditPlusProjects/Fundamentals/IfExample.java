import java.util.Scanner;

class IfExample {

	public static void main(String[] args) {
		int score = 99;
		if(score < 100)
			System.out.println(score);
		if(score >= 60) {
			System.out.println("ÇÕ°Ý");
		}
		else {
			System.out.println("ºÒÇÕ°Ý");
		}

		if(score % 2 == 0)  {
			System.out.println("Â¦¼ö");

		}
		else {
			System.out.println("È¦¼ö");
		}

		String isOdd = ((score % 2 ) == 0) ? "Â¦¼ö" : "È¦¼ö";
		System.out.println(isOdd);

		System.out.print("Á¡¼ö : ");
		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt();

		if(score >= 90) {
			System.out.println("¼ö");
		}else if(score >= 80) {
			System.out.println("¿ì");
		}else if(score >= 70 ) {
			System.out.println("¹Ì");
		}else if(score >= 60 ) {
			System.out.println("¾ç");
		}else {
			System.out.println("°¡");
		}
		

	}
}
