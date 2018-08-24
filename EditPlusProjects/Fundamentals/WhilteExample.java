class WhilteExample {

	public static void main(String[] args) {
		int i = 0; 

		while(i++ < 10) {
			System.out.println("코스타 187기 화이팅");
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
		
		System.out.println("합 : " + sum);
		System.out.println("홀수합: " + oddSum);
		//System.out.println("짝수합: " + evenSum);
		System.out.println("짝수합: " + (sum - oddSum));

		
	}
}