package kr.or.kosta.dva.client.entity;

public abstract class Client{
	private String nickName;
	private String location;

	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public abstract void recieveMessage();
	public abstract void sendMessage(String message);
	protected abstract void process(String message);
	
}
