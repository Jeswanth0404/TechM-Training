import java.util.*;
public class set {
    public static void setSample(TreeSet<Double> ts1) {
        Set<Double> ts = new TreeSet<>();
        ts.add(10.5);
        ts.add(20.5);
        ts.add(0.5);
        ts.add(4.5);
        ts.add(0.5);
        ts.add(61.9);
        ts.add(0.9);
        System.out.println("TreeSet Size: " + ts.size());
        System.out.println("Elements in TreeSet: " + ts);
        System.out.print("Using iterator : ");
        Iterator<Double> iterator = ts.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
        System.out.println();
        ts.remove(0.5);
        System.out.println("\nTreeSet after removing element : " + ts);
        System.out.print("Using enhanced for loop : ");
        for (Double element : ts) {
            if (element > 20)
                System.out.println(element + " ");
        }
    }


    public static void setSample(HashSet<Integer> hs1) {
        Set<Integer> hs = new HashSet<>();
        hs.add(5);
        hs.add(32);
        hs.add(42);
        hs.add(63);
        hs.add(43);
        hs.add(68);
        hs.add(14);
        hs.add(70);
        System.out.println("HashSet Size: " + hs.size());
        System.out.println("Elements in HashSet: " + hs);
        System.out.print("Using iterator : ");
        Iterator<Integer> iterator1 = hs.iterator();
        while (iterator1.hasNext())
            System.out.print(iterator1.next() + " ");
        System.out.println();
        hs.remove(68);
        System.out.print("Using enhanced for loop : ");
        for (Integer element : hs) {
            if (element % 7 == 0)
                System.out.println(element + " ");
        }
    }


    public static void setSample(LinkedHashSet<String> lhs1) {
        Set<String> lhs = new LinkedHashSet<>();
        lhs.add("A");
        lhs.add("B");
        lhs.add("ABCD");
        lhs.add("SP");
        lhs.add("AIACD");
        lhs.add("MDAHWE");
        lhs.add("B");
        System.out.println("LinkedHashSet Size: " + lhs.size());
        System.out.println("Elements in LinkedHashSet: " + lhs);
        System.out.print("Using iterator : ");
        Iterator<String> iterator2 = lhs.iterator();
        while (iterator2.hasNext())
            System.out.print(iterator2.next() + " ");
        System.out.println();
        lhs.remove("B");
        System.out.println("\nLinkedHashSet after removing element : " + lhs);
        System.out.print("Using enhanced for loop : ");
        for (String element : lhs) {
            if (element.length() > 5)
                System.out.print(element + " ");
        }
    }

    public static void main(String[] args) {
        TreeSet<Double> ts1 = new TreeSet<>();
        HashSet<Integer> hs1 = new HashSet<>();
        LinkedHashSet<String> lhs1 = new LinkedHashSet<>();
        setSample(ts1);
        setSample(hs1);
        setSample(lhs1);
    }
}
