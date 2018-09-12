package kr.or.kosta.dva.server.entity;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

import kr.or.kosta.dva.server.boundary.MainFrame;

/**
 * Dva 서버. 사용자 목록 및 방 목록 관리
 * @author 남수현
 */
public class DvaServer {
	public static final int PORT = Protocol.PORT;
	private boolean running;
	private ServerSocket serverSocket;
	private Hashtable<String, DvaClient> clients;
	private Hashtable<String, DvaRoom> rooms;
	private MainFrame frame;
	
	
	
	/**
	 * Server Frame setting
	 * @param frame 서버 화면
	 */
	public void setFrame(MainFrame frame) {
		this.frame = frame;
	}
	
	
	/**
	 * Server Frame getting
	 * @return 서버 화면 객체
	 */
	public MainFrame getFrame() {
		return frame;
	}


	/**
	 * 구동 여부 확인
	 * @return 
	 */
	public boolean isRunning() {
		return running;
	}

	/**
	 * 현재 Client 목록
	 * @return Client 목록 NickName이 key
	 */
	public Hashtable<String, DvaClient> getClients() {
		return clients;
	}
	/**
	 * 현재 방 목록
	 * @return 방 목록. 방제가 key
	 */
	public Hashtable<String, DvaRoom> getRooms() {
		return rooms;
	}
	/**
	 * 룸 별 정보를 배열에 담아 룸 목록 반환
	 * @return
	 */
	public List<String[]> getRoomList(){
		List<String[]> answer= new ArrayList<String[]>();
		Set<String> roomKeys = rooms.keySet();
		for (String string : roomKeys) {
			if(string!=Protocol.ANTEROOM) {
				String[] temp = new String[4];
				DvaRoom thisRoom = rooms.get(string);
				temp[0] = string;
				temp[1] = thisRoom.getRoomOwner();
				temp[2] = ""+thisRoom.getCount();
				temp[3] = ""+thisRoom.getCapacity();
				answer.add(temp);
			}
		}
		return answer;
	}
	/**
	 * 해당 방의 룸 유저 목록 반환 String[1] 짜리이며 닉네임만 담김
	 * @param roomName 얻고자 하는 방 이름
	 * @return 해당 방의 유저 닉네임 목록
	 */
	public List<String[]> getRoomUserList(String roomName){
		List<String[]> answer= new ArrayList<String[]>();
		List<DvaClient> client = rooms.get(roomName).getClients();
		if(client != null) {
			for (DvaClient clientTemp : client) {
				String[] temp = new String[1];
				temp[0] = clientTemp.getNickName();
				answer.add(temp);
			}		}
		return answer;
	}
	/**
	 * 전체 유저 목록
	 * @return String[2]로 담겼으며 0에 닉네임, 1에 현재 위치
	 */
	public List<String[]> getUserList(){
		List<String[]> answer= new ArrayList<String[]>();
		String[] temp = new String[2];
		Set<String> clientKeys = clients.keySet();
		for (String string : clientKeys) {
			temp[0] = string;
			temp[1] = clients.get(string).getLocation();
			answer.add(temp);
		}
		return answer;
	}
	/**
	 * 서버 구동
	 * @throws IOException 포트 충돌
	 */
	public void startUp() throws IOException {
		try {
			serverSocket = new ServerSocket(PORT);
		}catch (Exception e) {
			throw new IOException("["+PORT + "] 포트 충돌로 ChatServer를 구동할 수 없습니다.");
		}
		running = true;
		clients = new Hashtable<String, DvaClient>();
		rooms = new Hashtable<String, DvaRoom>();
		DvaRoom anteRoom = new AnteRoom();
		rooms.put(Protocol.ANTEROOM, anteRoom);
			DvaRoom test1 = new DvaRoom();
			test1.setCapacity(10);
			test1.setRoomOwner("nam");
			DvaRoom test2 = new DvaRoom();
			test2.setCapacity(10);
			test2.setRoomOwner("su");
			DvaRoom test3 = new DvaRoom();
			test3.setCapacity(10);
			test3.setRoomOwner("hyeon");
			rooms.put("안드로이드", test1);
			rooms.put("피곤",test2);
			rooms.put("집에 가고 싶은 사람들", test3);
		System.out.println("Dva["+PORT + "] ChatServer Start....");
		
		while(running) {
			try {
				Socket socket = serverSocket.accept();
				DvaClient client = new DvaClient(socket, this);
				client.start();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * 서버 종료
	 */
	public void shutDown() {
		try {
			serverSocket.close();
			System.exit(0);
		} catch (IOException e) {
			System.exit(0);
		}
		
	}
	/**
	 * 방 입장
	 * @param NickName 입장할 유저 닉네임
	 * @param roomName 입장하고자 하는 방
	 * @return 입장 성공 여부
	 */
	public boolean enterenceRoom(String NickName,String roomName) {
		DvaClient client = clients.get(NickName);
		String beforeRoom = client.getLocation();
		if(rooms.get(roomName).addClient(client,roomName)) {
			if(!beforeRoom.equals("")) {
				rooms.get(beforeRoom).removeClient(client);
			}
			((AnteRoom)rooms.get(Protocol.ANTEROOM)).changedRoomInfo(roomName, rooms.get(roomName));
		}else {
			System.out.println("에러 1");
			return false;
		}
		return true;
	}
	/**
	 * 방에서 나가기
	 * @param NickName 나가고자 하는 유저 닉네임
	 * @return 성공 여부
	 */
	public boolean outRoom(String NickName) {
		DvaClient client = clients.get(NickName);
		String beforeRoom = client.getLocation();
		if(rooms.get(Protocol.ANTEROOM).addClient(client,Protocol.ANTEROOM)) {
			rooms.get(beforeRoom).removeClient(client);
			if(rooms.get(beforeRoom).getCount()<1) {
				rooms.remove(beforeRoom);
			}
			((AnteRoom)rooms.get(Protocol.ANTEROOM)).changedRoomInfo(beforeRoom, rooms.get(beforeRoom));
		}else {
			return false;
		}
		return false;
	}
	/**
	 * 새로운 클라이언트가 프로그램에 참여
	 * @param client 참여하고자 하는 클라이언트
	 */
	public void addClient(DvaClient client) {
		clients.put(client.getNickName(), client);
		rooms.get(Protocol.ANTEROOM).addClient(client,Protocol.ANTEROOM);
//		frame.addClient(client.getNickName());
	}
	/**
	 * 방 추가
	 * @param roomName 추가하고자 하는 방제
	 * @param ownerName 방장
	 * @param capacity 방 허용 치
	 */
	public void addRoom(String roomName, String ownerName, int capacity) {
		DvaRoom newRoom = new DvaRoom();
		System.out.println("셋팅할 허용치"+capacity);
		newRoom.setCapacity(capacity);
		rooms.put(roomName, newRoom);
//		frame.addRoom(roomName);
	}
	/**
	 * 방 삭제
	 * @param roomName 삭제하고자 하는 방제
	 */
	public void removeRoom(String roomName) {
		rooms.remove(roomName);
//		frame.removeRoom(roomName);
	}
	/**
	 * 전체 유저 수 반환
	 * @return 전체 유저 수
	 */
	public int getClientCount() {
		return clients.size();
	}
	/**
	 * 전체 방 수 반환
	 * @return 전체 방 수
	 */
	public int getRoomCount() {
		return rooms.size();
	}	
	/**
	 * 닉네임 존재 여부 확인
	 * @param nickName 확인하고자 하는 닉네임
	 * @return 존재 여부
	 */
	public boolean isExistNickName(String nickName) {
		return clients.containsKey(nickName);
	}
	
	/**
	 * 관리 유저에서 유저 삭제
	 * @param nickName 삭제하고자 하는 유저 닉네임
	 */
	public void removeClient(String nickName) {
		if(clients!=null) {
//			frame.removeClient(nickName);
			DvaClient client = clients.get(nickName);
			rooms.get(client.getLocation()).removeClient(client);
			try {
				client.close();
			} catch (IOException e) {}
			clients.remove(nickName);
		}
//		
//		try {
//			clients.get(nickName).close();
//		} catch (IOException e) {
//			clients.remove(nickName);
//			removeMemberMessage(nickName);
//		}
//		clients.remove(nickName);
//		removeMemberMessage(nickName);
	}
	
//	public void sendListMessage() {
//		
//	}
//	public void removeMemberMessage(String nickName) {
//		
//	}
	/**
	 * 방 전체에 메시지 보내기
	 * @param roomName 메시지를 보내고자 하는 방 이름
	 * @param message 보내고자 하는 메세지
	 */
	public void sendRoomMessage(String roomName, String message) {
		if(rooms.containsKey(roomName)){
			rooms.get(roomName).sendAllMessage(message);
		}
	}
	/**
	 * 귓속말 보내기
	 * @param from 보낸 사람 닉네임
	 * @param to 받을 사람 닉네임
	 * @param message 보내고자 하는 메시지
	 */
	public void sendWhisper(String from, String to, String message) {
		clients.get(to).sendWhisper(from,message);
	}
	/**
	 * 초대 보내기
	 * @param from 초대 보낸 사람 닉네임
	 * @param roomName 초대 된 방 이름
	 * @param to 초대 받을 사람 닉네임
	 */
	public void sendInvite(String from,String roomName, String to) {
		clients.get(to).sendMessage(Protocol.SC_INVITE_MESSAGE+Protocol.DELEMETER+DvaClient.currentTime()+Protocol.DELEMETER+to+Protocol.DELEMETER+from+Protocol.INNER_DELEMETER+roomName);
	}
	/**
	 * 초대 거절
	 * @param from 초대 거절 메시지를 보낸 사람(초대 받았던 사람)
	 * @param to 초대 거절 메시지를 받을 사람(초대 했던 사람)
	 */
	public void sendInviteReject(String from, String to) {
		clients.get(to).sendMessage(Protocol.SC_INVITE_REJECT+Protocol.DELEMETER+DvaClient.currentTime()+Protocol.DELEMETER+to+Protocol.DELEMETER+from);
	}
	/**
	 * 전체 유저에게 메시지 보내기
	 * @param message 보내고자 하는 메시지
	 */
	public void sendAllMessage(String message) {
		Enumeration<DvaClient> e = clients.elements();
		while (e.hasMoreElements()) {
			DvaClient client = (DvaClient) e.nextElement();
			client.sendMessage(message);
		}
	}
	/**
	 * 방 상태가 변화하였을 경우 대기실에 있는 인원들에게 변화를 알림
	 * @param roomName 변화한 방
	 * @param room 변화한 방 Instance
	 */
	public void changeRoomInfo(String roomName, DvaRoom room) {
		DvaRoom anteroom = rooms.get(Protocol.ANTEROOM);
		if(anteroom instanceof AnteRoom) {
			((AnteRoom) anteroom).changedRoomInfo(roomName, anteroom);
		}
	}
	/**
	 * 방제가 존재하는 지 확인
	 * @param roomName 확인하고 싶은 방제
	 * @return 존재 여부
	 */
	public boolean isExistRoomName(String roomName) {
		return rooms.containsKey(roomName);
	}
}






