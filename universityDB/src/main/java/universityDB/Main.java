package universityDB;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final StudentDAO studentDAO = new StudentDAO();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select an operation:");
            System.out.println("1. Create Student");
            System.out.println("2. Read Student");
            System.out.println("3. Read All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Clear the buffer
                switch (choice) {
                    case 1:
                        createStudent(scanner);
                        break;
                    case 2:
                        readStudent(scanner);
                        break;
                    case 3:
                        readAllStudents();
                        break;
                    case 4:
                        updateStudent(scanner);
                        break;
                    case 5:
                        deleteStudent(scanner);
                        break;
                    case 6:
                        return;
                    default:
                        System.out.println("Invalid option, please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear the invalid input
            }
        }
    }

    private static void createStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter student major: ");
        String major = scanner.nextLine();
        Student student = new Student(0, name, major);
        try {
            studentDAO.createStudent(student);
            System.out.println("Student created successfully.");
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    private static void readStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        try {
            Student student = studentDAO.readStudent(id);
            if (student != null) {
                System.out.println("ID: " + student.getId());
                System.out.println("Name: " + student.getName());
                System.out.println("Major: " + student.getMajor());
            } else {
                System.out.println("Student not found.");
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    private static void readAllStudents() {
        try {
            List<Student> students = studentDAO.readAllStudents();
            for (Student student : students) {
                System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Major: " + student.getMajor());
            }
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    private static void updateStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new major: ");
        String major = scanner.nextLine();
        Student student = new Student(id, name, major);
        try {
            studentDAO.updateStudent(student);
            System.out.println("Student updated successfully.");
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Clear the buffer
        try {
            studentDAO.deleteStudent(id);
            System.out.println("Student deleted successfully.");
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
        }
    }
}
