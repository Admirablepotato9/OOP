import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadBooks {
    public void getAllBooks() {
        String query = "SELECT * FROM Books";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("BookID: " + rs.getInt("BookID"));
                System.out.println("Title: " + rs.getString("Title"));
                System.out.println("Author: " + rs.getString("Author"));
                System.out.println("Publisher: " + rs.getString("Publisher"));
                System.out.println("-----------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
