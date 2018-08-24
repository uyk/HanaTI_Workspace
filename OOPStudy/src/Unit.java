
public class Unit {
	private Weapon weapon;
	
	private String name;
	
	//생성자
	public Unit() {
		this(null);
	}
	public Unit(String name) {
		this.name = name;
	}
	//Getter, Setter
	public Weapon getWeapon() {
		return weapon;
	}
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	//
	public void attack() {
		weapon.attack();
	}
	public static void main(String[] args) {
		Unit unit = new Unit("SCV");
		Weapon weapon = null;
		weapon = new Gun();
		
		unit.setWeapon(weapon);
		unit.attack();
		
		weapon = new Sword();
		unit.setWeapon(weapon);
		unit.attack();
	}
}
