public class Print {
    public static void print() {
        System.out.print("Coding is an art, and every line is a brushstroke.");
        System.out.print(" Keep going, no need to break the flow!");
    }

    public static void println() {
        System.out.println("Now shifting gears—new thoughts deserve a fresh line.");
        System.out.println("This marks the conclusion of our println journey.");
    }

    public static void error() {
        System.err.print("Caution: Something seems off, please check your logic!");
        System.err.println(" Critical error detected! Immediate attention required.");
    }

    public static void main(String[] args) {
        // Testing the methods
        print();
        System.out.println(); // Adding a newline for better readability
        println();
        error();
    }
}
