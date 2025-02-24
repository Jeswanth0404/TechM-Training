import java.sql.*;
import java.util.Scanner;

public class DatabaseMenu {
    public static void addNewRecord(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee ID: ");
        int empId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Employee Name: ");
        String empName = scanner.nextLine();

        String query = "INSERT INTO employees (id, name) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, empId);
            stmt.setString(2, empName);
            stmt.executeUpdate();
            System.out.println("Data successfully inserted!");
        }
    }

    public static void modifyRecord(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee ID to update: ");
        int empId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new Employee Name: ");
        String newName = scanner.nextLine();

        String query = "UPDATE employees SET name = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, newName);
            stmt.setInt(2, empId);
            int affectedRows = stmt.executeUpdate();
            System.out.println(affectedRows > 0 ? "Update successful!" : "No matching record found.");
        }
    }

    public static void removeRecord(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee ID to delete: ");
        int empId = scanner.nextInt();

        String query = "DELETE FROM employees WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, empId);
            int affectedRows = stmt.executeUpdate();
            System.out.println(affectedRows > 0 ? "Record removed successfully!" : "No matching entry found.");
        }
    }

    public static void fetchRecord(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter Employee ID to retrieve: ");
        int empId = scanner.nextInt();

        String query = "SELECT * FROM employees WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, empId);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name"));
            } else {
                System.out.println("No entry found for the given ID.");
            }
        }
    }

    public static void main(String[] args) {
        try (Connection connection = DBHelper.connect();
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.println("\nMENU");
                System.out.println("1. Insert New Record");
                System.out.println("2. Update Existing Record");
                System.out.println("3. Delete Record");
                System.out.println("4. Retrieve Record");
                System.out.println("5. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addNewRecord(connection, scanner);
                        break;
                    case 2:
                        modifyRecord(connection, scanner);
                        break;
                    case 3:
                        removeRecord(connection, scanner);
                        break;
                    case 4:
                        fetchRecord(connection, scanner);
                        break;
                    case 5:
                        System.out.println("Exiting program...");
                        return;
                    default:
                        System.out.println("Invalid selection! Please choose a valid option.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
