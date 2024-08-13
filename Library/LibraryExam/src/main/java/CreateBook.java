import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateBook {
    public void addBook(int bookID, String title, String author, String publisher) {
        String query = "INSERT INTO Books (BookID, Title, Author, Publisher) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, bookID);
            stmt.setString(2, title);
            stmt.setString(3, author);
            stmt.setString(4, publisher);
            stmt.executeUpdate();
            System.out.println("Book added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
