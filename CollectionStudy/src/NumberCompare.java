import java.util.Comparator;

public class NumberCompare implements Comparator<Accounts> {

	@Override
	public int compare(Accounts o1, Accounts o2) {
		// TODO Auto-generated method stub
		return o1.getAccountNum().compareTo(o2.getAccountNum());
	}

}
