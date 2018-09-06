package objectStream;

import java.awt.Frame;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Vector;

public class ObjectStreamExample {
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		String path = "example.ser";
		
		int age = 20;
		double weight = 45.6;
		
		String message = "오브젝트 스트림 실습...";
		Calendar today = Calendar.getInstance();
		Frame frame = new Frame("타이틀");
		frame.setSize(500, 200);
		Account account = new Account("1111-2222-3333", "유예겸", 1234, 5000);
		Vector<Account> vector = new Vector<>();
		for (int i = 0; i < 10; i++) {
			vector.addElement(new Account(i +"2222-3333", "abc", 1234, i*10));
		}
		
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path));
		out.writeObject(age);	// 오토박싱
		out.writeObject(weight);
		out.writeObject(message);
		out.writeObject(today);
		out.writeObject(frame);
		out.writeObject(account);
		out.writeObject(vector);
		
		out.flush();
		out.close();
		System.out.println("다씀");
		
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(path));
		age = 0;
		weight = 0.0;
		
		message = null;
		today = null;
		frame = null;
		
		age = (Integer)(in.readObject());
		weight = (Double)(in.readObject());
		message = (String)(in.readObject());
		today = (Calendar)(in.readObject());
		frame = (Frame)(in.readObject());
		account = (Account)(in.readObject());
		vector = (Vector<Account>)(in.readObject());
		
		System.out.println(age);
		System.out.println(weight);
		System.out.println(today);
		System.out.println(message);
		System.out.println(account);
		System.out.println(vector);
		
		
		frame.setVisible(true);
		in.close();
		
	}

}
