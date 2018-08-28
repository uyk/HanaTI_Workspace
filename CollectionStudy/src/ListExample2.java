import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

/**
 * <List 인터페이스>
 * 
 * 순서를 통해 데이터를 관리하기 위한 규약(인터페이스)이다.
 * Set과 달리 요소가 순차적으로 관리되며, 중복을 허용하는 특징을 가진다.
 * ArrayList, Vector, LinkedList가 List 인터페이스를 구현한 대표적 클래스이다
 * 
 * @author 유예겸
 *
 */
public class ListExample2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector list = null;
		list = new Vector();
		
		list.addElement("황의조");
		list.addElement("손흥민");
		list.addElement("바나나");
		list.addElement(100);					//오토박싱 Object obj = 100;
		list.addElement(new Integer(100));
		list.addElement(Calendar.getInstance());
		list.addElement("황의조");
		// 중복된 Integer(100)과 "황의조"는 add안됨
		System.out.println("담겨진 갯수 : " + list.size());
		System.out.println("비어있는지 여부 : " + list.isEmpty());
		
		System.out.println(list.elementAt(0));
		System.out.println(list);
		list.removeElement("바나나");
		System.out.println(list);
		
		Enumeration e = list.elements();
		while (e.hasMoreElements()) {
			Object object = (Object) e.nextElement();
			System.out.println(object);
		}
	}

}
