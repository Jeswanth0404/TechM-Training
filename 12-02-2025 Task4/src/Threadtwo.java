public class Threadtwo extends Thread {
    public void run(){
        System.out.println("From Thread2!");
        System.out.println("From Thread2!");
        System.out.println(10/0);
    }

}
class tt{
    public static void main(String[] args){
        Threadtwo t1 = new Threadtwo();
        Threadtwo t2 = new Threadtwo();
        t1.run();
        t2.run();
    }
}
