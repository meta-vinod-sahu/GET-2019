package dao;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;




public class DatabaseConnection {

	 /**
     * Create database connection using JDBC driver
     * @return returns connection Instance 
     */
    public static Connection getConnection()
    {
          Connection connection = null;
        try
        {
            //register JDBC Driver
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost/employee";
            String userName="root";
            String password="root";
            //opens connection
            connection =  DriverManager.getConnection(url, userName, password);
        }
        catch (ClassNotFoundException classNotFoundException)
        {
            classNotFoundException.printStackTrace();
        } 
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return connection;
    }
}
