package memo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileDao {
	MemoUI memoUI;
	
	
	public FileDao() {
		// TODO Auto-generated constructor stub
	}
	
	public FileDao(MemoUI memoUI) {
		this.memoUI = memoUI;
	}
	/*
	public void newFile() throws IOException{
		//saveFile();
		
	}
	*/
	public String openFile(String path) throws IOException{
		FileInputStream in = new FileInputStream(path);
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		String totlaTxt = "";
		String txt = null;
		
		while( (txt = br.readLine()) != null) {
			totlaTxt += (txt + "\n");
		}
		
		if(br != null) br.close();
		if(isr != null) isr.close();
		if(in != null) in.close();
		
		return totlaTxt;

		
	}
	public void saveFile(String path, String text) throws IOException {
		if(path == "nullnull.txt") return;
		FileOutputStream fileOutputStream = new FileOutputStream(path);
		OutputStreamWriter OutputStreamWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");
		BufferedWriter bufferedWriter = new BufferedWriter(OutputStreamWriter);
		
		bufferedWriter.write(text);
		if(bufferedWriter != null) bufferedWriter.close();
		if(OutputStreamWriter != null) OutputStreamWriter.close();
		if(fileOutputStream != null) fileOutputStream.close();

	}
	
}
