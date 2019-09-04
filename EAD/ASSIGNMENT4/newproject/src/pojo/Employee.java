package pojo;

public class Employee {

	private String employee_name;
	private String employee_password;
	private String employee_emailid;
	private String employee_contact;
	private String organization_type;
	private String employee_gender;
	private int id;
	
	
	
	
	public Employee() {
		super();
	}
	public Employee(String employee_name, String employee_password, String employee_emailid, String employee_contact,
			String organization_type, String employee_gender) {
		super();
		this.employee_name = employee_name;
		this.employee_password = employee_password;
		this.employee_emailid = employee_emailid;
		this.employee_contact = employee_contact;
		this.organization_type = organization_type;
		this.employee_gender = employee_gender;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmployee_password() {
		return employee_password;
	}
	public void setEmployee_password(String employee_password) {
		this.employee_password = employee_password;
	}
	public String getEmployee_emailid() {
		return employee_emailid;
	}
	public void setEmployee_emailid(String employee_emailid) {
		this.employee_emailid = employee_emailid;
	}
	public String getEmployee_contact() {
		return employee_contact;
	}
	public void setEmployee_contact(String employee_contact) {
		this.employee_contact = employee_contact;
	}
	public String getOrganization_type() {
		return organization_type;
	}
	public void setOrganization_type(String organization_type) {
		this.organization_type = organization_type;
	}
	public String getEmployee_gender() {
		return employee_gender;
	}
	public void setEmployee_gender(String employee_gender) {
		this.employee_gender = employee_gender;
	}
	
	
}
