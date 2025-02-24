public class Numberprinter {
    public static void main(String[] args) {
        EvenNumbers evenThread = new EvenNumbers();
        OddNumbers oddThread = new OddNumbers();

        evenThread.start();
        oddThread.start();
    }
}
class EvenNumbers extends Thread {
    public void run() {
        System.out.println("Even numbers between 1 and 20:");
        for (int i = 2; i <= 20; i += 2) {
            System.out.println(i);
        }
    }
}

class OddNumbers extends Thread {
    public void run() {
        System.out.println("Odd numbers between 1 and 20:");
        for (int i = 1; i <= 20; i += 2) {
            System.out.println(i);
        }
    }
}
