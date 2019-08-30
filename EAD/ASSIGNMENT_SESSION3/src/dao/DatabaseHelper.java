package dao;


import java.sql.Connection;
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
		 ArrayList<Student> listOfStudent=new ArrayList<Student>();
	        String query=Query.SHOW_STUDENT;
	        try(Connection connection=DatabaseConnection.getConnection();
	                //Allocate statement object in connection
	                PreparedStatement statement = connection.prepareStatement(query); )
	        {
	            ResultSet result=statement.executeQuery();
	            listOfStudent=getStudents(result);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return listOfStudent;
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
	            return listOfStudent;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return listOfStudent;
	    }

	 public static Student getStudent(int id)
	    {
			       Student student = new Student();
	       ArrayList<Student> studentlist=new ArrayList<Student>();
	        String query=Query.SEARCH_STUDENT_BY_ID;
	        try(Connection connection=DatabaseConnection.getConnection();
	                //Allocate statement object in connection
	                PreparedStatement statement = connection.prepareStatement(query); )
	        {
	            statement.setInt(1,id);
	            ResultSet result1=statement.executeQuery();
	           studentlist  = getStudents(result1);
	           student = studentlist.get(0);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return student;
	    }

	public static int updateStudent(int id, String firstName, String lastName,
			String fatherName, String email, String studentClass, int age) {
		String query=Query.UPDATE_STUDENT;
        int updatedRows=0;
       
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
                PreparedStatement statement = connection.prepareStatement(query);){
            try {
    
                statement.setString(1,firstName);
                statement.setString(2,lastName);
                statement.setString(3,fatherName);
                statement.setString(4,email);
                statement.setString(5,studentClass);
                statement.setInt(6,age);
                statement.setInt(7,id);
                updatedRows=statement.executeUpdate();
                
                statement.close();
                connection.close();
                return updatedRows;
            } 
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
                
            }    
        }
        catch (SQLException exception) {
            exception.printStackTrace();
        }
        return updatedRows;
        
	}
	 public static ArrayList<Student> searchStudents(String searchname)
	    {
		 String firstname_query=Query.SEARCH_STUDENT_BYFIRSTNAME;
		 ArrayList<Student> listOfStudent=new ArrayList<Student>();
	        try(Connection connection=DatabaseConnection.getConnection();
	                //Allocate statement object in connection
	        		 PreparedStatement firstname_statement = connection.prepareStatement(firstname_query);){
	       try {
	        	   firstname_statement.setString(1,searchname);
		            firstname_statement.setString(2,searchname);
	            ResultSet result=firstname_statement.executeQuery();
	            listOfStudent=getStudents(result);
	            firstname_statement.close();
                connection.close();
                return listOfStudent;
	       } 
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
                
            }    
        }
	        
	        catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        return listOfStudent;
	    }
	 

	
	
	}

