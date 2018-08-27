
public class Bar {
	@Deprecated
	public void some() {
		System.out.println("썸 타요...");
	}

	@Override
	public String toString() {
		return "toString";
	}
	public static void main(String[] args) {
		Bar bar = new Bar();
		bar.some();
		bar.toString();
	}
}
