import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * TCP/ IP 기반의 Socket 프로그래밍 원리
 * 
 * @author 유예겸
 *
 */
public class SocketExample {
	
	public static final String mydomain = "192.168.0.127";	//localhost
	public static final String otherdomain = "192.168.0.134";	//localhost
	public static final String other2domain = "192.168.0.125";	//localhost
	public static final int port = 7777;
	
	public static void main(String[] args) {
		InputStream in = null;
		OutputStream out = null;
		Socket socket = null;
		
		Scanner scanner = new Scanner(System.in);
				
		PrintWriter pw;
		BufferedReader br;
		
		try {
//			Socket socket  = new Socket(InetAddress.getByName(domain), port);
			socket  = new Socket(mydomain, port);
			//socket  = new Socket(otherdomain, port);
			System.out.println("서버와 연결");
			
			in = socket.getInputStream();
			out = socket.getOutputStream();
			/*
			out.write(10);
			int data = in.read();
			System.out.println("서버로부터 받은 데이터 : " + data);
			*/
			pw = new PrintWriter(out, true);
			br = new BufferedReader(new InputStreamReader(in));
			
			while(true) {
				String inputMessage = scanner.nextLine();
				pw.println(inputMessage);
				if(inputMessage.equalsIgnoreCase("quit")) {
					System.out.println("종료입력");
					break;
				}
				System.out.println("서버로부터 에코된 데이터 : " + br.readLine());
			}			
			
		} catch (UnknownHostException e) {
			System.out.println("서버와 연결할 수 없습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				out.close();
				in.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
