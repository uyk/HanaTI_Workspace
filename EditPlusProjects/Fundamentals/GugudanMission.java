class GugudanMission {

	static void printGugudan(int num) {
		for(int i = 1; i <= 9; i ++) {
			for (int j = 2; j <= num ; j++)	{
				System.out.print(j + " * " + i + " = " + (j * i) + "\t\t");
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		printGugudan(5);
		System.out.println();
		printGugudan(9);
	}
}
