package dao;

import java.awt.List;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import pojo.Student;

public class DatabaseHelper {
	
	 public static boolean addStudent(Student student){
		 
		 String query=Query.INSERT_STUDENT;
	        try(Connection connection=DatabaseConnection.getConnection();
	              //Allocate statement object in connection
	                PreparedStatement statement = connection.prepareStatement(query); ){
	                statement.setString(1,student.getFirst_name());
	                statement.setString(2,student.getLast_name());
	                statement.setString(3,student.getFather_name());
	                statement.setString(4,student.getEmail_id());
	                statement.setString(5,student.getStudent_class());
	                statement.setInt(6,student.getAge());
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

	public static ArrayList<Student> getAllStudent() {
		 ArrayList<Student> listOfEmployee=new ArrayList<Student>();
	        String query=Query.SHOW_STUDENT;
	        try(Connection connection=DatabaseConnection.getConnection();
	                //Allocate statement object in connection
	                PreparedStatement statement = connection.prepareStatement(query); )
	        {
	            ResultSet result=statement.executeQuery();
	            listOfEmployee=getStudents(result);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return listOfEmployee;
	    }
	    
	 private static ArrayList<Student> getStudents(ResultSet result)
	    {
	        ArrayList<Student> listOfStudent=new ArrayList<Student>();
	        try {
	            while(result.next())
	            {
	                
	                Student student = new Student();
	               
	                student.setFirst_name(result.getString("first_name"));
	                student.setLast_name(result.getString("last_name"));
	                student.setFather_name(result.getString("father_name"));
	                student.setEmail_id(result.getString("email_id"));
	                student.setStudent_class(result.getString("class"));
	                student.setAge(result.getInt("age"));
	                student.setId(result.getInt("id"));
	                
	                listOfStudent.add(student);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return listOfStudent;
	    }

	 public static Student getStudent(int id)
	    {
	       Student student = new Student();
	        String query=Query.SEARCH_STUDENT_BY_ID;
	        try(Connection connection=DatabaseConnection.getConnection();
	                //Allocate statement object in connection
	                PreparedStatement statement = connection.prepareStatement(query); )
	        {
	            statement.setInt(1,id);
	            ResultSet result=statement.executeQuery();
	            student = getStudents(result).get(0);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return student;
	    }
}
