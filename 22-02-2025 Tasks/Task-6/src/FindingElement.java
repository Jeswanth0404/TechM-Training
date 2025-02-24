import java.util.List;

public class FindingElement {
    public static <T> int searchIndex(List<T> collection, T key) {
        for (int index = 0; index < collection.size(); index++) {
            if (collection.get(index).equals(key)) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<String> namesList = List.of("John", "Emily", "Michael", "Sophia");
        System.out.println("Position of 'Michael': " + searchIndex(namesList, "Michael"));
        System.out.println("Position of 'Liam': " + searchIndex(namesList, "Liam"));
    }
}
