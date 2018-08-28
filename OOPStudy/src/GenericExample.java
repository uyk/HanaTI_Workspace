import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class GenericExample {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("유예겸");
		list.add("등등등");
		
		//list.add(Calendar.getInstance());	//String 아니라서 안됨
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {
			String name = it.next();
			System.out.println(name);
		}
		
		for (String string : list) {
			System.out.println(string);
		}
	}
}
