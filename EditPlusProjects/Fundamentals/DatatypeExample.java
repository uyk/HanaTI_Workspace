/**
 * �ڹ� ������ ���� �׽�Ʈ
 *
 *
 */


class DatatypeExample {
	public static void main(String[] args) {
		boolean flag = true;

		//boolean flag2 = 10;
		
		System.out.println(flag);

		char �� = '\uD55C';
		char �� = '\uAE00';
		System.out.println(��);
		System.out.println(��);

	
		//�����
		System.out.println("\t������\n��\\\\�ϴ�.");
		System.out.println("\"�ڹ�\"�� ����");

		// byte, short, int, long
		long money = 5000000;	// 500000�� int�� �ν������� 8����Ʈ long������ �ڵ� ����ȯ ����. CPU ����
		long money2 = 5000000L;	// �ڵ� ����ȯ�� �ʿ� �����Ƿ� �����.

		System.out.println(money);
		System.out.println(money2);
		System.out.printf("%c\n",100);	//�����͸� � �������� �������

		//float pi1 = 3.141592;
		float pi2 = 3.141592F;
		double pi3 = 3.141592;

		System.out.println(pi2);
		System.out.println(pi3);

		


		
	}
}
