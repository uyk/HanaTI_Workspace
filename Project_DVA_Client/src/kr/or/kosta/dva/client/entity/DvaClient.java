package kr.or.kosta.dva.client.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import kr.or.kosta.dva.client.boundary.MainFrame;
/**
 * 클라이언트 측 유저 클래스
 * @author 유예겸
 *
 */
public class DvaClient extends Client{
	public static final String SERVER = Protocol.SERVER_IP;
	public static final int PORT = Protocol.PORT;
	
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	
	private boolean running;
	
	private MainFrame frame;
	
// 생성자
	public DvaClient(MainFrame frame) {
		this.frame = frame;
	}

// Getter, Setter
	
	public String currentTime() {
		LocalDateTime DateTime = LocalDateTime.now();
		DateTimeFormatter formmat = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm:ss");
		return (formmat.format(DateTime));
	}
	
	/**
	 * 서버와 연결하는 메소드
	 * @throws Exception
	 */
	public void connectServer() throws Exception {
		System.out.println("debug : connectionServer");
		try {
			socket = new Socket(SERVER, PORT);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream(), true);
			running = true;
		}catch (Exception e) {
			throw new Exception("서버를 찾을 수 없습니다..");
		}
	}
	
	/**
	 * 클라이언트를 종료하는 메소드
	 */
	public void stopClient() {
		running = false;
		if(socket != null) {
			try {
				socket.close();
			} catch (IOException e) {}
		}		
	}

	/**
	 * 서버로부터 메시지를 수신하는 스레드 발생.
	 * 메시지를 수신하면 process 메소드를 호출하여 수신한 메시지를 넘긴다.
	 */
	@Override
	public void recieveMessage() {
		new Thread() {
			@Override
			public void run() {
				while(running) {
					String serverMessage = null;
					try {
						serverMessage = in.readLine();
						if(serverMessage == null) return;
						System.out.println("[Debug] Server Receive Message: " + serverMessage);
						process(serverMessage);
						
					} catch(SocketException e) {
						System.out.println("[Debug] thread Socket Exception :" + e.getLocalizedMessage());
					} catch(Exception e) {
						e.printStackTrace();
						System.out.println("[Debug] thread exception :" + e.getLocalizedMessage());
						break;
					}
				}
			}
			
		}.start();
		
	}

	@Override
	public void sendMessage(String message) {
		System.out.println("[debug] sendMessage message: " + message);
		if(out != null) out.println(message);
	}
	
	/**
	 * 서버로부터 메시지를 수신하는 스레드 발생.
	 * 메시지를 수신하면 process 메소드를 호출하여 수신한 메시지를 넘긴다.
	 */
	@Override
	protected void process(String message) {
		System.out.println("[debug] process message: " + message+"\n");
		// 서버로 부터 받은 메시지를 외부토큰으로 분해
		String[] tokens = message.split(Protocol.DELEMETER);
		int protocol = Integer.parseInt(tokens[0]);
		String time = tokens[1];
		String nickName = tokens[2];
		
		// 프로토콜에 따라 메시지 분석
		switch (protocol) {
		// 로그인 성공
		case Protocol.SC_LOGIN_SUCCESS :
			setNickName(nickName);
			setLocation(Protocol.ANTEROOM);
			frame.changeCard(MainFrame.WAIT, null);
			break;
		// 로그인 실패
		case Protocol.SC_LOGIN_FAIL :
			JOptionPane.showMessageDialog(frame, "로그인 실패", "경고", JOptionPane.ERROR_MESSAGE);
			break;
		// 방목록 받아옴
		case Protocol.SC_ROOMLIST :
			// 방 정보들을 담는 리스트
			List<DvaRoom> rooms = new ArrayList<>();
			// tokens[3] : 방제목 샘플1★★유예겸★★5★★15.....
			String[] roomTokens = tokens[3].split(Protocol.INNER_DELEMETER);
			for (int i = 0; i < roomTokens.length; i += 4) {
				DvaRoom room = new DvaRoom(roomTokens[i], roomTokens[i+1], 
						Integer.parseInt(roomTokens[i+2]), 
						Integer.parseInt(roomTokens[i+3]));
				rooms.add(room);
			}
			frame.WaitPanelRoomList(rooms);
			break;
		// 특정방에 있는 유저 목록 불러옴
		case Protocol.SC_ROOMUSERLIST :
			List<String> users = new ArrayList<>();
			// tokens[3] : 방이름샘플★★유예겸★★김예겸★★가나다...
			String[] roomUserTokens = tokens[3].split(Protocol.INNER_DELEMETER);
			// 유저 이름을 roomUsers 리스트에 추가
			// 0번째 인덱스에는 방 이름이 들어감
			for (int i = 0; i < roomUserTokens.length; i++)
				users.add(roomUserTokens[i]);
			// 유저가 대기실에 있는 경우
			if(getLocation().equals(Protocol.ANTEROOM)) {
				// 대기실이면서 대기실 유저 요청했을 경우
				if(roomUserTokens[0].equals(Protocol.ANTEROOM)) {
					frame.WaitPanelWaitUsers(users);
				}
				// 대기실이면서 다른 방 유저 요청했을 경우
				else {
					frame.WaitPanelRoomUsers(users);
				}
			}
			// 대기실이 아닌 경우
			else{
				
			}
			break;
			
		
		}
		
	}
}
