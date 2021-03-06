
public class Circle extends Shape {
	
	private double radian;

	//생성자
	public Circle() {
		this(0.0, 0.0, 0.0);
		// TODO Auto-generated constructor stub
	}
	public Circle(double x, double y, double radian) {
		this.x = x; this.y = y;
		this.radian = radian;
	}
	// getter, setter
	public double getRadian() {
		return radian;
	}
	public void setRadian(double radian) {
		this.radian = radian;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(this.x+ ", " + this.y + ", " + radian + "의 원입니다.");
	}
	
	@Override
	public double getLength() {
		// TODO Auto-generated method stub
		return 2 * Math.PI * radian;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * Math.pow(radian, 2);
	}
	@Override
	public String toString() {
		return "Circle [radian=" + radian + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
}
