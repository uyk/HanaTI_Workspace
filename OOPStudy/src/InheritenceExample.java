
public class InheritenceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bycle bycle = new Bycle(10, "삼천리");
		
		System.out.println(bycle.brand);
		bycle.running();
		
		MountainBycle mountainBycle = new MountainBycle(10, "삼천리", "카본", true);
		// 재사용
		System.out.println(mountainBycle.brand);
		mountainBycle.running();
		// 확장
		System.out.println(mountainBycle.frame);
		System.out.println(mountainBycle.suspension);
		
	}

}
