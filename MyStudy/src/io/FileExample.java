package io;

import java.io.File;
import java.io.IOException;

public class FileExample {
	public static void main(String[] args) throws IOException{
		String path = "C:/some.dat";
		File file = new File(path);
		
		System.out.println(file.exists());
		
		path = "C:\\KOSTA187";
		file = new File(path);
		System.out.println(file.getTotalSpace());
		System.out.println(file.isDirectory());
		for (File subFile : file.listFiles()) {
			System.out.println(subFile.getAbsolutePath());
		}
		System.out.println();
		path = "xxx.dat";
		file = new File(path);
		System.out.println(file.createNewFile());
		
	}

}
