import java.io.IOException;

public class Foo {
	public static void someMethod() {
//		String message = null;
//		System.out.println(message.length());
//		System.out.println(10/0);
		
		int[] array = {1,2,3};
		
		System.out.println(array[3]);
	}
	public static void someMethod2() {
		try {
			String message = null;
			//System.out.println(message.length());
			//System.out.println(10/0);
			
//			int[] array = {1,2,3};
//			System.out.println(array[3]);
		} catch(NullPointerException e) {
			System.out.println("Null point");
			System.out.println(e);
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch(ArithmeticException e) {
			System.out.println("dived 0 error");
			System.out.println("e");
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {
			System.out.println("예외발생 여부와 상관없이 항상 실행되는 코드");
		}
	}
	public void someMethod3() throws NullPointerException, ArithmeticException, ArrayIndexOutOfBoundsException{
		String message = null;
		System.out.println(message.length());
		System.out.println(10/0);
		int[] array = {1,2,3};
		System.out.println(array[3]);
	}
	public static void main(String[] args) {
		System.out.println("JVM에 의해 프로그램 시작됨");
		Foo foo = new Foo();
//		try {
			foo.someMethod3();
//		} catch (Exception e){
			
//		}

		
		try {
			int value = System.in.read();
			System.out.println(value);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
