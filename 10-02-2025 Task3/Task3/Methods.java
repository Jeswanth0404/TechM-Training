import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Methods {

    public static void BufferedReaderMethod() {
        try {
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter text using BufferedReader: ");
            String str = bf.readLine(); // Read a line of text
            System.out.println("You entered: \"" + str + "\" using BufferedReader.");
        } catch (Exception e) {
            System.err.println("Error reading input: " + e.getMessage());
        }
    }

    public static void scannerMethod() {
        Scanner sc = new Scanner(System.in);

        // Reading string input
        System.out.print("Enter a string: ");
        String s1 = sc.nextLine();
        System.out.println("You entered: \"" + s1 + "\"");

        // Reading integer input
        System.out.print("Enter an integer: ");
        while (!sc.hasNextInt()) {
            System.out.print("Invalid input! Please enter a valid integer: ");
            sc.next(); // Discard invalid input
        }
        int a = sc.nextInt();
        System.out.println("You entered integer: " + a);

        // Reading float input
        System.out.print("Enter a float: ");
        while (!sc.hasNextFloat()) {
            System.out.print("Invalid input! Please enter a valid float: ");
            sc.next(); // Discard invalid input
        }
        float f = sc.nextFloat();
        System.out.println("You entered float: " + f);

        sc.close(); // Close Scanner
    }

    public static void main(String[] args) {
        BufferedReaderMethod();
        scannerMethod();
    }
}

