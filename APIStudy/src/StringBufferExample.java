
public class StringBufferExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("Java");
		System.out.println(sb.toString());
		sb.append("Programming");
		System.out.println(sb.toString());
		sb.replace(0, 4, "C++");
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		String str = sb.substring(11);
		System.out.println(str);
		
		StringBuffer sb2 = new StringBuffer("유예겸");
		sb2.append("df").append("df");
		System.out.println(sb2);
	}

}
