import java.util.*;
import java.util.LinkedList;

public class List {
    public static void main(String[] args){
        linkedList t1 = new linkedList();
        t1.run();
        vectorlist t2 = new vectorlist();
        t2.run();
        stack t3 = new stack();
        t3.run();
    }
}
class linkedList extends Thread{
    public void run(){
        LinkedList<Integer> list1 = new LinkedList<>();
        //System.out.println("Is list1 empty? "+list1.isEmpty());
        list1.add(35);
        list1.add(23);
        list1.add(67);
        list1.add(82);
        list1.add(56);
        list1.add(49);
        list1.add(49);
        list1.add(49);
        //System.out.println("Is list1 empty? "+list1.isEmpty());
        //  System.out.println("The given list is:"+list1);
        System.out.println("Number of elements in the list: "+list1.size());
        //Adding one element
        list1.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given list is :"+list1);
        System.out.println("The number of elements in the list: "+list1.size());
//Checking for an element
        System.out.println("Is 566 available in the list:"+list1.contains(566));
        System.out.println("The given list before removing elements is :"+list1);
        list1.remove(2);//Removing element by its index
        list1.remove(3);//Removing element by its index
        System.out.println("After removing elements:");
        System.out.println("The given list is :"+list1);
        System.out.println("The number of elements in the list: "+list1.size());
    }
}
class vectorlist extends Thread{
    public void run(){
        Vector<Integer> list1 = new Vector<>();
        //System.out.println("Is list1 empty? "+list1.isEmpty());
        list1.add(35);
        list1.add(83);
        list1.add(17);
        list1.add(42);
        list1.add(56);
        list1.add(44);
        list1.add(69);
        list1.add(41);
        //System.out.println("Is list1 empty? "+list1.isEmpty());
        //  System.out.println("The given list is:"+list1);
        System.out.println("Number of elements in the list: "+list1.size());
        //Adding one element
        list1.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given list is :"+list1);
        System.out.println("The number of elements in the list: "+list1.size());
//Checking for an element
        System.out.println("Is 566 available in the list:"+list1.contains(566));
        System.out.println("The given list before removing elements is :"+list1);
        list1.remove(2);//Removing element by its index
        list1.remove(3);//Removing element by its index
        System.out.println("After removing elements:");
        System.out.println("The given list is :"+list1);
        System.out.println("The number of elements in the list: "+list1.size());
    }
}
class stack extends Thread{
    public void run(){
        Stack<Integer> list1 = new Stack<>();
        //System.out.println("Is list1 empty? "+list1.isEmpty());
        list1.add(35);
        list1.add(23);
        list1.add(6);
        list1.add(10);
        list1.add(5);
        list1.add(41);
        list1.add(22);
        list1.add(8);
        //System.out.println("Is list1 empty? "+list1.isEmpty());
        //  System.out.println("The given list is:"+list1);
        System.out.println("Number of elements in the list: "+list1.size());
        //Adding one element
        list1.add(12);
        System.out.println("After adding one element:");
        System.out.println("The given list is :"+list1);
        System.out.println("The number of elements in the list: "+list1.size());
//Checking for an element
        System.out.println("Is 566 available in the list:"+list1.contains(566));
        System.out.println("The given list before removing elements is :"+list1);
        list1.remove(2);//Removing element by its index
        list1.remove(3);//Removing element by its index
        list1.remove(3);
        System.out.println("After removing elements:");
        System.out.println("The given list is :"+list1);
        System.out.println("The number of elements in the list: "+list1.size());
    }
}
