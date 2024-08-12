package universityDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mariadb://localhost:3306/University"; // Replace with your DB name
    private static final String USER = "root"; // Replace with your username
    private static final String PASSWORD = "r7159!"; // Replace with your password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
