class OperatorExample {
	public static void main(String[] args) {
		
		int x = 50, y = 20;

		// ���������
		System.out.println("��� : " + x + y);
		System.out.println("��� : " + (x + y));
		System.out.println("��� : " + (x % y));	//������ ����

		// ���մ��Կ�����
		x += y;
		System.out.println("���մ��� : " + x);

		// ����ȯ������
		double weight = 78.12345;
		System.out.println(weight);
		System.out.println((int)weight);

		// ����������
		x = 100;
		System.out.println(x++);
		System.out.println(x);
		System.out.println(++x);
		System.out.println("��� : " + (x++) + " " + x);

		// ��Ʈ������
		x = 10;
		System.out.println(x * 2 * 2 * 2);
		System.out.println(x << 3);		//����ӵ��� ����

		// ���ǻ��׿�����
		int a = 5, b = 8, c = 4, max;

		max = (a > b) ? a : b;
		max = (max > c) ? max : c;
		System.out.println(max);

	}
}
