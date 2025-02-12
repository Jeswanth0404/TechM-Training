public class Threadthree extends Thread {
    public void run(){
        System.out.println("From ThreadThree!");
        System.out.println("From ThreadThree!");
        System.out.println("From ThreadThree!");
        System.out.println("From ThreadThree!");
        System.out.println("From ThreadThree!");
    }
}
class t3{
    public static void main(String[] args){
        Threadthree t1 = new Threadthree();
        Threadthree t2 = new Threadthree();
        Threadthree t3 = new Threadthree();
        t1.run();
        t2.run();
        t3.run();
    }
}
