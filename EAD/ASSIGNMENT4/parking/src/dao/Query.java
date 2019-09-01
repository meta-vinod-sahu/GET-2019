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
}
