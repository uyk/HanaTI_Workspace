
public class ShapeAPP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Shape shape = new Shape(12.5, 35.7);
		Shape shape = null;
		//shape.draw();
		
		Circle circle = new Circle(15.0, 15.0, 30.0);
		circle.draw();
		System.out.println(circle.getLength());
		System.out.println(circle.getArea());
		
		Shape shape2 = null;
		System.out.println(shape);
		
		System.out.println(shape2);
		System.out.println(circle);

	}

}
