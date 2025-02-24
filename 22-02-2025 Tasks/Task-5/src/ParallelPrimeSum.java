import java.util.ArrayList;
import java.util.List;

class PrimeSumCalculator extends Thread {
    private int lowerLimit, upperLimit;
    private long primeSum;

    public PrimeSumCalculator(int lowerLimit, int upperLimit) {
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
    }

    private boolean checkPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public void run() {
        for (int num = lowerLimit; num <= upperLimit; num++) {
            if (checkPrime(num)) {
                primeSum += num;
            }
        }
    }

    public long getPrimeSum() {
        return primeSum;
    }
}

public class ParallelPrimeSum {
    public static void main(String[] args) throws InterruptedException {
        int maxNumber = 100;
        int threadCount = 4;
        int partition = maxNumber / threadCount;

        List<PrimeSumCalculator> threadList = new ArrayList<>();
        for (int i = 0; i < threadCount; i++) {
            int start = i * partition + 1;
            int end = (i == threadCount - 1) ? maxNumber : start + partition - 1;
            PrimeSumCalculator workerThread = new PrimeSumCalculator(start, end);
            threadList.add(workerThread);
            workerThread.start();
        }

        long totalPrimeSum = 0;
        for (PrimeSumCalculator worker : threadList) {
            worker.join();
            totalPrimeSum += worker.getPrimeSum();
        }

        System.out.println("Total Sum of Prime Numbers up to " + maxNumber + " is: " + totalPrimeSum);
    }
}
