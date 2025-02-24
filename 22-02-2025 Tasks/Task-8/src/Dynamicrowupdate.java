import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Dynamicrowupdate {
    public static void main(String[] args) {
        try (Connection connection = DBHelper.connect();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter Employee ID to modify: ");
            int empId = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            System.out.print("Enter new Employee Name: ");
            String newName = scanner.nextLine();

            String query = "UPDATE employees SET name = ? WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, newName);
                stmt.setInt(2, empId);
                int affectedRows = stmt.executeUpdate();
                System.out.println(affectedRows > 0 ? "Update successful!" : "No matching record found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
