package kr.or.kosta.dva.server.entity;

import java.util.List;

/**
 * 방 클래스 생성을 위한 추상 클래스
 * @author 남수현
 *
 */
public abstract class Room {

	private String RoomOwner;
	protected List<DvaClient> clients;
	private int Capacity;

	/**
	 * 방장 정보 얻기
	 * @return 방장 닉네임
	 */
	public String getRoomOwner() {
		return RoomOwner;
	}
	/**
	 * 방장 정하기
	 * @param roomOwner
	 */
	public void setRoomOwner(String roomOwner) {
		RoomOwner = roomOwner;
	}
	/**
	 * 방에서 관리하는 클라이언트 목록 반환
	 * @return 클라이언트 목록
	 */
	public List<DvaClient> getClients() {
		return clients;
	}
	/**
	 * 허용량 가져오기
	 * @return 허용량
	 */
	public int getCapacity() {
		return Capacity;
	}
	/**
	 * 허용량 넣기
	 * @param capacity 허용량
	 */
	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
}
