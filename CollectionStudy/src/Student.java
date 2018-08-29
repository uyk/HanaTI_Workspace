import java.util.HashMap;
import java.util.Map;

public class Student {
	Map<String, Object> prop;

	
	// 생성자
	public Student() {
		super();
		prop = new HashMap<>();
	}

	// Getter, Setter
	public Map<String, Object> getProp() {
		return prop;
	}


	public void setProp(Map<String, Object> prop) {
		this.prop = prop;
	}
	
	// 인스턴스 메소드
	public void setProperty(String key, Object Value) {
		
	}
	
	public Object getProperty(String key) {
		return prop.get(key);
	}
	
	
	public static void main(String[] args) {
		Student student1 = new Student();		
		student1.setProperty("ssn", "2013136074");
		student1.setProperty("name", "유예겸");
		
		Student student2 = new Student();		
		student2.setProperty("ssn", "2013136077");
		student2.setProperty("name", "ㅂㅂㅂ");
		student2.setProperty("address", "인천시");
	}
}
