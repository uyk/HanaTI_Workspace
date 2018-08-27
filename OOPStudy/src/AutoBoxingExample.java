
public class AutoBoxingExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double obj = 999.999;
		System.out.println(obj.compareTo(1000.0));
		double value = new Double (16.9);
		double value2 = (new Double (16.9)).doubleValue();
		System.out.println(value);
		System.out.println(value2);

	}

}
