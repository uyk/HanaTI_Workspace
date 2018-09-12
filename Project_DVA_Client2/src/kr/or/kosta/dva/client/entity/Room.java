package kr.or.kosta.dva.client.entity;

import java.util.List;

public class Room {
	private String RoomOwner;
	protected List<String> clients;
	private int Capacity;

	public String getRoomOwner() {
		return RoomOwner;
	}
	public void setRoomOwner(String roomOwner) {
		RoomOwner = roomOwner;
	}
	public List<String> getClients() {
		return clients;
	}
	public void setClients(List<String> clients) {
		this.clients = clients;
	}
	public int getCapacity() {
		return Capacity;
	}
	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
}
