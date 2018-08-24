
public class Dog extends Animal {
	
	private boolean loyalty; 
	
	public Dog() {
		this(null, 0, false);
	}
	
	public Dog(String name, int age, boolean loyalty) {
		this.name = name;
		this.age = age;
		this.loyalty = loyalty;
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("강아지가 먹습니다.");

	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("강아지가 잡니다.");

	}
	public static void main(String[] args) {
		Animal animal = null;
		animal = new Dog("루니", 2, false);
		animal.printinf();
		animal.sleep();
		animal.eat();
	}

}
