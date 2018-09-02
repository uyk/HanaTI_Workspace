

public class TestClass {
	public static void main(String[] args) {
		final int size = 10;
		String s = "가나다";
		System.out.println(s.length());
		System.out.println(s.getBytes().length);
		String s2 = "가나다라a";
		System.out.println(s2.length());
		System.out.println(s2.getBytes().length);
		
		System.out.println(String.format("%-12s %14s %"+ (size + "유예겸".length()) +"s %,14d", "마이너스", "1111-2222-3333", "유예겸", 1000000L));
		System.out.println(String.format("%-14s %14s %"+ (size + "가나다라".length()) +"s %,14d", "입출금", "1111-2222-3333", "가나다라", 100000L));
		System.out.println(String.format("%-12s %14s %"+ (size + "사람".length()) +"s %,14d", "마이너스", "1111-2222-3333", "사람", 10000L));
		System.out.println(String.format("%-14s %14s %"+ (size) +"s %,14d", "입출금", "1111-2222-3333", "John Snow", 1000000L));
		System.out.println(String.format("%-14s %14s %"+ (size) +"s %,14d", "입출금", "1111-2222-3333", "ab", 10000L));
		System.out.println(String.format("%-12s %14s %"+ (size + "유예겸".length()) +"s %,14d", "마이너스", "1111-2222-3333", "유예겸", 100000L));
		System.out.println(String.format("%-14s %14s %"+ (size + "유예겸".length()) +"s %,14d", "입출금", "1111-2222-3333", "유예겸", 10L));
		System.out.println();
		System.out.println(String.format("%-12s %14s %"+ (size) +"s %,14d", "마이너스", "1111-2222-3333", "유예겸", 1000000L));
		System.out.println(String.format("%-14s %14s %"+ (size) +"s %,14d", "입출금", "1111-2222-3333", "가나다라", 100000L));
		System.out.println(String.format("%-12s %14s %"+ (size) +"s %,14d", "마이너스", "1111-2222-3333", "사람", 10000L));
		System.out.println(String.format("%-14s %14s %"+ (size + "John Snow".length()) +"s %,14d", "입출금", "1111-2222-3333", "John Snow", 1000000L));
		System.out.println(String.format("%-14s %14s %"+ (size + "ab".length()) +"s %,14d", "입출금", "1111-2222-3333", "ab", 10000L));
		System.out.println(String.format("%-12s %14s %"+ (size) +"s %,14d", "마이너스", "1111-2222-3333", "유예겸", 100000L));
		System.out.println(String.format("%-14s %14s %"+ (size) +"s %,14d", "입출금", "1111-2222-3333", "유예겸", 10L));

	}
}
