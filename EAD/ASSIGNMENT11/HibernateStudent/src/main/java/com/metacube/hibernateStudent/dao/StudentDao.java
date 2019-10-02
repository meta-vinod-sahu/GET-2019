package com.metacube.hibernateStudent.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;


import com.metacube.hibernateStudent.model.Student;

@Repository
public class StudentDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	public StudentDao() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	  public void getHibernateTemplate(HibernateTemplate hibernateTemplate) {
	  this.hibernateTemplate = hibernateTemplate; }
	
	
	public int addStudent(Student student) {
		
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		return (int) session.save(student);
		
		
		
	}
	
	public List<Student> getAll(){
		/*Session session = hibernateTemplate.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Query<Student> query = session.createQuery("from Student");*/
		return hibernateTemplate.loadAll(Student.class);		
	}
	
}
