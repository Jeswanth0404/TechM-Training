import java.util.Arrays;

class SortingTask extends Thread {
    private int[] numbers;

    public SortingTask(int[] numbers) {
        this.numbers = numbers;
    }

    public void run() {
        Arrays.sort(numbers);
    }

    public int[] getSortedArray() {
        return numbers;
    }
}

public class ParallelSorting {
    public static void main(String[] args) throws InterruptedException {
        int[] array = {9, 4, 7, 1, 3, 6, 2, 8};

        int midpoint = array.length / 2;
        int[] leftPart = Arrays.copyOfRange(array, 0, midpoint);
        int[] rightPart = Arrays.copyOfRange(array, midpoint, array.length);

        SortingTask firstThread = new SortingTask(leftPart);
        SortingTask secondThread = new SortingTask(rightPart);

        firstThread.start();
        secondThread.start();

        firstThread.join();
        secondThread.join();

        int[] finalSortedArray = mergeSortedArrays(firstThread.getSortedArray(), secondThread.getSortedArray());
        System.out.println("Final Sorted Array: " + Arrays.toString(finalSortedArray));
    }

    private static int[] mergeSortedArrays(int[] first, int[] second) {
        int[] result = new int[first.length + second.length];
        int i = 0, j = 0, k = 0;

        while (i < first.length && j < second.length) {
            result[k++] = (first[i] < second[j]) ? first[i++] : second[j++];
        }
        while (i < first.length) result[k++] = first[i++];
        while (j < second.length) result[k++] = second[j++];

        return result;
    }
}
