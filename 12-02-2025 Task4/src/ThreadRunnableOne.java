public class ThreadRunnableOne implements Runnable{
    public void run(){
        System.out.println("From ThreadRunnableOne");
        System.out.println("From ThreadRunnableOne");
    }
}
class tr{
    public static void main(String[] args) {
        ThreadRunnableOne t1 = new ThreadRunnableOne();
        t1.run();
    }
}
