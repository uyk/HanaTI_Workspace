
import java.util.Hashtable;


public class kakaoCoding {
	// N : 스테이지 개수
	// stages : 각 유저가 멈춘 스테이지
	// return : 실패율이 높은 스테이지부터 내림차순. 같으면 작은번호순
	static public int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		
		// 스테이지 0부터 N-1 까지 각 스테이지에 멈춘 사람 수
		// N번째 인덱스에는 모든 스테이지를 클리어한 사람 수
		int[] temp = new int[N+1];
		
		// 스테이지와 실패율		
		Hashtable<Integer, Double> ht = new Hashtable<>();
		//double[] rate = new double[N + 1];		// 실패율
		int denominator = 0;	//실패율 계산 분모
		
		// 각 스테이지에 멈춘 사람 수
		for (int i : stages) {
			temp[i-1]++;
		}
		
		// 각 스테이지의 실패율 계산
		// i : 계산하고 있는 스테이지
		for (int i = 0; i < temp.length; i++) {
			denominator = 0;	//실패율 계산 분모
			// j : 현재 스테이지 부터 마지막 스테이지 까지
			for (int j = i; j < temp.length; j++) {
				denominator += temp[j];
			}
			ht.put(i+1, (double)(temp[i]) / (double)denominator);

		}
		System.out.println(ht);

		boolean exist = false;
		for (int i = 0; i < answer.length; i++) {
			double max = -1.0;
			for (int j = 1; j < ht.size(); j++) {
				exist = false;
				for (int stageI : answer) {
					if (j ==  stageI) exist = true;
				}
				if(!exist) {
					if(ht.get(j) > max) {
						max = ht.get(j);
						answer[i] = j;
					}
				}
			}
		}

		for (int k = 1; k <= N; k++) {
			exist = false;
			for (int i : answer) {
				if( i == k) {
					exist = true;
					System.out.println(i);
				}
			}
			if(exist == false) answer[N-1] = k;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		int[] test = new int[] {4,4,4,4};
		int[] answer = solution(4, test);
		for (int i : answer) {
			System.out.println("answer : " + i);
		}
	}

}
