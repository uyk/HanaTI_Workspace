
public class SamsongTV implements RemoteControl, Browsable {

	private int currentChannel;
	private int currentVolume;
	

	
	public SamsongTV() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SamsongTV(int currentChannel, int currentVolume) {
		super();
		this.currentChannel = currentChannel;
		this.currentVolume = currentVolume;
	}

	
	public int getCurrentChannel() {
		return currentChannel;
	}

	public void setCurrentChannel(int currentChannel) {
		this.currentChannel = currentChannel;
	}

	public int getCurrentVolume() {
		return currentVolume;
	}

	public void setCurrentVolume(int currentVolume) {
		this.currentVolume = currentVolume;
	}

	
	@Override
	public void surfing(String url) {
		// TODO Auto-generated method stub
		System.out.println(url + "을 화면에 렌더링합니다...");

	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("전원을 켭니다.");

	}

	@Override
	public void turnff() {
		// TODO Auto-generated method stub
		System.out.println("전원을 끕니다.");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		if( !(currentVolume >= MAX_VOLUME) ) 
			currentVolume++;
	}

	@Override
	public void volumeOff() {
		// TODO Auto-generated method stub
		currentVolume--;

	}

	@Override
	public void setVolume(int volume) {
		// TODO Auto-generated method stub
		currentVolume = volume;
	}

	@Override
	public void setChannel(int channel) {
		// TODO Auto-generated method stub
		currentChannel = channel;
	}
	public static void main(String[] args) {
		RemoteControl tv = new SamsongTV();
		tv.turnOn();
		tv.setChannel(50);
		System.out.println(((SamsongTV)tv).getCurrentChannel());
		tv.volumeUp();
		tv.volumeUp();
		tv.volumeUp();
		tv.volumeUp();
		tv.volumeUp();
		
		System.out.println(RemoteControl.MAX_CHANNEL);
		
		
		tv.turnff();
	}

}
