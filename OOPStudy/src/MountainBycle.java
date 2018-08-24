
public class MountainBycle extends Bycle{
	//추가속성
	String frame;
	boolean suspension;

	public MountainBycle() {
		this(null, false);
	}
	public MountainBycle(String frame, boolean suspension) {
		this(0, null, frame, suspension);
	}
	public MountainBycle(int id, String brand, String frame, boolean suspension) {
		super(id, brand);
		this.frame = frame;
		this.suspension = suspension;
	}
	public void running() {
		System.out.println("산도 달립니다");
	}

}
