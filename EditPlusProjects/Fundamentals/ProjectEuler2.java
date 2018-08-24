import java.util.ArrayList;

class  ProjectEuler2{

	public static void main(String[] args) {
		ArrayList nums = new ArrayList();
		nums.add(2);
		nums.add(3);
		nums.add(5);
		nums.add(7);
		long sum = 2 + 3 + 5 + 7;
		for (int i = 8; i <= 2000000; i++){
			for(int j = 0; j < nums.size(); j++) {
				int temp = (Integer)(nums.get(j));
				if(i%temp == 0) break;
				if(j == nums.size() - 1) {sum += i; nums.add(j); System.out.println(i); break;}
			}
		}
		System.out.println(sum);
	}
}
