package kr.or.kosta.dva.server.entity;
/**
 * 클라이언트와 통일된 클라이언트 클래스 생성을 위한 추상클래스
 * @author 남수현
 */
public abstract class Client extends Thread{
	private String nickName;
	private String location;

	/**
	 * 유저 닉네임 받기
	 * @return 유저 닉네임
	 */
	public String getNickName() {
		return nickName;
	}
	/**
	 * 유저 닉네임 넣기
	 * @param nickName 넣고자 하는 닉네임
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	/**
	 * 유저 위치 받기
	 * @return 유저 위치
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 유저 위치 넣기
	 * @param location 넣고자 하는 유저 위치
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	
	/**
	 * 메시지 받는 메소드
	 */
	protected abstract void recieveMessage();
	/**
	 * 클라이언트에게 메시지 보내기
	 * @param message 보낼 메시지
	 */
	protected abstract void sendMessage(String message);
	/**
	 * 받은 메시지 처리
	 * @param message 처리할 메시지
	 */
	protected abstract void process(String message);
}
