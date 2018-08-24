class MethodExample {

	static void printMessage(String name, String message) {
		System.out.println("[" + name + "] : " + message );
	}
	static int sum (int x, int y, int z) {
		return x + y + z;
	}

	public static void main(String[] args) {
		String name = "유예겸";
		String message = "쉬었다합시다";
		printMessage(name, message);

		int result = sum(50, 29, 19);
		System.out.println(result);
	}
}
