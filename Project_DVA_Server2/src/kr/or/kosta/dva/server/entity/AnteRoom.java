package kr.or.kosta.dva.server.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 대화방 클래스를 상속 받은 대기실 클래스
 * @author 남수현
 */
public class AnteRoom extends DvaRoom {
	public AnteRoom() {
		super();
		super.setRoomOwner("대기실");
	}

	/* (non-Javadoc)
	 * @see kr.or.kosta.dva.server.entity.DvaRoom#addClient(kr.or.kosta.dva.server.entity.DvaClient)
	 * 허용량과 무관하게 대기실에 인원 추가
	 */
	@Override
	public boolean addClient(DvaClient client,String roomName) {
		clients.add(client);
		sendRoomUserList(client,roomName);
		client.sendRoomList();
		sendChangedMember(client.getNickName(),Protocol.SC_ENTRANCE_MEMBER,client.getNickName());
		return true;
	}
	/**
	 * 정보가 변경된 방의 방 정보 대기실 인원에게 발송
	 * @param roomName 변경된 방 이름
	 * @param room 변경된 방 객체
	 */
	public void changedRoomInfo(String roomName, DvaRoom room) {
		StringBuilder sb1 = new StringBuilder();
		sb1.append(Protocol.SC_ROOM_INFO_CHANGE);
		sb1.append(Protocol.DELEMETER);
		sb1.append(DvaClient.currentTime());
		sb1.append(Protocol.DELEMETER);
		StringBuilder sb2 = new StringBuilder();
		sb2.append(Protocol.DELEMETER);
		sb2.append(roomName);
		sb2.append(Protocol.INNER_DELEMETER);
		sb2.append(room.getRoomOwner());
		sb2.append(Protocol.INNER_DELEMETER);
		sb2.append(room.getCount());
		sb2.append(Protocol.INNER_DELEMETER);
		sb2.append(room.getCapacity());
		sendAllMessage(sb1,sb2);
	}
}
