import java.util.Date;

public class DateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Date today = new Date();
		System.out.println(today.toString());
		System.out.println(today.toLocaleString());
		
		System.out.println(today.getTime());

	}

}
