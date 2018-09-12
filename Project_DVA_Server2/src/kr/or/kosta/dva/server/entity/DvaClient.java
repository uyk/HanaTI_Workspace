package kr.or.kosta.dva.server.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


/**
 * 서버에서 관리할 Client 클래스
 * @author 남수현
 */
public class DvaClient extends Client {
	private boolean running;
	private Socket socket;
	private BufferedReader in;
	private PrintWriter out;
	DvaServer dvaServer;
	/**
	 * DvaClient 생성자
	 * @param socket 연결할 소캣
	 * @param dvaServer 관리 될 서버
	 * @throws IOException 소켓 생성 오류
	 */
	public DvaClient(Socket socket, DvaServer dvaServer) throws IOException {
		this.socket = socket;
		this.dvaServer = dvaServer;
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		running = true;
		this.setLocation("");
		this.setNickName("");
		System.out.println(socket.toString()+"생성");
	}
	/**
	 * 소켓 받기
	 * @return 현재 소캣
	 */
	public Socket getSocket() {
		return socket;
	}
	/**
	 * 구동 상태 반환
	 * @return 구동 상태
	 */
	public boolean isRunning() {
		return running;
	}
	/**
	 * 구동 상태 Setting
	 * @param running setting하고자 하는 구동 상태
	 */
	public void setRunning(boolean running) {
		this.running = running;
	}
	/* (non-Javadoc)
	 * @see kr.or.kosta.dva.server.entity.Client#recieveMessage()
	 * 지속적으로 클라이언트로부터 오는 메시지를 받아서 처리
	 */
	@Override
	protected void recieveMessage() {
		while(running) {
			String clientMessage = null;
			try {
				clientMessage = in.readLine();
				process(clientMessage);
			} catch (IOException e) {
				System.out.println("클라 종료");
				wrongMessage(e.toString());
				break;
			}
		}
		if(socket != null) {
			try {
				close();
				System.out.println("클라 종료");
				dvaServer.removeClient(getNickName());
			} catch (IOException e) {
				System.out.println("클라 종료");
				dvaServer.removeClient(getNickName());
			}
		}
	}
	/**
	 * 소켓 닫기
	 * @throws IOException 소켓이 없습니다.
	 */
	public void close() throws IOException {
		socket.close();
	}
	/* (non-Javadoc)
	 * @see kr.or.kosta.dva.server.entity.Client#sendMessage(java.lang.String)
	 * 해당 클라이언트에 메시지 보내기
	 * @param sendMessage 보내고자 하는 메시지
	 */
	@Override
	protected void sendMessage(String message) {
//		dvaServer.getFrame().appendLog(message);
		System.out.println("보내는 메세지 : "+message);
		out.println(message);
	}
	/* (non-Javadoc)
	 * @see kr.or.kosta.dva.server.entity.Client#process(java.lang.String)
	 * 클라이언트로부터 받은 메시지 파싱하여 Protocol 확인 후 개별 메소드 호출
	 * @param 처리할 메시지
	 */
	@Override
	protected void process(String message) {
		if(message==null) {
			return;
		}
		int protocol = 0;
		String messageT ="";
		System.out.println("받은 메세지 : "+message);
//		dvaServer.getFrame().appendLog(message);
		String[] tokens = message.split(Protocol.DELEMETER,4);
		if(tokens.length<3) {
			wrongMessage(message);
			return;
		}
		try{
			protocol = Integer.parseInt(tokens[0]);
		}catch (NumberFormatException e) {
			wrongMessage(message);
			return;
		}
//		String time = tokens[2];
		if(tokens.length>=4) {
			messageT = tokens[3];
		}
		switch (protocol) {
		case Protocol.CS_LOGIN:
			logIn(tokens[2]);
			break;
		case Protocol.CS_LOGOUT:
			logOut();
			break;
		case Protocol.CS_GET_LIST:
			getList(messageT);
			break;
		case Protocol.CS_ROOM_ADD:
			roomAdd(messageT);
			break;
		case Protocol.CS_ENTRANCE:
			entrance(messageT);
			break;
		case Protocol.CS_ROOM_OUT:
			roomOut();
			break;
		case Protocol.CS_CHAT_MESSAGE:
			chatMessage(messageT);
			break;
		case Protocol.CS_WHISPER:
			whisper(messageT);
			break;
		case Protocol.CS_INVITE:
			invite(messageT);
			break;
		case Protocol.CS_INVITE_OK:
			inviteOk(messageT);
			break;
		case Protocol.CS_INVITE_NO:
			inviteNo(messageT);
			break;
		default:
			wrongMessage(message);
			break;
		}
	}
	/**
	 * logIn 처리
	 * @param nickName 로그인 하고자 하는 닉네임
	 */
	private void logIn(String nickName) {
		if(dvaServer.isExistNickName(nickName)) {
			sendMessage(Protocol.SC_LOGIN_FAIL + Protocol.DELEMETER + currentTime() + Protocol.DELEMETER +  nickName);
		}else {
			sendMessage(Protocol.SC_LOGIN_SUCCESS + Protocol.DELEMETER + currentTime() + Protocol.DELEMETER + nickName);
			this.setNickName(nickName);
			dvaServer.addClient(this);
			this.setLocation(Protocol.ANTEROOM);
//			entrance(Protocol.ANTEROOM);
			System.out.println("[Debug] : 접속 클라이언트 수 : " + dvaServer.getClientCount());
		}
	}
	/**
	 * 로그 아웃. 이 클라이언트 종료
	 */
	private void logOut() {
		dvaServer.removeClient(getNickName());
		running = false;
		try {
			close();
		} catch (IOException e) {}
	}
	/**
	 * 리스트 요청 처리
	 * @param messageT 리스트 타입
	 */
	private void getList(String messageT) {
		String[] getter = messageT.split(Protocol.INNER_DELEMETER,2);
		switch(getter[0]) {
		case Protocol.CS_ROOMLIST:
			sendRoomList();
			break;
		case Protocol.CS_ROOMUSERLIST:
			sendRoomUserList(getter[1]);
			break;
		case Protocol.CS_USERLIST:
			sendUserList();
			break;
		default:
			wrongMessage(Protocol.CS_GET_LIST+Protocol.DELEMETER+messageT);
			break;
		}
	}
	/**
	 * 클라이언트에게 방 목록 전송
	 */
	public void sendRoomList() {
		String roomList = listToString(dvaServer.getRoomList());
		sendMessage(Protocol.SC_ROOMLIST+Protocol.DELEMETER+currentTime()+Protocol.DELEMETER+getNickName()+Protocol.DELEMETER+roomList);
	}
	/**
	 * 클라이언트에게 방의 유저 리스트 전송
	 * @param roomName 유저 리스트를 얻고자 하는 방
	 */
	protected void sendRoomUserList(String roomName) {
		String roomUsersList = listToString(dvaServer.getRoomUserList(roomName));
		sendMessage(Protocol.SC_ROOMUSERLIST+Protocol.DELEMETER+currentTime()+Protocol.DELEMETER+getNickName()+Protocol.DELEMETER+roomUsersList);
	}
	/**
	 * 클라이언트에게 전체 유저 리스트 전송
	 */
	private void sendUserList() {
		String userList = listToString(dvaServer.getUserList());
		sendMessage(Protocol.SC_ROOMLIST+Protocol.DELEMETER+currentTime()+Protocol.DELEMETER+getNickName()+Protocol.DELEMETER+userList);
	}
	/**
	 * 리스트를 내부 구분자로 연결된 String으로 변환
	 * @param list 변환하고자 하는 String
	 * @return 변환된 String
	 */
	private String listToString(List<String[]> list) {
		StringBuilder sb = new StringBuilder();
		boolean first1 = true;
		for (String[] tempArray : list) {
			if(first1) {
				first1 = false;
			}else{
				sb.append(Protocol.INNER_DELEMETER);
			}
			boolean first2 = true;
			for (String string : tempArray) {
				if(first2) {
					first2 = false;
				}else{
					sb.append(Protocol.INNER_DELEMETER);
				}
				sb.append(string);
			}
		}
		return sb.toString();
	}
	/**
	 * 방 생성 메시지 처리
	 * @param message 방이름, 허용량
	 */
	private void roomAdd(String message) {
		String[] input = message.split(Protocol.INNER_DELEMETER,2);
		if(dvaServer.isExistRoomName(input[0])) {
			addRoomError("ExistRoomName");
		}else {
			int capacity = -1;
			try {
				capacity = Integer.parseInt(input[1]);
				if(capacity<1) {
					addRoomError("capacity<1");
				}
			}catch(NumberFormatException e) {
				addRoomError("NumberFormatException");
				return;
			}
			System.out.println("방 생성 에러 없음.");
			String roomName = input[0];
			dvaServer.addRoom(roomName, getNickName(), capacity);
			entrance(roomName);
			sendMessage(Protocol.SC_ROOM_ADD_SUCCESS+Protocol.DELEMETER+currentTime()+Protocol.DELEMETER+getNickName()+Protocol.DELEMETER+roomName+Protocol.INNER_DELEMETER+getNickName()+Protocol.INNER_DELEMETER+1+Protocol.INNER_DELEMETER+capacity);
		}
	}
	/**
	 * 방 입장 처리
	 * @param RoomName 입장하고자 하는 방 이름
	 */
	private void entrance(String RoomName) {
		if(dvaServer.enterenceRoom(getNickName(), RoomName)) {
			setLocation(RoomName);
			sendMessage(Protocol.SC_ENTRANCE_SUCCESS+Protocol.DELEMETER+currentTime()+Protocol.DELEMETER+getNickName()+Protocol.DELEMETER+RoomName);
//			sendRoomUserList(RoomName);
		}else {
			sendMessage(Protocol.SC_ENTRANCE_FAIL+Protocol.DELEMETER+currentTime()+Protocol.DELEMETER+getNickName()+Protocol.DELEMETER+RoomName);
		}
	}
	/**
	 * 방에서 나가고자 하는 요청 처리
	 */
	private void roomOut() {
		if(dvaServer.outRoom(getNickName())) {
			setLocation(Protocol.ANTEROOM);
			sendMessage(Protocol.SC_ROOM_OUT_SUCCESS+Protocol.DELEMETER+currentTime()+Protocol.DELEMETER+getNickName()+Protocol.DELEMETER+getNickName());
			
//			sendRoomUserList(Protocol.ANTEROOM);
		}else {
			sendMessage(Protocol.SC_ENTRANCE_FAIL+Protocol.DELEMETER+currentTime()+Protocol.DELEMETER+getNickName()+Protocol.DELEMETER+getNickName());
		}
	}
	/**
	 * 채팅 메시지를 같은 방 유저들에게 발송
	 * @param message 발송하고자 하는 메시지
	 */
	private void chatMessage(String message) {
		if(getLocation()!=Protocol.ANTEROOM) {
			dvaServer.sendRoomMessage(getLocation(), message);
		}
	}
	/**
	 * 귓속말 발송 요청 처리
	 * @param message 받을 사람 닉네임, 보낼 메시지
	 */
	private void whisper(String message) {
		String[] input = message.split(Protocol.INNER_DELEMETER,2);
		String to = input[0];
		if(dvaServer.isExistNickName(to)){
			String messageT = input[1];
			dvaServer.sendWhisper(getNickName(),to,messageT);
			sendMessage(Protocol.SC_WHISPER_SUCCESS+Protocol.DELEMETER+currentTime()+Protocol.DELEMETER+getNickName()+Protocol.DELEMETER+"Sucess");
		}else {
			sendMessage(Protocol.SC_WHISPER_FAIL+Protocol.DELEMETER+currentTime()+Protocol.DELEMETER+getNickName()+Protocol.DELEMETER+"Fail");
		}
	}
	/**
	 * 귓속말을 받을 유저에게 귓속말 발송
	 * @param from 보낸 사람
	 * @param message 귓속말 메시지
	 */
	public void sendWhisper(String from, String message) {
		sendMessage(Protocol.SC_WHISPER_MESSAGE+Protocol.DELEMETER+currentTime()+Protocol.DELEMETER+getNickName()+Protocol.DELEMETER+from+Protocol.INNER_DELEMETER+message);
	}
	/**
	 * 채팅방 생성이 되지 않았을 경우 생성
	 * @param errorMessage 생성 불가 이유 Message
	 */
	public void addRoomError(String errorMessage) {
		System.out.println("방 생성 에러 "+ errorMessage);
		sendMessage(Protocol.SC_ROOM_ADD_FAIL+Protocol.DELEMETER+currentTime()+Protocol.DELEMETER+getNickName()+Protocol.DELEMETER+errorMessage);
	}
	/**
	 * 초대 메시지 발송 처리
	 * @param nickName 초대 받을 사람
	 */
	public void invite(String nickName) {
		if(dvaServer.isExistNickName(nickName)){
			dvaServer.sendInvite(getNickName(), getLocation(), nickName);
			sendMessage(Protocol.SC_INVITE_SUCCESS+Protocol.DELEMETER+currentTime()+Protocol.DELEMETER+getNickName()+Protocol.DELEMETER+nickName);
		}else {
			sendMessage(Protocol.SC_INVITE_FAIL+Protocol.DELEMETER+currentTime()+Protocol.DELEMETER+getNickName()+Protocol.DELEMETER+nickName);
		}
	}
	/**
	 * 초대 승인 처리
	 * @param roomName 초대 받은 방 이름
	 */
	public void inviteOk(String roomName) {
		if(!dvaServer.enterenceRoom(getNickName(), roomName)) {
			
		}
	}
	/**
	 * 초대 거절 처리
	 * @param roomName 초대 한 사람 이름
	 */
	public void inviteNo(String nickName) {
		dvaServer.sendInviteReject(getNickName(), nickName);
	}	
	/**
	 * 잘못된 메시지 수신 시 처리
	 * @param message 수신 된 메시지
	 */
	private void wrongMessage(String message) {
//		dvaServer.getFrame().appendWrongMessage(message);
		System.out.println(message);
	}
	/**
	 * 현재 시스템 시간 얻기
	 * @return yyyy-MM-dd a hh:mm:ss 형식의 String
	 */
	static public String currentTime() {
		LocalDateTime DateTime = LocalDateTime.now();
		DateTimeFormatter formmat = DateTimeFormatter.ofPattern("yyyy-MM-dd a hh:mm:ss");
		return(formmat.format(DateTime));
	}
	@Override
	public void run() {
		recieveMessage();
	}
}
