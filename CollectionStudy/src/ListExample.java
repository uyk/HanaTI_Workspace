import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
public class ListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = null;
		list = new ArrayList(10);
		
		list.add("황의조");
		list.add("손흥민");
		list.add("바나나");
		list.add(100);					//오토박싱 Object obj = 100;
		list.add(new Integer(100));
		list.add(Calendar.getInstance());
		list.add("황의조");
		// 중복된 Integer(100)과 "황의조"는 add안됨
		System.out.println("담겨진 갯수 : " + list.size());
		System.out.println("비어있는지 여부 : " + list.isEmpty());
		
		Set boddari = new HashSet(10);
		boddari.add("AAAAAAAAAA");
		boddari.add("bbbbbbb");
		boddari.add("ccccccccc");
		
		list.addAll(boddari);
		boolean result = list.remove("바나나");
		System.out.println("삭제 결과" + result);
		System.out.println(list.contains("황의조"));
		System.out.println(list.contains(Calendar.getInstance()));
		
		Object[] lists = list.toArray();
		for (Object object : lists) {
			if(object instanceof String)
				System.out.println(((String) object).length());
			System.out.println(object);
		}
		
		Iterator iter = list.iterator();
		while(iter.hasNext()) {
			Object object = iter.next();
			System.out.println(object);
		}
		for(Object object : list) {
			
		}
		
		
		// 리스트에 추가된 규약 메소드들
		list.add(0, "유예겸");
		System.out.println(list.get(0));
		System.out.println(list.indexOf("유예겸"));
		System.out.println(list.remove(0));
		
		System.out.println(list.set(0, "황희찬"));
		System.out.println(list.size());
		System.out.println();
		
		List l = list.subList(0, 3);
		for (Object object : l) {
			System.out.println(object);
		}
	}

}
