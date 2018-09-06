
public class Car extends Thread{
	//String name;
	
	public Car(String name) {
		//this.name = name;
		
	}
	public void run() {
		System.out.println(getName()+ "자동차가 시작");
		for(int i = 0; i <= 100; i++) {
			System.out.println(getName() + "자동차 : " + i + " 미터 전진");
		}
	}

}
