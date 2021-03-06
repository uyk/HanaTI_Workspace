/**
 * 배열 관련한 공통 기능 정의
 * 
 * @author 유예겸
 *
 */
public class ArrayUtil {

	/**
	 * 배열 복사
	 * 
	 * @param src        복사하고자 하는 원본 배열
	 * @param increament 증가치
	 * @return 복사된 배열
	 */
	public static int[] copy(int[] src, int increament) {
		int[] array = new int[src.length + increament];
		for (int i = 0; i < src.length; i++) {
			array[i] = src[i];
		}
		return array;
	}

	/**
	 * 배열 오름차순 정렬
	 * 
	 * @param 정렬하고자 하는 원본 배열
	 */
	public static void sort(int[] src) {
		for (int k = 0; k < src.length - 1; k++) {
			for (int i = k; i < src.length - 1; i++) {
				int j;
				if (src[k] > src[i + 1]) {
					j = src[k];
					src[k] = src[i + 1];
					src[i + 1] = j;
				}
			}
		}
	}

	public static void main(String[] args) {
		int[] array = { 5, 15, 3, 4, 96, 55 };
		int[] copy = ArrayUtil.copy(array, 4);
		for (int i : copy) {
			System.out.print(i + "\t");
		}
		System.out.println();
		ArrayUtil.sort(array);
		for (int i : array) {
			System.out.print(i + "\t");
		}
	}
}
