public class Threadone extends Thread{
    public void run(){
        System.out.println("From Thread1!");
        System.out.println("From Thread1!");
        System.out.println("From Thread1!");
    }
}

class Mt{
    public static void main(String[] args){
        Threadone t1 = new Threadone();
        t1.start();
    }
}
