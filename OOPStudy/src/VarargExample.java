
public class VarargExample {

	public int sum(int[] args) {
		int result = 0;
		for (int i  : args) {
			result += i;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
