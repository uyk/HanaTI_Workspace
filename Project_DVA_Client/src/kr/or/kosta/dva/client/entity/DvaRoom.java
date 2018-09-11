package kr.or.kosta.dva.client.entity;

public class DvaRoom extends Room{
	private String roomName;
	private int userCount;
	
	public DvaRoom(String roonaName, String roomOwner, int userCount, int capacity ) {
		this.roomName = roonaName;
		this.userCount = userCount;
		setRoomOwner(roomOwner);
		setCapacity(capacity);
	}
	
	public int getUserCount() {
		return userCount;
	}

	public void setUserCount(int userCount) {
		this.userCount = userCount;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
		
}