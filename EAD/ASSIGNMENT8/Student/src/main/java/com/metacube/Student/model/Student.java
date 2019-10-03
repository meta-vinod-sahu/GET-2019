/*
 * Represents Student
 */
package com.metacube.Student.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public class Student {
	
	@NotBlank(message= "{blankFirstName}")
	String firstName;
	
	@NotBlank(message= "{blankLastName}")
	String lastName;
	
	@NotBlank(message= "{blankFatherName}")
	String fatherName;
	
	@NotEmpty(message= "{validEmail}")
	String email;
	
	@NotBlank
	@Pattern(regexp = "[1-4]",message= "{validStudentClass}")
	String studentClass;
	
	@NotBlank(message= "{blankAge}")
	@Pattern(regexp = "[0-9]+",message= "{validAge}")
	String age;

	public Student() {}

	public Student(String firstName, String lastName, String fatherName,
			String email, String studentClass, String age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.fatherName = fatherName;
		this.email = email;
		this.studentClass = studentClass;
		this.age = age;
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
