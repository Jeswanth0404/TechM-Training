import java.util.ArrayList;
import java.util.List;

public class AlternatingMerger {
    public static <T> List<T> interleaveLists(List<T> firstList, List<T> secondList) {
        List<T> combinedList = new ArrayList<>();
        int maxLength = Math.max(firstList.size(), secondList.size());

        for (int i = 0; i < maxLength; i++) {
            if (i < firstList.size()) {
                combinedList.add(firstList.get(i));
            }
            if (i < secondList.size()) {
                combinedList.add(secondList.get(i));
            }
        }
        return combinedList;
    }

    public static void main(String[] args) {
        List<Integer> listOne = List.of(2, 4, 6);
        List<Integer> listTwo = List.of(1, 3, 5, 7, 9);

        System.out.println("Merged List: " + interleaveLists(listOne, listTwo));

        List<String> alphaList = List.of("A", "C", "E");
        List<String> betaList = List.of("B", "D", "F", "G");

        System.out.println("Merged List: " + interleaveLists(alphaList, betaList));
    }
}
