package universityDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public void createStudent(Student student) throws SQLException {
        String query = "INSERT INTO Students (Name, Major) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getMajor());
            stmt.executeUpdate();
        }
    }

    public Student readStudent(int id) throws SQLException {
        String query = "SELECT * FROM Students WHERE Id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Student(rs.getInt("Id"), rs.getString("Name"), rs.getString("Major"));
            }
        }
        return null;
    }

    public List<Student> readAllStudents() throws SQLException {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM Students";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                students.add(new Student(rs.getInt("Id"), rs.getString("Name"), rs.getString("Major")));
            }
        }
        return students;
    }

    public void updateStudent(Student student) throws SQLException {
        String query = "UPDATE Students SET Name = ?, Major = ? WHERE Id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, student.getName());
            stmt.setString(2, student.getMajor());
            stmt.setInt(3, student.getId());
            stmt.executeUpdate();
        }
    }

    public void deleteStudent(int id) throws SQLException {
        String query = "DELETE FROM Students WHERE Id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
