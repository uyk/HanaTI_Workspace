
public class StringExample {

	public static void main(String[] args) {
		// 명시적 생성
		String str1 = new String("Java Programming");
		String str2 = new String("Java Programming");
		// 레퍼런스 비교
		if (str1 == str2) {
			System.out.println("레퍼런스 같다.");
		} else {
			System.out.println("레퍼런스 다르다.");
		}
		// 묵시적 생성
		String str3 = "Java Programming";
		String str4 = "Java Programming";
		// 레퍼런스 비교
		// 문자열 상수를 이용한 생성시 StringPool에서
		// 검색 후 존재하지 않을 경우 새로 생성
		if (str3 == str4) {
			System.out.println("레퍼런스 같다.");
		} else {
			System.out.println("레퍼런스 다르다.");
		}
		System.out.println(str1 == str3);

		// 주요 메소드
		String message = "Java Programming";
		System.out.println(message.substring(5));
		System.out.println("Java Programming".substring(5, 8));

		System.out.println("유예겸".concat("!!"));
		System.out.println("JavaJava".replace('J', 'K'));
		System.out.println("java".replaceAll("ja", "JTT"));

		String ssn = "940907-2222123";
		int index = ssn.indexOf('-') + 1;
		char c = ssn.charAt(index);

		switch (c) {
		case '1':
			System.out.println("2000년 이전 출생 남자");
			break;
		case '2':
			System.out.println("2000년 이전 출생 여자");
			break;
		case '3':
			System.out.println("2000년 이후 출생 남자");
			break;
		case '4':
			System.out.println("2000년 이후 출생 여자");
			break;
		default:
			System.out.println("외국인");
			break;
		}
		System.out.println("\t\t         dfsdf          djfsjdfljl\t\tdsfsdf.   ".trim());
		int num = 10032534;
		System.out.println(String.valueOf(num));
	}

}
