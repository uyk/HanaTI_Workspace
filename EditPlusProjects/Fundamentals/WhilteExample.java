class WhilteExample {

	public static void main(String[] args) {
		int i = 0; 

		while(i++ < 10) {
			System.out.println("�ڽ�Ÿ 187�� ȭ����");
			//i++;
		}

		i = 1;
		int sum = 0, oddSum = 0;
		//int evenSum = 0;

		while(i <= 100) {
			sum += i;
			if(i % 2 == 1 ) oddSum += i;
			//else evenSum += i;
			i++;
		}
		System.out.println(sum);
		
		System.out.println("�� : " + sum);
		System.out.println("Ȧ����: " + oddSum);
		//System.out.println("¦����: " + evenSum);
		System.out.println("¦����: " + (sum - oddSum));

		
	}
}