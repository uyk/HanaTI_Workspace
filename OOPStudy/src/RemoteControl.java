
public interface RemoteControl {
	public static final int MAX_VOLUME = 50;
	public static final int MIN_VOLUME = 0;
	public static final int MAX_CHANNEL = 100;
	public static final int MIN_CHANNEL = 1;
	
	public abstract void turnOn();
	public abstract void turnff();
	public abstract void volumeUp();
	public abstract void volumeOff();
	public abstract void setVolume(int volume);
	public abstract void setChannel(int channel);
}
