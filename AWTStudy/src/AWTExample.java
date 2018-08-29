import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;

public class AWTExample {

	public static void main(String[] args) {
		Frame frame = new Frame("처음으로 만드는 프레임");
		frame.setSize(1000, 800);
		frame.setVisible(true);
		
		Button button1 = new Button("AWT 버튼1");
		Button button2 = new Button("AWT 버튼2");
		frame.setLayout(new FlowLayout());
		frame.add(button1);
		frame.add(button2);
		
//		frame.setResizable(false);
		Label label = new Label("AWT MY LABEL");
		frame.add(label);
		
		TextField textField = new TextField("Enter ID", 10);
		frame.add(textField);
		
		TextArea textArea = new TextArea(5, 20);
		frame.add(textArea);
		
		Checkbox checkbox = new Checkbox("Female", true);
		frame.add(checkbox);

		CheckboxGroup cg = new CheckboxGroup();
		Checkbox cb1 = new Checkbox("Female", true, cg);
		Checkbox cb2 = new Checkbox("Male", false, cg);
		frame.add(cb1);
		frame.add(cb2);
		
		Choice selectBox = new Choice();
		selectBox.add("Yegyeom");
		selectBox.add("LOLA");
		selectBox.add("DBDP");
		frame.add(selectBox);
	}

}
