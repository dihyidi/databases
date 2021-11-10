package mvc.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector  {

    private static final String url = "jdbc:mysql://127.0.0.1:3306/koval?user=root&password=root&useUnicode=true&serverTimezone=UTC&characterEncoding=UTF-8&autoReconnect=true&failOverReadOnly=false&maxReconnects=10&useSSL=false";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection connection;

    public static Connection getConnection(){
       try {
                connection = DriverManager.getConnection(url);
            } catch (SQLException e) {
                System.err.println("Error message: " + e.getMessage());
                System.err.println("Error code: " + e.getErrorCode());
                System.err.println("SQL state: " + e.getSQLState());
            }

        return connection;
    }
}
