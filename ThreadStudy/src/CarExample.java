
public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("메인 스레드에 의해 프로그램 시작됨");
		Car car = new Car("유예겸");
		car.start();		//run 호출안했는데 왜 달립니다가 출력되지?
		//car.run();
		
		Car car2 = new Car("김김김");
		car2.start();
		
		Car car3 = new Car("카카카");
		car3.start();

		System.out.println("메인 스레드에 의해 프로그램 종료됨");
	}

}
