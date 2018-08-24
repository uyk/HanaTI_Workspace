class OperatorExample {
	public static void main(String[] args) {
		
		int x = 50, y = 20;

		// 산술연산자
		System.out.println("결과 : " + x + y);
		System.out.println("결과 : " + (x + y));
		System.out.println("결과 : " + (x % y));	//나머지 연산

		// 복합대입연산자
		x += y;
		System.out.println("복합대입 : " + x);

		// 형변환연산자
		double weight = 78.12345;
		System.out.println(weight);
		System.out.println((int)weight);

		// 증감연산자
		x = 100;
		System.out.println(x++);
		System.out.println(x);
		System.out.println(++x);
		System.out.println("결과 : " + (x++) + " " + x);

		// 비트연산자
		x = 10;
		System.out.println(x * 2 * 2 * 2);
		System.out.println(x << 3);		//연산속도가 빠름

		// 조건삼항연산자
		int a = 5, b = 8, c = 4, max;

		max = (a > b) ? a : b;
		max = (max > c) ? max : c;
		System.out.println(max);

	}
}
