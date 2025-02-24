import java.util.*;

public class task_4 {
    public static void main(String[] args) {
        int[] originalArray = {10, 20, 30, 40, 50, 60, 70, 80};

        // Copying a range of elements (from index 2 to 5)
        int[] copiedArray = Arrays.copyOfRange(originalArray, 2, 6);

        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println("Copied Range Array: " + Arrays.toString(copiedArray));
    }
}
