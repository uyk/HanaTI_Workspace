
public abstract class Animal {
	protected String name;
	protected int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public void printinf() {
		System.out.println("이름 : " + name + ", " + "나이 : " + age);
	}
	
	//추상메소드
	public abstract void eat();
	public abstract void sleep();
}
