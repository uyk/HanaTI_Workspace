
public interface AInterface  {
	public void a();
}

interface BInterface {
	public void a();
}

interface CInterface extends AInterface, BInterface{
	public void c();
}
