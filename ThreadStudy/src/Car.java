import java.util.Random;

public class Car extends Thread{
	//String name;
	
	public Car(String name) {
		//this.name = name;
	
	}
	
	public void run() {
		Random random = new Random();
		System.out.println(getName()+ "자동차가 시작");
		for(int i = 0; i <= 50; i++) {
			System.out.println(getName() + "자동차 : " + i + " 미터 전진");
			try {
				Thread.sleep(random.nextInt(200));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(getName() + "끝");
	}
}
