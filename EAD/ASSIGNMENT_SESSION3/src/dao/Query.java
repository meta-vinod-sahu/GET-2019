package dao;

public class Query {
	 public static final String INSERT_STUDENT="INSERT INTO ADD_STUDENT(first_name,last_name,father_name,email_id,class,age) "
             + "values(?,?,?,?,?,?)";

public static final String SHOW_STUDENT="SELECT id,first_name,last_name,father_name,email_id,class ,age "
            + "FROM ADD_STUDENT ";

public static final String SEARCH_STUDENT_BYFIRSTNAME="SELECT id,first_name,last_name,father_name,email_id,class,age FROM ADD_STUDENT WHERE first_name=? OR last_name=? ORDER BY class";



public static final String SEARCH_STUDENT_BY_ID="SELECT id, first_name,last_name,father_name,email_id,class,age "
        + "FROM ADD_STUDENT WHERE id=?";

public static final String UPDATE_STUDENT="UPDATE ADD_STUDENT SET first_name=?,last_name=?,father_name=?,email_id=?,class=?,age=? WHERE id=?";

}
