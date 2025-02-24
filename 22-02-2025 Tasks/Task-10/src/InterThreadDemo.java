class SharedResource {
    private boolean isReady = false;

    synchronized void produce() {
        try {
            System.out.println("Producer: Producing data...");
            Thread.sleep(1000);
            isReady = true;
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void consume() {
        try {
            while (!isReady) {
                wait();
            }
            System.out.println("Consumer: Data consumed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class InterThreadDemo {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Thread producer = new Thread(resource::produce);
        Thread consumer = new Thread(resource::consume);

        consumer.start();
        producer.start();
    }
}
