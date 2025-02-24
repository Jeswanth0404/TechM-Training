import java.util.*;
import java.io.*;
public class ExceptionalHandling {
    public static void throwException() {
        try {
            throw new Exception("This is an exception");
        } catch (Exception e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    public static void checkOddNumber(int num) throws Exception {
        if (num % 2 != 0) {
            throw new Exception("Number is odd");
        } else {
            System.out.println("Number is even");
        }
    }

    public static void readFile(String filePath) throws FileNotFoundException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found");
        }
        System.out.println("File found");
    }

    public static void checkPositiveNumbersInFile(String filePath) throws Exception {
        File file = new File(filePath);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextInt()) {
            int num = scanner.nextInt();
            if (num > 0) {
                scanner.close();
                throw new Exception("File contains positive numbers");
            }
        }
        scanner.close();
        System.out.println("No positive numbers found");
    }

    public static void checkEmptyFile(String filePath) throws Exception {
        File file = new File(filePath);
        if (file.length() == 0) {
            throw new Exception("File is empty");
        }
        System.out.println("File is not empty");
    }

    public static void main(String[] args) {
        throwException();

        try {
            checkOddNumber(5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            readFile("test.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            checkPositiveNumbersInFile("numbers.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            checkEmptyFile("empty.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
