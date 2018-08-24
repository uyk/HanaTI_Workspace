/**
 * 모든 도형의 공통적인 속상과 기능 정의
 * 
 * @author 유예겸
 *
 */
public abstract class Shape {
	protected double x, y;

	// 생성자
	
	// 인스턴스 메소드
	// 추상 메소드 : 서브클래스가 반드시 재정의해야 할 수직적 규약
	public abstract void draw();
	public abstract double getLength();
	public abstract double getArea();
		
	
}
