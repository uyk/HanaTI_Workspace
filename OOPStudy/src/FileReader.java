/**
 * 명령어 인수 처리 예제
 * java FileReader [읽고자 하는 파일명1] [읽고자 하는 파일명1]
 * 
 * @author 유예겸
 *
 */
public class FileReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length != 2) {
			System.out.println("사용법 : java FileReader [읽고자 하는 파일명1] [읽고자 하는 파일명1]");
			return;
		}
		String fileName1 = args[0];
		String fileName2 = args[1];
		System.out.println(fileName1);
		System.out.println(fileName2);
	}

}
