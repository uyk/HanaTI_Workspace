
public class Mission {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Accounts account1 = new Accounts("1111-2222-3333", "유예겸", 1234, 1000000);
		Accounts account2 = new Accounts("1111-2222-3333", "유예겸", 1234, 1000000);
		
		System.out.println(account1 == account2);
		System.out.println(account1.equals("Java"));
		System.out.println(account1.equals(account2));
		
	}

}
