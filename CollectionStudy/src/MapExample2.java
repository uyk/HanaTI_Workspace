import java.util.Enumeration;
import java.util.Hashtable;

public class MapExample2 {

	public static void main(String[] args) {
		Hashtable<String, Accounts> table = new Hashtable<>();
		Accounts account1 = new Accounts("1111", "유예겸", 1111, 100000);
		Accounts account2 = new Accounts("2222", "ㅇㅇㅇ", 1111, 100000);
		
		table.put(account1.getAccountNum(), account1);
		table.put(account2.getAccountNum(), account2);
		
		System.out.println(table.get("1111"));
		
		Enumeration <String> e = table.keys();
		while (e.hasMoreElements()) {
			String string = e.nextElement();
			System.out.println(string);
		}
		System.out.println(table);
		Enumeration<Accounts> e2 = table.elements();
		while(e.hasMoreElements()) {
			Accounts a = e2.nextElement();
			System.out.println(a);
		}
	}

}
