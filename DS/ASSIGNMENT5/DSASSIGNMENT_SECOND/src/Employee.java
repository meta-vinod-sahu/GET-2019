/**
 * 
 * store the employee detail
 *
 */
public class Employee {
	private int empId;
	private String name;
	private int salary;
	private int age;

	public Employee(int empId, String name, int salary, int age) {
		this.empId = empId;
		this.name = name;
		this.salary = salary;
		this.age = age;
	}

	// get employeeId
	public int getEmpId() {
		return empId;
	}

	/**
	 * @param empId set employeeId
	 */
	public void setEmpId(int empId) {
		this.empId = empId;
	}

	/**
	 * @return name of the employee
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            set employee name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return salary of the employee
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param salary set salary of the employee
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

	/**
	 * @return age of the employee
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age set age of the employee
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * display employee info
	 */
	public void displayEmployeeInfo() {
		System.out.println("Employee Id: " + empId);
		System.out.println("Employee Name: " + name);
		System.out.println("Employee Salary: " + salary);
		System.out.println("Employee Age: " + age);
	}

}