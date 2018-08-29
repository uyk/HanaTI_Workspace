
import java.util.LinkedList;

public class QueueExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> queue = new LinkedList<>();
		queue.offer("aaa");
		queue.offer("ㄱㄱㄱ");
		queue.offer("ccc");
		queue.offer("...");
		System.out.println(queue.size());
		System.out.println(queue);
		
		System.out.println(queue.poll());
		System.out.println(queue.size());
		System.out.println(queue);
		
		System.out.println(queue.peek());
		System.out.println(queue.size());
		System.out.println(queue);
	}

}
