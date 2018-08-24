
public class Rectangle extends Shape {
	private double width;
	private double height;
	
	// 생성자
	public Rectangle() {
		this(0.0, 0.0, 0.0, 0.0);
		// TODO Auto-generated constructor stub
	}


	public Rectangle(double x, double y, double width, double height) {
		//super(x, y);
		this.width = width;
		this.height = height;
	}

	// getter, setter
	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
	}


	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}


	// 인스턴스 메소드
	public void draw() {
		System.out.println("Rectangle draw()");
	}
	@Override
	public double getLength() {
		// TODO Auto-generated method stub
		return 2.0*getWidth() + 2.0 * getHeight();
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return getWidth()*getHeight();
	}
	//


	@Override
	public String toString() {
		return "Rectangle [width=" + width + ", height=" + height + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
