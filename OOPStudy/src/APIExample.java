/**
 * 자바 표준 API의 기본 클래스 사용하기
 * 
 */

public class APIExample implements CInterface{

	
	public static void main(String[] args) {
		String str;
		str = new String("자바가 싫어요...");		// 명시적 생성
		str = "묵시적 생성";						// 묵시적 생성

		int length = str.length();
		System.out.println(length);

		char c = str.charAt(0);
		System.out.println(c);

		System.out.println(Math.abs(-100));
		
		
	}

	@Override
	public void a() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void c() {
		// TODO Auto-generated method stub
		
	}
}
