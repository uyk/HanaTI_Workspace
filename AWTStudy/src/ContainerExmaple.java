import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Window;

public class ContainerExmaple {

	public static void main(String[] args) {
		Frame owner = new Frame();
		
		owner.setSize(600, 600);
		owner.setVisible(true);
		
		Dialog dialog = new Dialog(owner, "타이틀", false);
		dialog.setSize(200, 200);
		//dialog.setVisible(true);
		
		Window window = new Window(owner);
		window.setSize(400, 200);
		window.setVisible(true);
		
		FileDialog fileDialog = new FileDialog(owner, "파일 열기", FileDialog.LOAD);
		fileDialog.setVisible(true);
	}

}
