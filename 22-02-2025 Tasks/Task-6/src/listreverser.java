import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class listreverser {
    public static <T> List<T> reverseElements(List<T> sourceList) {
        List<T> outputList = new ArrayList<>(sourceList);
        Collections.reverse(outputList);
        return outputList;
    }

    public static void main(String[] args) {
        List<Integer> numSeries = List.of(5, 10, 15, 20, 25);
        System.out.println("Reversed List: " + reverseElements(numSeries));

        List<String> wordCollection = List.of("Red", "Blue", "Green");
        System.out.println("Reversed List: " + reverseElements(wordCollection));
    }
}
