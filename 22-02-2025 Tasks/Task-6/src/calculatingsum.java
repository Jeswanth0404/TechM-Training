import java.util.List;

public class calculatingsum {
    public static <T extends Number> void calculateSum(List<T> numberList) {
        double sumEven = 0, sumOdd = 0;
        for (T value : numberList) {
            if (value.intValue() % 2 == 0) {
                sumEven += value.doubleValue();
            } else {
                sumOdd += value.doubleValue();
            }
        }
        System.out.println("Total Sum of Even Numbers: " + sumEven);
        System.out.println("Total Sum of Odd Numbers: " + sumOdd);
    }

    public static void main(String[] args) {
        List<Integer> values = List.of(10, 15, 22, 33, 44, 51, 60);
        calculateSum(values);
    }
}
