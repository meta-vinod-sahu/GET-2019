package dao;

public class Query {

	
		 public static final String INSERT_EMPLOYEE="INSERT INTO ADD_EMPLOYEE(employee_name,employee_password,employee_emailid,employee_contact,organization_type,employee_gender)"
	             + "values(?,?,?,?,?,?)";

	public static final String SHOW_STUDENT="SELECT id,first_name,last_name,father_name,email_id,class ,age "
	            + "FROM ADD_STUDENT ";

	public static final String GET_EMAIL_EMPLOYEE="SELECT employee_emailid,employee_password FROM ADD_EMPLOYEE WHERE employee_emailid=? AND employee_password=?";

	public static final String SEARCH_STUDENT_BY_ID="SELECT id, first_name,last_name,father_name,email_id,class,age "
	        + "FROM ADD_STUDENT WHERE id=?";

	public static final String UPDATE_STUDNET="UPDATE ADD_STUDENT "
	                    + " SET first_name=?,last_name=?,father_name=?,email_id=?,class=?,age=? "
	                    + " WHERE id=?";
	
	public static final String INSERT_VEHICLE = "insert into vehicle(name,type,vehicle_number,employee_id,identification) values(?,?,?,?,?)";
	
	public static final String EMP_ID= "select id from add_employee where employee_emailid = ? ";
	
	public static final String VEHICLE_PRICE="select daily,monthly,yearly from pass where type= ? ";
	public static final String GET_FRIEND_EMPLOYEE="select (id,employee_name,employee_password,employee_emailid,employee_contact,organization_type,employee_gender) from employee where organization_type=(select org from employee where employee_emailid=?) AND employee_emailid != ?";
		
	
}
