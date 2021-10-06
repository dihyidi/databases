package mvc.model.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector  {

    private static final String url = "jdbc:mysql://localhost:3306/koval";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection connection;

    private static Connection getConnection(){
        try{
            connection = DriverManager.getConnection(url, user, password);
        }
        catch (SQLException e){
            System.err.println("Error message: " + e.getMessage());
            System.err.println("Error code: " + e.getErrorCode());
            System.err.println("SQL state: " + e.getSQLState());
        }
        return connection;
    }
}
