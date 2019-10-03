package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pojo.Employee;
import pojo.Vehicle;

public class DatabaseHelper {
	
	public static boolean addVehicle(Vehicle v){
		
		String query=Query.INSERT_VEHICLE;

		
        try(Connection connection=DatabaseConnection.getConnection();
              //Allocate statement object in connection
        		PreparedStatement p = connection.prepareStatement(query);
        		){
			p.setString(1, v.getName());
			p.setString(2, v.getType());
			p.setInt(3, v.getVehicle_number());
			p.setInt(4, v.getEmployee_id());
			p.setString(5, v.getIdentification());
			p.execute();
			
			
            return true;    
                
        }
        catch (SQLException exception) {
            exception.printStackTrace();
            return false;
            
        }
      
	}

	public static double[] getVehiclePrice(String type){
		String query1 = Query.VEHICLE_PRICE;
		double[] price = new double[3];
		
		try(Connection connection=DatabaseConnection.getConnection();
				PreparedStatement p =connection.prepareStatement(query1);){
			     p.setString(1,type);
			ResultSet res = p.executeQuery();
			if(res.next()){
				price[0] = res.getDouble("daily");
				price[1] = res.getDouble("monthly");
				price[2] = res.getDouble("yearly");
			} 		
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return price;
	}
 public static int addEmployee(Employee employee){
		 
		 String query=Query.INSERT_EMPLOYEE;
		 String query1=Query.EMP_ID;
		 int id = 0;
	        try(Connection connection=DatabaseConnection.getConnection();
	              //Allocate statement object in connection
	                PreparedStatement statement = connection.prepareStatement(query);
	        		PreparedStatement p = connection.prepareStatement(query1);){
	               statement.setString(1,employee.getEmployee_name());
	               statement.setString(2,employee.getEmployee_password());
	               statement.setString(3,employee.getEmployee_emailid());
	               statement.setString(4,employee.getEmployee_contact());
	               statement.setString(5,employee.getOrganization_type());
	               statement.setString(6,employee.getEmployee_gender());
	               statement.execute();
	               
	               p.setString(1, employee.getEmployee_emailid());
	               
	                ResultSet res = p.executeQuery();
	    			if(res.next()){
	    				id = res.getInt("id");
	    			}
	    			else
	    			{
	    				System.out.println("hello to other side");
	    			}
	        }
	        
	        catch (SQLException exception) {
	            exception.printStackTrace();
	        }
	        return id;
		 
		
		 
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

	public static Employee getEmployee(int id) {
		
		return null;
	}

	public static ArrayList<Employee> getFriend(String email2){
		ArrayList<Employee> e = new ArrayList<Employee>();
		 String query=Query.GET_FRIEND_EMPLOYEE;
		try (Connection connection=DatabaseConnection.getConnection();
        //Allocate statement object in connection
          PreparedStatement statement = connection.prepareStatement(query);){
		
			 statement.setString(1,email2);
             statement.setString(2,email2);
			ResultSet res = statement.executeQuery();
			while(res.next()){
				int id = res.getInt("id");
				String full_name = res.getString("employee_name");
				String gender = res.getString("employee_gender");
				String email = res.getString("employee_emailid");
				String password = res.getString("employee_password");
				String contact_number = res.getString("employee_contact");
				String org = res.getString("organization_type");
				e.add(new Employee(full_name,password,email,contact_number,org,gender,id));
				
			}
			return e;
		} catch (SQLException exc) {
			exc.printStackTrace();
		}

		return e;
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
