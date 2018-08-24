/**
 * �ϻ��Ȱ�� ��ü�� �߻�ȭ�ϱ� ���� �𵨸� Ŭ���� ����
 * ���� ���� ��ü
 */


public class Accounts {

	static int a,b,c;
	
	// static �ʱ�ȭ ��� : Ư���� ������ ��ɾ� ����(�ַ� �ʱ�ȭ)
	static {
		System.out.println("�ʱ�ȭ �� �����Դϴ�.");
		a = 10;
		b = 20;
		c = 30;
	}



	// Ŭ����(static)����
	public static String bankName = "�ϳ�����";

	// �ν��Ͻ� ���� ����
	private String accountNum;
	private String accountOwner;
	private int passwd;
	private long restMoney;

	// ������
	public Accounts() {
		this(null,null,0,0);
	}
	public Accounts(String accountNum, String accountOwner) {
		//this.accountNum = accountNum;
		//this.accountOwner = accountOwner;
		this(accountNum, accountOwner, 0, 0);
	}
	public Accounts(String accountNum, String accountOwner, int passwd, long restMoney) {
		this.passwd = passwd;
		this.restMoney = restMoney;
	}

	// setter, getter �޼ҵ�
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getAccountNum() {
		return this.accountNum;
	}
	public void setAccountOwner(String accountOwner) {
		this.accountOwner = accountOwner;
	}
	public String getAccountOwner() {
		return this.accountOwner;
	}
	public void setPasswd(int passwd) {
		this.passwd = passwd;
	}
	public int getPasswd() {
		return this.passwd;
	}
	public void setRestMoney(long restMoney) {
		this.restMoney = restMoney;
	}
	public long getRestMoney() {
		return this.restMoney;
	}

	// �ν��Ͻ� �޼ҵ� ����
	long deposit(long money) {
		restMoney += money;
		return restMoney;
	}
	long withdraw(long money) {
		restMoney -= money;		// �������� �����Ͱ� ���Դٰ� ����
		return restMoney;
	}
	boolean checkPasswd(int pw) {
		return passwd == pw;
	}

	//Ŭ���� �޼ҵ�
	public static int sum(int a, int b) {
		return a + b;
	}
}
