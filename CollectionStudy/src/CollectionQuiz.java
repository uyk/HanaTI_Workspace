import java.util.HashSet;
import java.util.Set;

/**
 * Accounts 인스턴스를 저장하는 집합 set
 * 동일한 계좌번호를 가진 Accounts 인스턴스를 add 못하게 하기
 * Object 메소드를 이용
 * 
 * @author 유예겸
 *
 */
public class CollectionQuiz {

	public static void main(String[] args) {
		Set<Accounts> set = new HashSet<>();
		set.add(new Accounts("1111", "유예겸", 1111, 999999));
		set.add(new Accounts("1564", "ㄷㄷㄷ", 1111, 999999));
		set.add(new Accounts("1564", "ㄷㄷㄷ", 1111, 999999));
		
		System.out.println("aaa".hashCode());
		System.out.println("bbb".hashCode());

		
		System.out.println(set.size());
		
		
		Student s1 = new Student();
		Student s2 = new Student();
		
		System.out.println(s1);
		System.out.println(s2);
		
	}

}
