class ForMission {

	public static void main(String[] args) {
		

		//�� 1������ 5�� 
		for(int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//�� 5������ 1��
		for(int i = 5; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		//�� 00001 ���� 11111
		for(int i = 5; i >= 1; i--) {
			for (int j = 1; j < i; j++) {		//�����
				System.out.print(" ");
			}
			for (int j = 1; j <= (6-i); j++) {	//��
				System.out.print("*");
			}
			System.out.println();
		}

		//�� 11111 ���� 00001
		for(int i = 1; i <= 5; i++) {
			for (int j = 1; j < i; j++) {		//�����
				System.out.print(" ");
			}
			for (int j = 1; j <= (6-i); j++) {	//��
				System.out.print("*");
			}
			System.out.println();
		}

		//�Ƕ�̵�
		int stars = 11;
		for(int i = 1; i <= stars; ) {			 
			for(int j = (stars-i)/2; j > 0; j--) {
				System.out.print(" ");
			}
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
			i += 2;
		}

		//������
		for(int i = 2; i < 10; i++) {
			for(int j = 2; j < 10; j++) {
				System.out.print(i + " * " + j + " = " + (i * j) + "\t\t");
			}
			System.out.println();
		}

		
	}
}
