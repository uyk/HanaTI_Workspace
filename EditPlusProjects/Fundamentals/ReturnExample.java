class ReturnExample {

	public static void main(String[] args) {
		System.out.println("프로그램 시작됨.........");
		
		for (int i = 0; i < 10 ; i ++) {
			System.out.println("XX");
			if( i == 5 ) return ;
		}
		System.out.println("프로그램 종료됨.........");

	}
}