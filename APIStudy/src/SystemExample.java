
public class SystemExample {

	public static void main(String[] args) {
		System.out.println("프로그램 시작");
		//System.exit(0);
		System.gc();
		System.out.println("프로그램 끝");
		long start = System.currentTimeMillis();
		
		
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		
		System.out.println(System.getenv("path"));
		System.out.println(System.getenv("java_home"));
	}

}
