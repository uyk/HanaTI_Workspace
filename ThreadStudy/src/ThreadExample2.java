
public class ThreadExample2 {
	static class MyThread extends Thread {
		@Override
		public void run() {
			long n = 0;
			System.out.println(getName() + " 스레드 시작");
			for(int i = 0; i < Integer.MAX_VALUE; i++) {
				n += i;
			}
			System.out.println(getName() + " 스레드 종료 " + n);
		}
	}
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName());
		System.out.println("프로그램 시작");

		MyThread t1 = new MyThread();
		MyThread t2 = new MyThread();
		t1.setPriority(Thread.MAX_PRIORITY);
		t2.setPriority(Thread.MIN_PRIORITY);
		
		t1.start();
		t2.start();
		
		System.out.println("프로그램 종료");
	}
}
