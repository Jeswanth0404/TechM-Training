class GreetingThread extends Thread {
    public void run() {
        System.out.println("Hello, Java!");
    }

    public static void main(String[] args) {
        GreetingThread threadInstance = new GreetingThread();
        threadInstance.start();
    }
}