/**
 * LIFO 구조의 스택 구현을 위한 클래스
 * 
 * @date 2018-08-22
 * @author 유예겸
 *
 */
public class Stack {

// 인스턴스 변수	
	/**
	 * array : int 배열로 스택의 데이터를 배열로 저장. count : 데이터의 갯수를 저장.
	 */
	private int[] array;
	private int count;

//생성자
	/**
	 * 매개변수 없이 생성되었을 때 호출되는 생성자 매개변수 100을 보내 다른 생성자를 호출한다.
	 */
	public Stack() {
		this(100);
	}

	/**
	 * 매개변수로 int 형 변수를 받는 생성자. size 크기의 int 배열을 생성하고 array 변수에 할당한다. count 변수를 0으로
	 * 초기화한다.
	 * 
	 * @param size 스택의 크기
	 */
	public Stack(int size) {
		array = new int[size];
		count = 0;
	}

// 인스턴스 메소드

	/**
	 * 스택에 데이터를 추가하는 메소드 count 1 증가
	 * 
	 * @param value
	 */
	public void push(int value) {
		array[count++] = value;
	}

	/**
	 * 스택에서 데이터를 제거하는 메소드
	 * 
	 * @return 제거한 데이터
	 */
	public int pop() {
		if (count == 0)
			return 0; // 빈 스택의 경우 0을 반환

		int data = array[count - 1]; 	// 마지막 유효 데이터를 변수 data에 저장
		array[count - 1] = 0; 			// 유효데이터의 마지막 자리를 비움
		count--; 						// 데이터가 하나 감소했으므로 count 1 감소
		return data;
	}

	/**
	 * 데이터의 개수를 반환하는 메소드 count의 getter와 같은 역할을 한다.
	 * 
	 * @return count 데이터의 개수
	 */
	public int length() {
		return count;
	}

	public static void main(String[] args) {
		Stack stack = new Stack(100);
		//Stack stack = new Stack();
		stack.push(5);
		stack.push(1);
		stack.push(9);
		// 테스트를 위한 출력
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		// 예외처리 하지말고 심플한 기능만 구현.
		System.out.println(stack.length());
	}
}
