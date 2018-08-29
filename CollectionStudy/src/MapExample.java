import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("940907", "유예겸");
		map.put("791212", "ㅅㅅㅅ");
		map.put("980630", "ㅂㅂㅂ");
		map.put("850508", "ㄷㄷㄷ");
		
		if(map.containsKey("940907"))	
			System.out.println("존재하는 키");
		else map.put("940907", "ㅇㅇㅇ");
		
		Set<String> keySet = map.keySet();
		for (String string : keySet) {
			System.out.print(string + " ");
		}
		
		System.out.println();
		
		Collection<String> values = map.values();
		for (String string : values) {
			System.out.print(string + " ");
		}
	}

}
