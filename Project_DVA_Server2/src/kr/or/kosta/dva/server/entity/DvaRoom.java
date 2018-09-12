package kr.or.kosta.dva.server.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 대화방 클래스
 * @author 남수현
 */
public class DvaRoom extends Room{
	private String RoomOwner;
	protected List<DvaClient> clients;
	private int Capacity;
	/**
	 * 대화방 생성, 관리할 client 목록 생성
	 */
	public DvaRoom() {
		clients = new ArrayList<DvaClient>();
	}
	/**
	 * 방에 클라이언트 추가
	 * @param client 추가할 클라이언트
	 * @return 허용량에 다른 클라이언트 추가 성공 여부
	 */
	public boolean addClient(DvaClient client,String roomName) {
		System.out.println(clients.size());
		System.out.println(Capacity);
		if(Capacity == -1) {
			clients.add(client);
			sendRoomUserList(client,roomName);
			sendChangedMember(client.getNickName(),Protocol.SC_ENTRANCE_MEMBER,client.getNickName());			
			return true;
		}
//		if(clients.size()<Capacity) {
			clients.add(client);
			sendRoomUserList(client,roomName);
			sendChangedMember(client.getNickName(),Protocol.SC_ENTRANCE_MEMBER,client.getNickName());
			return true;
//		}else {
//			return false;
//		}
	}
	/**
	 * 관리 목록에서 클라이언트 삭제
	 * @param client 삭제 할 클라이언트
	 * @return 삭제 성공 여부
	 */
	public boolean removeClient(DvaClient client) {
		boolean result = clients.remove(client);
		if(client.getNickName().equals(RoomOwner)) {
			if(clients.size()>0) {
				RoomOwner = clients.get(0).getNickName();
			}else {
				
			}
		}
		if(result) {
			sendChangedMember(client.getNickName(),Protocol.SC_OUT_MEMBER);
		}
		return result;
	}
	/**
	 * 현재 방 인원
	 * @return 방 인원
	 */
	public int getCount() {
		return clients.size();
	}
	/**
	 * 방 전체 유저에게 메시지 보내기
	 * @param sb1 닉네임 앞부분
	 * @param sb2 닉네임 뒷부분
	 */
	public void sendAllMessage(StringBuilder sb1, StringBuilder sb2) {
		for (DvaClient client : clients) {
			client.sendMessage(sb1.toString()+client.getNickName()+sb2.toString());
		}
	}
	
	public void sendAllMessage(StringBuilder sb1, StringBuilder sb2, String exceptNickName) {
		for (DvaClient client : clients) {
			if(!client.getNickName().equals(exceptNickName)){
				client.sendMessage(sb1.toString()+client.getNickName()+sb2.toString());
			}
		}
	}
	/**
	 * 방 전체 유저에게 메시지 보내기
	 * @param string 보낼 메시지
	 */
	public void sendAllMessage(String string) {
		for (DvaClient client : clients) {
			client.sendMessage(string);
		}
	}
	/**
	 * 바뀐 멤버 정보
	 * @param nickName 바뀐 멤버 닉네임
	 * @param protocol 바뀐 타입에 따른 protocol
	 */
	public void sendChangedMember(String nickName, int protocol) {
		StringBuilder sb1 = new StringBuilder();
		sb1.append(protocol);
		sb1.append(Protocol.DELEMETER);
		sb1.append(DvaClient.currentTime());
		sb1.append(Protocol.DELEMETER);
		StringBuilder sb2 = new StringBuilder();
		sb2.append(Protocol.DELEMETER);
		sb2.append(nickName);
		sendAllMessage(sb1,sb2);
	}
	/**
	 * 바뀐 멤버 정보
	 * @param nickName 바뀐 멤버 닉네임
	 * @param protocol 바뀐 타입에 따른 protocol
	 */
	public void sendChangedMember(String nickName, int protocol, String exceptNickName) {
		StringBuilder sb1 = new StringBuilder();
		sb1.append(protocol);
		sb1.append(Protocol.DELEMETER);
		sb1.append(DvaClient.currentTime());
		sb1.append(Protocol.DELEMETER);
		StringBuilder sb2 = new StringBuilder();
		sb2.append(Protocol.DELEMETER);
		sb2.append(nickName);
		sendAllMessage(sb1,sb2,exceptNickName);
	}
	/**
	 * 특정 클라이언트에게 이 방의 유저 리스트 발송
	 * @param client 이 방의 유저 리스트를 받을 클라이언트
	 */
	public void sendRoomUserList(DvaClient client,String roomName){
		StringBuilder sb= new StringBuilder();
		sb.append(Protocol.SC_ROOMUSERLIST);
		sb.append(Protocol.DELEMETER);
		sb.append(DvaClient.currentTime());
		sb.append(Protocol.DELEMETER);
		sb.append(client.getNickName());
		sb.append(Protocol.DELEMETER);
		sb.append(roomName);
		sb.append(Protocol.INNER_DELEMETER);
		boolean first = true;
		for (DvaClient clientTemp : clients) {
			if(first) {
				first = false;
			}else {
				sb.append(Protocol.INNER_DELEMETER);
			}
			sb.append(clientTemp.getNickName());
		}
		client.sendMessage(sb.toString());
	}

}
