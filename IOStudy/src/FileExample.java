import java.io.File;
import java.io.IOException;

public class FileExample {

	public static void main(String[] args) throws IOException {

		String path = "C:/some.dat";
		File file = new File(path);
		System.out.println("존재여부 : " + file.exists());
		System.out.println();
		
		path = "C:\\KOSTA187\\설치프로그램\\staruml-5.0-with-cm.exe";
		file = new File(path);
		System.out.println("파일 용량: " + file.getTotalSpace());
		System.out.printf("변경 날짜 : %1$tF %1$tp %1$tT \n", file.lastModified());
		System.out.println();
		
		
		path = "C:\\KOSTA187";
		file = new File(path);
		System.out.println("패스가 디렉토리인지 파일인지 : " + (file.isDirectory() ? "디렉토리" : "파일"));
		System.out.println("디렉토리이면 서브 디렉토리 목록 : ");
		for (File subFile : file.listFiles()) {
			System.out.println(subFile.getAbsolutePath());
		}
		System.out.println();
		
		path = "example.dat";
		file = new File(path);
		System.out.println("절대경로 : " + file.getAbsolutePath());
		System.out.println(file.toURI());
		
		// 조작관련 기능등
		path = "xxx.dat";
		file = new File(path);
		System.out.println(file.createNewFile());
		
		/*
		File temp = File.createTempFile("some", ".dat");
		System.out.println(temp.getAbsolutePath());
		FileOutputStream out = new FileOutputStream(temp);
		out.write(10);
		temp.deleteOnExit();
		*/
		
		File dir = new File("C:/KOSTA187/xxx");
		dir.mkdir();
		dir.delete();
		
		File[] drives = File.listRoots();
		for (File file2 : drives) {
			System.out.println(file2);
		}
	}

}
