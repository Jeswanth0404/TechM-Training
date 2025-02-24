import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class rowdeleter {
    public static void main(String[] args) {
        try (Connection connection = DBHelper.connect();
             Scanner scanner = new Scanner(System.in)) {

            System.out.print("Enter Employee ID to remove: ");
            int empId = scanner.nextInt();

            String query = "DELETE FROM employees WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, empId);
                int affectedRows = stmt.executeUpdate();
                System.out.println(affectedRows > 0 ? "Record removed successfully!" : "No record found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
