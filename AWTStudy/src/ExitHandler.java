import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExitHandler extends WindowAdapter{
	ChatFrame frame;
	
	public ExitHandler(ChatFrame frame) {
		// TODO Auto-generated constructor stub
		this.frame = frame;
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		frame.finish();

	}


}
