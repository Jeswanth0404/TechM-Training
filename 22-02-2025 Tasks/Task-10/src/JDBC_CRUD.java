import java.sql.*;
import java.util.Scanner;

public class JDBC_CRUD {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void insertRecord(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        String query = "INSERT INTO students (id, name) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.executeUpdate();
            System.out.println("Record inserted successfully.");
        }
    }

    public static void updateRecord(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter New Name: ");
        String name = scanner.nextLine();

        String query = "UPDATE students SET name = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, id);
            int updated = stmt.executeUpdate();
            System.out.println(updated > 0 ? "Record updated successfully." : "Record not found.");
        }
    }

    public static void deleteRecord(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter Student ID to delete: ");
        int id = scanner.nextInt();

        String query = "DELETE FROM students WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            int deleted = stmt.executeUpdate();
            System.out.println(deleted > 0 ? "Record deleted successfully." : "Record not found.");
        }
    }

    public static void readRecords(Connection conn) throws SQLException {
        String query = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }
        }
    }

    public static void main(String[] args) {
        try (Connection conn = getConnection();
             Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nMenu:\n1. Insert\n2. Update\n3. Delete\n4. Read\n5. Exit");
                System.out.print("Enter choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> insertRecord(conn, scanner);
                    case 2 -> updateRecord(conn, scanner);
                    case 3 -> deleteRecord(conn, scanner);
                    case 4 -> readRecords(conn);
                    case 5 -> System.exit(0);
                    default -> System.out.println("Invalid choice! Try again.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
