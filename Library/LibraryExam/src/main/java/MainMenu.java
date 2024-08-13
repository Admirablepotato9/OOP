import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CreateBook createBook = new CreateBook();
        ReadBooks readBooks = new ReadBooks();
        UpdateBook updateBook = new UpdateBook();
        DeleteBook deleteBook = new DeleteBook();

        while (true) {
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Update Book");
            System.out.println("4. Delete Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter BookID: ");
                    int bookID = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Publisher: ");
                    String publisher = scanner.nextLine();
                    createBook.addBook(bookID, title, author, publisher);
                    break;
                case 2:
                    readBooks.getAllBooks();
                    break;
                case 3:
                    System.out.print("Enter BookID: ");
                    int updateBookID = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter new Title: ");
                    String newTitle = scanner.nextLine();
                    updateBook.updateBookTitle(updateBookID, newTitle);
                    break;
                case 4:
                    System.out.print("Enter BookID to delete: ");
                    int deleteBookID = scanner.nextInt();
                    deleteBook.deleteBook(deleteBookID);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
