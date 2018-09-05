import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyExample {
	public static long copy(String srcPath, String destPath) throws IOException {
		byte[] buffer = new byte[4*1024];
		InputStream inputStream = new FileInputStream(srcPath);
		OutputStream outputStream = new FileOutputStream(destPath);
		long totalCount = 0L;
		try {
			int count = 0;
			
			while( (count = inputStream.read(buffer)) != -1) {
				count += inputStream.read(buffer);
				outputStream.write(buffer, 0, count);
				totalCount += count;
			}
			//return totalCount;
			
		} finally {
			if(outputStream != null) outputStream.close();
			if(inputStream != null) inputStream.close();
		}
		return totalCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src = "C:\\KOSTA187\\설치프로그램\\eclipse-jee-photon-R-win32-x86_64.zip";
		String dest = "exlipse.zip";
		
		long copySize = 0L;
		
		try {
			copySize = copy(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(copySize + "바이트 파일 복사 완료");
	}

}
