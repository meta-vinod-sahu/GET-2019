package com.metacube.hibernateStudent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="add_student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	 int id;
	
	@NotBlank(message ="name must be filled out")
	@Column(name="first_name")
	String firstName;
	
	@NotBlank(message ="name must be filled out")
	@Column(name="last_name")
	String lastName;
	
	@NotBlank(message ="name must be filled out")
	@Column(name="father_name")
	String fatherName;
	
	@NotBlank(message ="name must be filled out")
	@Column(name="email_id")
	String email;
	

	@NotBlank(message ="name must be filled out")	
	@Column(name="class")
	String studentClass;
	
	@NotBlank(message ="name must be filled out")
	@Column(name="age")
	String studentAge;
	
	/**
	 * 
	 */
	public Student() {
	}
	
	/**
	 * 
	 * @return String
	 */
	public String getStudentAge() {
		return this.studentAge;
	}
	
	/**
	 * 
	 * @param studentAge
	 */
	public void setStudentAge(String studentAge) {
		this.studentAge = studentAge;
	}
	
	/**
	 * 
	 * @return int
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 * @return String
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 
	 * @return String
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 
	 * @return String
	 */
	public String getFatherName() {
		return this.fatherName;
	}

	/**
	 * 
	 * @param fatherName
	 */
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	/**
	 * 
	 * @return String
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 
	 * @return String
	 */
	public String getStudentClass() {
		return this.studentClass;
	}

	/**
	 * 
	 * @param studentClass
	 */
	public void setStudentClass(String studentClass) {
		this.studentClass = studentClass;
	}
}
