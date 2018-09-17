import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

public class Kakao1 {

	static public String[] solution(String[] record) {
		// 레코드를 출력용 문자열로 바꿔서 저장(~님이 들어왔습니다)
        String[] answer2 = new String[record.length];
        // 이름 ID 해시테이블
        Hashtable<String, String> names = new Hashtable<>();
        int count = 0;
        
        for (int i = 0; i < record.length; i++) {
        	String[] tokens = record[i].split(" ");

        	if(tokens.length == 3 ) names.put(tokens[1], tokens[2]);
			if(tokens[0].equals("Enter")) {
				answer2[i] = tokens[1] + "님이 들어왔습니다.";
			}
			else if(tokens[0].equals("Leave")) {
				answer2[i] = tokens[1] + "님이 나갔습니다.";
			}
			else {
				// change (출력안해도됨)
				count++;
			}
		}

    	String[] answer = new String[record.length - count];
    	
        List<String> answerL = new ArrayList<String>();
        for (String string : answer2) {
			if(string != null && !string.equals("")) answerL.add(string);
		}
        
        for (int i = 0; i < answer.length; i++) {
			answer[i] = answerL.get(i);
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
