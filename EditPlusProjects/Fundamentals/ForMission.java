class ForMission {

	public static void main(String[] args) {
		

		//별 1개부터 5개 
		for(int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//별 5개부터 1개
		for(int i = 5; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		//별 00001 부터 11111
		for(int i = 5; i >= 1; i--) {
			for (int j = 1; j < i; j++) {		//빈공간
				System.out.print(" ");
			}
			for (int j = 1; j <= (6-i); j++) {	//별
				System.out.print("*");
			}
			System.out.println();
		}

		//별 11111 부터 00001
		for(int i = 1; i <= 5; i++) {
			for (int j = 1; j < i; j++) {		//빈공간
				System.out.print(" ");
			}
			for (int j = 1; j <= (6-i); j++) {	//별
				System.out.print("*");
			}
			System.out.println();
		}

		//피라미드
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

		//구구단
		for(int i = 2; i < 10; i++) {
			for(int j = 2; j < 10; j++) {
				System.out.print(i + " * " + j + " = " + (i * j) + "\t\t");
			}
			System.out.println();
		}

		
	}
}
