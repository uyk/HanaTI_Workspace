/**
 * 자바 데이터 유형 테스트
 *
 *
 */


class DatatypeExample {
	public static void main(String[] args) {
		boolean flag = true;

		//boolean flag2 = 10;
		
		System.out.println(flag);

		char 한 = '\uD55C';
		char 글 = '\uAE00';
		System.out.println(한);
		System.out.println(글);

	
		//제어문자
		System.out.println("\t유예겸\n입\\\\니다.");
		System.out.println("\"자바\"가 좋다");

		// byte, short, int, long
		long money = 5000000;	// 500000를 int로 인식하지만 8바이트 long형으로 자동 형변환 수행. CPU 낭비
		long money2 = 5000000L;	// 자동 형변환이 필요 없으므로 권장됨.

		System.out.println(money);
		System.out.println(money2);
		System.out.printf("%c\n",100);	//데이터를 어떤 포멧으로 출력할지

		//float pi1 = 3.141592;
		float pi2 = 3.141592F;
		double pi3 = 3.141592;

		System.out.println(pi2);
		System.out.println(pi3);

		


		
	}
}
