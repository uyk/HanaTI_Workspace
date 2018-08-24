
public class PolymophismExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 클래스 형변환(Up casting)
		Shape shape = null;
		//shape = new Shape();
		
		shape = new Circle(10, 10, 20);
		
		System.out.println(shape.toString());
		
		shape = new Rectangle(10,10,50,20);
		System.out.println(shape);
		
		//System.out.println(shape.getX());
		//System.out.println(shape.getWidth());
		System.out.println(shape.getArea());
		
		Rectangle rectangle = (Rectangle)shape;
		System.out.println(rectangle.getWidth());
		
		//
		System.out.println(shape instanceof Object);
		System.out.println(shape instanceof Shape);
		System.out.println(shape instanceof Rectangle);
		//System.out.println(shape instanceof String);

	}

}
