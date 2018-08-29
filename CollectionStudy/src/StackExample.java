import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class StackExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<>();
		stack.push("aaa");
		stack.push("ㄱㄱㄱ");
		stack.push("ccc");
		stack.push("...");
		System.out.println(stack.size());
		System.out.println(stack);
		
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack);
		
		System.out.println(stack.peek());
		System.out.println(stack.size());
		System.out.println(stack);
	}

}
