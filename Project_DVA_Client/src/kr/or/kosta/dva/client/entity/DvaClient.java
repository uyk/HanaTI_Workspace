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
	
	private List<DvaRoom> roomList;
	
// 생성자
	public DvaClient(MainFrame frame) {
		this.frame = frame;
		roomList = new ArrayList<>();
	}

// Getter, Setter
	public String currentTime() {
		LocalDateTime DateTime = LocalDateTime.now();
		DateTimeFormatter formmat = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm:ss");
		return (formmat.format(DateTime));
	}
	
	public List<DvaRoom> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<DvaRoom> roomList) {
		this.roomList = roomList;
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
						running = false;
					} catch(Exception e) {
						e.printStackTrace();
						System.out.println("[Debug] thread exception :" + e.getLocalizedMessage());
						break;
					}
				}
			}
			
		}.start();
		
	}
	/**
	 * 서버에 message를 전송하는 메소드
	 * @param message 서버에 전달할 메시지
	 */
	@Override
	public void sendMessage(String message) {
		System.out.println("[debug] sendMessage message: " + message);
		if(out != null) out.println(message);
	}

	/*
	// 테스트를 위해 서버에서 보낸 메시지 설정
	public void testSendMessage(String message) {
		System.out.println("[debug] testSendMessage message: " + message);
		// 서버로 부터 받은 메시지를 외부토큰으로 분해
		String[] tokens = message.split(Protocol.DELEMETER);
		int protocol = Integer.parseInt(tokens[0]);
		String time = tokens[1];
		String nickName = tokens[2];
		
		String SCMessage = null;
		// 프로토콜에 따라 메시지 분석
		switch (protocol) {
		case Protocol.CS_GET_LIST :
			SCMessage = Protocol.SC_ROOMUSERLIST+ Protocol.DELEMETER +
						currentTime() + Protocol.DELEMETER + 
						getNickName() + Protocol.DELEMETER + 
						"테스트방" + Protocol.INNER_DELEMETER +
						"이름1" + Protocol.INNER_DELEMETER +
						"이름2" + Protocol.INNER_DELEMETER +
						"이름3" + Protocol.INNER_DELEMETER;
						
			process(SCMessage);
			break;
		}
	}
	*/
	
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
		// 1001 로그인 성공
		case Protocol.SC_LOGIN_SUCCESS :
			setNickName(nickName);
			frame.changeCard(MainFrame.WAIT, null);
			break;
		// 1002 로그인 실패 
		case Protocol.SC_LOGIN_FAIL :
			JOptionPane.showMessageDialog(frame, "로그인 실패", "경고", JOptionPane.ERROR_MESSAGE);
			break;
		// 2001 방목록 받아옴
		case Protocol.SC_ROOMLIST :
			// 방 정보들을 담는 리스트
			List<DvaRoom> rooms = new ArrayList<>();
			if(tokens.length <= 3 ) return;
			// tokens[3] : 방이름 샘플★★유예겸★★5★★15.....
			String[] roomTokens = tokens[3].split(Protocol.INNER_DELEMETER);
			for (int i = 0; i < roomTokens.length; i += 4) {
				DvaRoom room = new DvaRoom(roomTokens[i], roomTokens[i+1], 
						Integer.parseInt(roomTokens[i+2]), 
						Integer.parseInt(roomTokens[i+3]));
				rooms.add(room);
				System.out.println("[debug] 받아온 방 정보: " +
						room.getRoomName() +"  " +
						room.getRoomOwner() +"  " +
						room.getUserCount() +"  " +
						room.getCapacity());
			}
			frame.WaitPanelRoomList(rooms);
			
			break;
		// 2002 특정방에 있는 유저 목록 불러옴	
		case Protocol.SC_ROOMUSERLIST :
			// 유저 목록을 저장할 리스트
			List<String> users = new ArrayList<>();
			// tokens[3] : 방이름 샘플★★유예겸★★김예겸★★가나다...
			if(tokens.length <= 3 ) return;
			// 첫번째 토큰은 방 이름
			String[] roomUserTokens = tokens[3].split(Protocol.INNER_DELEMETER);		
			// 방 이름 제외 유저 이름을 roomUsers 리스트에 추가
			for (int i = 1; i < roomUserTokens.length; i++)
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
				// RoomPanel의 유저 목록 변경
				frame.RoomPanelRoomUsers(users);
			}
			break;
		// 3001 방 생성 성공
		case Protocol.SC_ROOM_ADD_SUCCESS :
			frame.WaitPanelEnterRoom();
			break;
		// 3002 방 생성 실패
		case Protocol.SC_ROOM_ADD_FAIL :
			JOptionPane.showMessageDialog(frame, "방 생성 실패", "경고", JOptionPane.ERROR_MESSAGE);
			break;
		// 3101 방 입장 성공
		case Protocol.SC_ENTRANCE_SUCCESS :
			frame.WaitPanelEnterRoom();
			break;
		// 3102 방 입장 실패
		case Protocol.SC_ENTRANCE_FAIL :
			JOptionPane.showMessageDialog(frame, "방입장 실패", "경고", JOptionPane.ERROR_MESSAGE);
			break;	
		// 3103 다른 유저가 방에 들어옴
		case Protocol.SC_ENTRANCE_MEMBER :
			// tokens[3] : 유예겸
			// 대기실
			if(getLocation().equals(Protocol.ANTEROOM))
				frame.WaitPanelNewWaitUser(tokens[3]);
			// 채팅방
			else {
				frame.RoomPanelNewWaitUser(tokens[3]);
			}
			break;	
		// 3104 다른 유저가 방에서 나감
		case Protocol.SC_OUT_MEMBER :
			// tokens[3] : 유예겸
			// 대기실
			if(getLocation().equals(Protocol.ANTEROOM))
				frame.WaitPanelOutWaitUser(tokens[3]);
			// 채팅방
			else {
				frame.RoomPanelOutWaitUser(tokens[3]);
			}
			break;	
							
		// 3201 내가 방에서 나감
		case Protocol.SC_ROOM_OUT_SUCCESS:
			// 대기실에서 나가는 것은 로그아웃 또는 finish로 했기 때문에 안건드림
			if(getLocation().equals(Protocol.ANTEROOM))
				frame.WaitPanelNewWaitUser(tokens[3]);
			break;	
		}
	}

}