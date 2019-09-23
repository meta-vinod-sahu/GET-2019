/**
 * Represents Student
 */
package com.metacube.Student.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	
	@Column(name="first_name")
	@NotBlank(message= "{blankFirstName}")
	String firstName;
	
	@Column(name="last_name")
	@NotBlank(message= "{blankLastName}")
	String lastName;
	
	@Column(name="father_name")
	@NotBlank(message= "{blankFatherName}")
	String fatherName;
	
	@Column(name="email")
	@Email(message= "{validEmail}")
	String email;
	
	@Column(name="class")
	@NotBlank
	@Pattern(regexp = "[1-4]",message= "{validStudentClass}")
	String studentClass;
	
	@Column(name="age")
	@NotBlank(message= "{blankAge}")
	@Pattern(regexp = "[0-9]+",message= "{validAge}")
	String age;

	public Student() {}

	public Student(int id,String firstName,String lastName,String fatherName,String email,String studentClass, String age) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.email = email;
		this.studentClass = studentClass;
		this.age = age;
	}

	public Student(String firstName,String lastName,String fatherName,String email,String studentClass, String age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.email = email;
		this.studentClass = studentClass;
		this.age = age;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStudentClass() {
		return studentClass;
	}

	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
}
