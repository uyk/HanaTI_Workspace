import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 클라이언트의 데이터 수신 및 처리
 * @author 유예겸
 *
 */
public class Client extends Thread {
	private Socket socket;
	private PrintWriter out;
	private BufferedReader in;
	private boolean running = false;
	
	public Client(Socket socket) throws IOException {
		this.socket = socket;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		running = true;
	}
	
	public void recieve() {
		String clientMessage = null;
		while(running) {
			try {
				clientMessage = in.readLine();
				System.out.println("클라이언트로부터 수신 : " + clientMessage);
				if(clientMessage.equalsIgnoreCase("quit")) {
					break;                                                                                                                                                           
				}
				out.println(clientMessage);
			} catch (IOException e) {
				e.printStackTrace();
				return;
			} 
		}
		
		if(socket != null) {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	@Override
	public void run() {
		recieve();	
	}
}
