package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Employee;




public class DatabaseHelper {
	
	 public static boolean addEmployee(Employee employee){
		 
		 String query=Query.INSERT_EMPLOYEE;
	        try(Connection connection=DatabaseConnection.getConnection();
	              //Allocate statement object in connection
	                PreparedStatement statement = connection.prepareStatement(query); ){
	               statement.setString(1,employee.getEmployee_name());
	               statement.setString(2,employee.getEmployee_password());
	               statement.setString(3,employee.getEmployee_emailid());
	               statement.setString(4,employee.getEmployee_contact());
	               statement.setString(5,employee.getOrganization_type());
	               statement.setString(6,employee.getEmployee_gender());
	                int rs=statement.executeUpdate();
	                
	                if(rs>0)
	                {
	                	return true;
	                }
	                else {
	                	return false;
	                }
	               
	                
	        }
	        catch (SQLException exception) {
	            exception.printStackTrace();
	        }
	        return false;
		 
		
		 
	 }
	 
	 private static ArrayList<Employee> getEmployees(ResultSet result)
	    {
	        ArrayList<Employee> listOfEmployee=new ArrayList<Employee>();
	        try {
	            while(result.next())
	            {
	                
	                Employee employee = new Employee();
	               
	                employee.setEmployee_emailid(result.getString("employee_emailid"));
	                employee.setEmployee_password(result.getString("employee_password"));
	              
	                
	                listOfEmployee.add(employee);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return listOfEmployee;
	    }


	public static  ArrayList<Employee>  getEmployee(String employee_name, String employee_confirm_password) {
		
		 String query=Query.GET_EMAIL_EMPLOYEE;
		 ResultSet resultSet = null;
		 ArrayList<Employee> listOfEmployee=new ArrayList<Employee>();
	        try(Connection connection=DatabaseConnection.getConnection();
	              //Allocate statement object in connection
	                PreparedStatement statement = connection.prepareStatement(query); ){
	               statement.setString(1,employee_name);
	               statement.setString(2,employee_confirm_password);
	              
	               resultSet=statement.executeQuery();
	               listOfEmployee = getEmployees(resultSet);
	                
	               return listOfEmployee;
	               
	                
	        }
	        catch (SQLException exception) {
	            exception.printStackTrace();
	        }
	        
	        return listOfEmployee;
		 
	}

	/*
	 * public static ArrayList<Student> getAllStudent() { ArrayList<Student>
	 * listOfEmployee=new ArrayList<Student>(); String query=Query.SHOW_STUDENT;
	 * try(Connection connection=DatabaseConnection.getConnection(); //Allocate
	 * statement object in connection PreparedStatement statement =
	 * connection.prepareStatement(query); ) { ResultSet
	 * result=statement.executeQuery(); listOfEmployee=getStudents(result); } catch
	 * (SQLException e) { e.printStackTrace(); } return listOfEmployee; }
	 * 
	 * private static ArrayList<Student> getStudents(ResultSet result) {
	 * ArrayList<Student> listOfStudent=new ArrayList<Student>(); try {
	 * while(result.next()) {
	 * 
	 * Student student = new Student();
	 * 
	 * student.setFirst_name(result.getString("first_name"));
	 * student.setLast_name(result.getString("last_name"));
	 * student.setFather_name(result.getString("father_name"));
	 * student.setEmail_id(result.getString("email_id"));
	 * student.setStudent_class(result.getString("class"));
	 * student.setAge(result.getInt("age")); student.setId(result.getInt("id"));
	 * 
	 * listOfStudent.add(student); } } catch (SQLException e) { e.printStackTrace();
	 * } return listOfStudent; }
	 * 
	 * public static Student getStudent(int id) { Student student = new Student();
	 * String query=Query.SEARCH_STUDENT_BY_ID; try(Connection
	 * connection=DatabaseConnection.getConnection(); //Allocate statement object in
	 * connection PreparedStatement statement = connection.prepareStatement(query);
	 * ) { statement.setInt(1,id); ResultSet result=statement.executeQuery();
	 * student = getStudents(result).get(0); } catch (SQLException e) {
	 * e.printStackTrace(); } return student; }
	 * 
	 * public static int updateStudent(int id, String firstName, String lastName,
	 * String fatherName, String email, String studentClass, int age) { // TODO
	 * Auto-generated method stub return 0; }
	 */
}
