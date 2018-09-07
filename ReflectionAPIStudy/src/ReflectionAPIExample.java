import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionAPIExample {
	public static void main(String[] args) {
		String str = "리플렉션이란";
		// str을 매개변수로 받아왔는데 무엇인지 모를 때
		System.out.println(str.getClass());
		
		Class c = str.getClass();
		
		System.out.println(c.getModifiers());
		System.out.println(Modifier.FINAL);
		System.out.println(c.getName());
		System.out.println(c.getDeclaredFields());
		for (Field f : c.getDeclaredFields()) {
			System.out.println(f);
		}
		System.out.println();
		for (Field f : c.getFields()) {
			System.out.println(f);
		}
		System.out.println();
		System.out.println(c.getDeclaredMethods().length);
		for (Method m : c.getDeclaredMethods()) {
			System.out.println(m.getName());
		}
		System.out.println();
		System.out.println(c.getMethods().length);
		for (Method m : c.getMethods()) {
			System.out.println(m.getName());
		}
	}
}
