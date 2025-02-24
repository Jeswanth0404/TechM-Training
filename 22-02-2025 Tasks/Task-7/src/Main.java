import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 1. Create an ArrayList and add colors
        ArrayList<String> colors = new ArrayList<>();
        colors.add("Red");
        colors.add("Blue");
        colors.add("Green");
        colors.add("Yellow");
        System.out.println("Colors: " + colors);

        // 2. Iterate through elements in an ArrayList
        for (String color : colors) {
            System.out.println(color);
        }

        // 3. Insert an element at the first position
        colors.add(0, "Black");
        System.out.println("After inserting at first position: " + colors);

        // 4. Retrieve an element at a specified index
        System.out.println("Element at index 2: " + colors.get(2));

        // 5. Update an array element
        colors.set(1, "White");
        System.out.println("After update: " + colors);

        // 6. Remove the third element
        colors.remove(2);
        System.out.println("After removing third element: " + colors);

        // 7. Search for an element
        System.out.println("Contains Blue? " + colors.contains("Blue"));

        // 8. Sort the ArrayList
        Collections.sort(colors);
        System.out.println("Sorted Colors: " + colors);

        // 9. Copy one list to another
        ArrayList<String> newColors = new ArrayList<>(colors);
        System.out.println("Copied List: " + newColors);

        // 10. Shuffle elements
        Collections.shuffle(colors);
        System.out.println("Shuffled Colors: " + colors);

        // 11-20. LinkedList operations
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Apple");
        linkedList.add("Banana");
        linkedList.add("Cherry");
        linkedList.add("Date");

        // 11. Append an element to the end
        linkedList.add("Elderberry");
        System.out.println("Linked List: " + linkedList);

        // 12. Iterate through elements
        for (String fruit : linkedList) {
            System.out.println(fruit);
        }

        // 13. Iterate from a specified position
        ListIterator<String> iterator = linkedList.listIterator(2);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 14. Iterate in reverse order
        Iterator<String> descIterator = linkedList.descendingIterator();
        while (descIterator.hasNext()) {
            System.out.println(descIterator.next());
        }

        // 15. Insert at a specified position
        linkedList.add(2, "Fig");
        System.out.println("After insertion: " + linkedList);

        // 16. Insert at first and last position
        linkedList.addFirst("Grape");
        linkedList.addLast("Honeydew");
        System.out.println("After adding first and last: " + linkedList);

        // 17. Insert at the front
        linkedList.offerFirst("Indigo");
        System.out.println("After inserting at front: " + linkedList);

        // 18. Insert at the end
        linkedList.offerLast("Jackfruit");
        System.out.println("After inserting at end: " + linkedList);

        // 19. Insert multiple elements at a specified position
        linkedList.addAll(3, Arrays.asList("Kiwi", "Lemon"));
        System.out.println("After inserting multiple elements: " + linkedList);

        // 20. Get first and last occurrence
        System.out.println("First Element: " + linkedList.getFirst());
        System.out.println("Last Element: " + linkedList.getLast());
    }
}
