public class ThreadRunnableTwo implements Runnable{
    @Override
    public void run() {
        System.out.println("From ThreadRunnableTwo!");
        System.out.println("From ThreadRunnableTwo!");
        System.out.println("From ThreadRunnableTwo!");
    }
}
class t2{
    public static void main(String[] args){
        ThreadRunnableTwo t1 = new ThreadRunnableTwo();
        ThreadRunnableTwo t2 = new ThreadRunnableTwo();
        t1.run();
        t2.run();
    }
}
