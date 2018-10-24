package kr.or.kosta.jsp.el;

public class Student {
	private String name;
	private Dog dog;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", dog=" + dog + "]";
	}
}
