
public class OuterClass {
	enum Direction {
		A, B, C
	}
	class InnerClass {
		public void foo() {
			System.out.println("foo 호출됨");
		}
	}
	static class SInnerClass {
		public void bar() {
			System.out.println("bar 호출됨");
		}
		
	}
	
}
