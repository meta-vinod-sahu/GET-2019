package com.metacube.hibernateStudent.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.hibernateStudent.dao.StudentDao;
import com.metacube.hibernateStudent.model.Student;
import com.metacube.hibernateStudent.util.DTOUtil;

@Controller
public class HibernateController {
    
	@Autowired
	StudentDao studentdao;
	
	/*
	 * @Autowired public void getStudentDao(StudentDao dao) { this.studentdao = dao;
	 * }
	 */
	
	@GetMapping("index")
	public String getIndexPage() {
		return "index";
	}
	
	@GetMapping("/addstudent")
	public String getAddStudent(Model model) {
		model.addAttribute(new Student());
		return "addstudent";
	}
	
	@PostMapping("/addStudentPost")
	public String addStudentPost(@Validated Student student , BindingResult bindingResult,RedirectAttributes attribute) {
		
	if(bindingResult.hasErrors()) {
		return "addstudent";
	}
	else {
		studentdao.addStudent(student);
		attribute.addFlashAttribute("message", "Student added");
		
	 int result=studentdao.addStudent(student);
	  if(result>0) {
		  return "index";
	  }
	  else {
		  
		  ObjectError objectError = new ObjectError("global", "User Already Exist");
		  bindingResult.addError(objectError);
		  return "addstudent";
	  }
		
	}
	}
	
	@GetMapping("/showstudent")
	public String getAllStudentPage(Model model) {
		List<Student> studentList = new ArrayList<>();
		studentList = studentdao.getAll();
		model.addAttribute("students", studentList);
		return "showstudent";
	}
	
	
}

