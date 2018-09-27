import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class Kakao1 {

	static public String[] solution(String[] record) {
		// 레코드를 출력용 문자열로 바꿔서 저장(~님이 들어왔습니다)
		ArrayList<String> listAnswer = new ArrayList<>();
		String[] answer;
//		int count = 0;
		
        // 이름 ID 해시테이블
        Hashtable<String, String> names = new Hashtable<>();
        
        // 여기서 
        for (int i = 0; i < record.length; i++) {
        	String[] tokens = record[i].split(" ");

        	if(tokens.length == 3 ) names.put(tokens[1], tokens[2]);
			if(tokens[0].equals("Enter")) {
				listAnswer.add(tokens[1] + "님이 들어왔습니다.");
			}
			else if(tokens[0].equals("Leave")) {
				listAnswer.add(tokens[1] + "님이 나갔습니다.");
			}
			else {
				// change
				//count++;
			}
		}
        
        answer = new String[listAnswer.size()];
        for (int i = 0; i < listAnswer.size(); i++) {
    		answer[i] = listAnswer.get(i);
		}
        
        Enumeration<String> en = names.keys();
        while(en.hasMoreElements()) {
	        String key = en.nextElement().toString();
        	for (int i = 0; i < answer.length; i++) {
        		answer[i] = answer[i].replace(key, names.get(key));
			}
        }
        return answer;
        
    }
	
	public static void main(String[] args) {
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", 
				"Enter uid1234 Prodo", "Change uid4567 Ryan"};
		for (String string : solution(record)) {
			System.out.println(string);
		}
	}

}
