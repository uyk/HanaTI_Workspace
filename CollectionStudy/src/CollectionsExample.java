import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsExample {

	public static void main(String[] args) {
		List<Accounts> list = new ArrayList<>();
		
		list.add(new Accounts("9911", "유예겸", 1111, 999999));
		list.add(new Accounts("1564", "ㄷㄷㄷ", 1111, 1119));
		list.add(new Accounts("3564", "ㅂㅂㅂ", 1111, 15));
		
		System.out.println(list);
		Collections.sort(list, new NumberCompare());
		System.out.println(list);
		Collections.sort(list, new MoneyCompare());
		System.out.println(list);
	}

}
