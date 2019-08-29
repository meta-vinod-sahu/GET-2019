package pojo;

public class Student {
 
	private String first_name;
	private String last_name;
	private String father_name;
	private String email_id;
	private String student_class;
	private int age;
	private int id;
	
	
	
	

	public Student(String first_name, String last_name, String father_name,
			String email_id, String student_class, int age) {
		
		this.first_name = first_name;
		this.last_name = last_name;
		this.father_name = father_name;
		this.email_id = email_id;
		this.student_class = student_class;
		this.age = age;
	}
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	

	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFather_name() {
		return father_name;
	}
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getStudent_class() {
		return student_class;
	}
	public void setStudent_class(String student_class) {
		this.student_class = student_class;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
