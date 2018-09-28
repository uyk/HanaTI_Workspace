package pattern2;

public class Employee {
	private String id;
	private String name;
	private String salary;
	private String department;
	private String city;

	
	public Employee() {
		super();
	}

	public Employee(String id, String name, String salary, String department, String city) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.department = department;
		this.city = city;
	}
	
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", department=" + department + ", city="
				+ city + "]";
	}

}
