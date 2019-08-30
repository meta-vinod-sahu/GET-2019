public class Employee {
	private Integer empId;
	private String name;
	private String address;

	public Employee() {
	};

	public Employee(Integer empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}