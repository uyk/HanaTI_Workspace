import java.util.Scanner;

class IfExample {

	public static void main(String[] args) {
		int score = 99;
		if(score < 100)
			System.out.println(score);
		if(score >= 60) {
			System.out.println("�հ�");
		}
		else {
			System.out.println("���հ�");
		}

		if(score % 2 == 0)  {
			System.out.println("¦��");

		}
		else {
			System.out.println("Ȧ��");
		}

		String isOdd = ((score % 2 ) == 0) ? "¦��" : "Ȧ��";
		System.out.println(isOdd);

		System.out.print("���� : ");
		Scanner scanner = new Scanner(System.in);
		score = scanner.nextInt();

		if(score >= 90) {
			System.out.println("��");
		}else if(score >= 80) {
			System.out.println("��");
		}else if(score >= 70 ) {
			System.out.println("��");
		}else if(score >= 60 ) {
			System.out.println("��");
		}else {
			System.out.println("��");
		}
		

	}
}
