import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // 1. Calculate the average of a list of integers using streams
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);
        double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0);
        System.out.println("Average: " + average);

        // 2. Convert a list of strings to uppercase and lowercase using streams
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        List<String> upperCaseWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        List<String> lowerCaseWords = words.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println("Uppercase: " + upperCaseWords);
        System.out.println("Lowercase: " + lowerCaseWords);

        // 3. Calculate the sum of all even and odd numbers in a list using streams
        int sumEven = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
        int sumOdd = numbers.stream().filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum();
        System.out.println("Sum of even numbers: " + sumEven);
        System.out.println("Sum of odd numbers: " + sumOdd);

        // 4. Remove all duplicate elements from a list using streams
        List<Integer> numbersWithDuplicates = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> uniqueNumbers = numbersWithDuplicates.stream().distinct().collect(Collectors.toList());
        System.out.println("Unique numbers: " + uniqueNumbers);

        // 5. Count the number of strings that start with a specific letter using streams
        long countA = words.stream().filter(word -> word.startsWith("a")).count();
        System.out.println("Count of words starting with 'a': " + countA);

        // 6. Sort a list of strings in ascending and descending order using streams
        List<String> sortedAsc = words.stream().sorted().collect(Collectors.toList());
        List<String> sortedDesc = words.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Sorted Ascending: " + sortedAsc);
        System.out.println("Sorted Descending: " + sortedDesc);

        // 7. Find the maximum and minimum values in a list of integers using streams
        int max = numbers.stream().max(Integer::compare).orElseThrow(NoSuchElementException::new);
        int min = numbers.stream().min(Integer::compare).orElseThrow(NoSuchElementException::new);
        System.out.println("Max value: " + max);
        System.out.println("Min value: " + min);
    }
}
