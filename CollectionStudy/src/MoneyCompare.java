import java.util.Comparator;

public class MoneyCompare implements Comparator<Accounts> {

	@Override
	public int compare(Accounts o1, Accounts o2) {
		// TODO Auto-generated method stub
		return (int)(o1.getRestMoney() - o2.getRestMoney());
	}

}
