import java.util.HashSet;

public class Kakao3 {
    public static int solution(String[][] relation) {
        int answer = 0;
        // 열 검사
        for (int i = 0; i < relation[0].length; i++) {
            HashSet<String> hs = new HashSet<>();
        	// 행 검사 
			for (int j = 0; j < relation.length; j++) {
				hs.add(relation[j][i]);
			}
		}
        return answer;
    }
	public static void main(String[] args) {
		String[][] s = {{"100", "ryan", "music", "2"}, 
        		        {"200", "apeach", "math", "2"}, 
		        		{"300", "tube", "computer", "3"}, 
		        		{"400", "con", "computer", "4"}, 
		        		{"500", "muzi", "music", "3"}, 
		        		{"600", "apeach", "music", "2"}};
		System.out.println(solution(s));
	}
	
}
