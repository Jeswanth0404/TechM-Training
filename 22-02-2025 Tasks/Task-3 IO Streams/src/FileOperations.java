import java.nio.file.*;
import java.util.*;
import java.io.*;

public class FileOperations {
    public static void listFiles(String dirPath) {
        File dir = new File(dirPath);
        if (dir.exists() && dir.isDirectory()) {
            String[] files = dir.list();
            System.out.println("Files: ");
            for (String file : files) {
                System.out.println(file);
            }
        }
    }

    public static void listSpecificFiles(String dirPath, String extension) {
        File dir = new File(dirPath);
        if (dir.exists() && dir.isDirectory()) {
            FilenameFilter filter = (d, name) -> name.endsWith(extension);
            String[] files = dir.list(filter);
            System.out.println("Filtered Files: ");
            for (String file : files) {
                System.out.println(file);
            }
        }
    }

    public static void checkFileExists(String path) {
        File file = new File(path);
        System.out.println(file.exists() ? "Exists" : "Does not exist");
    }

    public static void checkPermissions(String path) {
        File file = new File(path);
        System.out.println("Readable: " + file.canRead() + ", Writable: " + file.canWrite());
    }

    public static void checkIfDirectoryOrFile(String path) {
        File file = new File(path);
        System.out.println(file.isDirectory() ? "Directory" : file.isFile() ? "File" : "Invalid path");
    }

    public static void getLastModifiedDate(String path) {
        File file = new File(path);
        if (file.exists()) {
            System.out.println("Last Modified: " + new Date(file.lastModified()));
        }
    }

    public static void readFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter input: ");
        String input = scanner.nextLine();
        System.out.println("You entered: " + input);
    }

    public static void getFileSize(String path) {
        File file = new File(path);
        if (file.exists()) {
            long bytes = file.length();
            System.out.println("Size: " + bytes + " Bytes, " + (bytes / 1024.0) + " KB, " + (bytes / 1048576.0) + " MB");
        }
    }

    public static void readFileToByteArray(String path) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        System.out.println("File content in bytes: " + bytes.length);
    }

    public static void readFileLineByLine(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void readPlainTextFile(String path) throws IOException {
        System.out.println(new String(Files.readAllBytes(Paths.get(path))));
    }

    public static void main(String[] args) throws IOException {
        listFiles(".");
        listSpecificFiles(".", ".txt");
        checkFileExists("test.txt");
        checkPermissions("test.txt");
        checkIfDirectoryOrFile("test.txt");
        getLastModifiedDate("test.txt");
        readFromConsole();
        getFileSize("test.txt");
        readFileToByteArray("test.txt");
        readFileLineByLine("test.txt");
        readPlainTextFile("test.txt");
    }
}
