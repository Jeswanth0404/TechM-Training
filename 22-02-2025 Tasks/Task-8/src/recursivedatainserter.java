import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class recursivedatainserter {
    public static void insertRecords(Connection connection, Scanner scanner, int remaining) throws SQLException {
        if (remaining <= 0) return;

        System.out.print("Enter Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter Employee Name: ");
        String empName = scanner.nextLine();

        String query = "INSERT INTO employees (id, name) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, empId);
            stmt.setString(2, empName);
            stmt.executeUpdate();
            System.out.println("Data successfully inserted!");
        }

        System.out.print("Would you like to add another entry? (yes/no): ");
        String userInput = scanner.nextLine();
        if (userInput.equalsIgnoreCase("yes")) {
            insertRecords(connection, scanner, remaining - 1);
        }
    }

    public static void main(String[] args) {
        try (Connection connection = DBHelper.connect();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter the number of records to insert: ");
            int totalRecords = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            insertRecords(connection, scanner, totalRecords);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
