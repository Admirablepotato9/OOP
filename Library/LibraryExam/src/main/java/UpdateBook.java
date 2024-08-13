import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateBook {
    public void updateBookTitle(int bookID, String newTitle) {
        String query = "UPDATE Books SET Title = ? WHERE BookID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, newTitle);
            stmt.setInt(2, bookID);
            stmt.executeUpdate();
            System.out.println("Book updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
