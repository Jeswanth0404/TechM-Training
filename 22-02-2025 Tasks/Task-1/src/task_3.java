import java.util.*;

public class task_3 {
    public static void main(String[] args) {
        // Simple Integer comparison
        Integer a = 5, b = 5;
        System.out.println("a.equals(b): " + a.equals(b)); // true

        // Comparing one-dimensional arrays
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 3};

        System.out.println("Arrays.equals(arr1, arr2): " + Arrays.equals(arr1, arr2)); // true
        System.out.println("Arrays.deepEquals(arr1, arr2): " + Arrays.deepEquals(new Object[]{arr1}, new Object[]{arr2})); // true

        // Comparing multi-dimensional arrays
        Integer[][] nestedArr1 = {{1, 2}, {3, 4}};
        Integer[][] nestedArr2 = {{1, 2}, {3, 4}};

        System.out.println("nestedArr1.equals(nestedArr2): " + nestedArr1.equals(nestedArr2)); // false (reference comparison)
        System.out.println("Arrays.equals(nestedArr1, nestedArr2): " + Arrays.equals(nestedArr1, nestedArr2)); // false
        System.out.println("Arrays.deepEquals(nestedArr1, nestedArr2): " + Arrays.deepEquals(nestedArr1, nestedArr2)); // true
    }
}
