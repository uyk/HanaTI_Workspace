import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new TreeSet<String>();
		set.add("유예겸");
		set.add("ㅁㅁㅁ");
		set.add("eee");
		set.add("ㄱㄱㄱ");
		
		for(String string : set) {
			System.out.println(string);
		}
	}

}
