import java.util.Scanner;

class IfExample {

	public static void main(String[] args) {
		int score = 99;
		if(score < 100)
			System.out.println(score);
		if(score >= 60) {
			System.out.println("м問");
		}
		else {
			System.out.println("碳м問");
		}

		if(score % 2 == 0)  {
			System.out.println("礎熱");

		}
		else {
			System.out.println("�汝�");
		}

		String isOdd = ((score % 2 ) == 0) ? "礎熱" : "�汝�";
		System.out.println(isOdd);

		System.out.print("薄熱 : ");
		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt();

		if(score >= 90) {
			System.out.println("熱");
		}else if(score >= 80) {
			System.out.println("辦");
		}else if(score >= 70 ) {
			System.out.println("嘐");
		}else if(score >= 60 ) {
			System.out.println("曄");
		}else {
			System.out.println("陛");
		}
		

	}
}
