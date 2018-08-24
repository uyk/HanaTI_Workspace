class BreakExample {

	public static void main(String[] args) {
		for(int i = 0; i < 10; i++) {
			if(i == 8) break;
			if(i == 2) continue;
			System.out.println("Ãâ·Â : " + i);
		}

		OUT:
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				System.out.println(i + ", " + j);
				if(j == 5) {
					break OUT;
				}
			}
		}
	}
}
