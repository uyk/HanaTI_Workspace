/**
 * 제너릭 클래스
 * @author 유예겸
 *
 */
public class Student <T> {
	private String name;
	private T ssn;
	
	//생성자
	public Student() {
		
	}
	public Student(String name, T ssn) {
		this.name = name;
		this.ssn = ssn;
	}
	
	//setter getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public T getSsn() {
		return ssn;
	}
	public void setSsn(T ssn) {
		this.ssn = ssn;
	}
	
	public static void main(String[] args) {
		Student<Integer> student = new Student<Integer>("유예겸", 123456);	//오토박싱
		// Student<Integer> student = new Student("유예겸", 123456);
		student.setSsn(64896);
	}
	
}
