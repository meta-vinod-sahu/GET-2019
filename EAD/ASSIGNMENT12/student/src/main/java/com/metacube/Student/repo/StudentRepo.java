/**
 * Repository
 */
package com.metacube.Student.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.metacube.Student.model.Student;

@Repository
public interface StudentRepo extends CrudRepository<Student,Integer>{

	public List<Student> findByfirstNameContainingIgnoreCase(String key);
}
