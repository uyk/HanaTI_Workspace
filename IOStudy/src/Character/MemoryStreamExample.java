package Character;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.StringReader;

public class MemoryStreamExample {

	public static void main(String[] args) throws IOException{
		String message = "187기 하나금융";
		StringReader sr = new StringReader(message);
		System.out.println((char)(sr.read()));
	}

}
