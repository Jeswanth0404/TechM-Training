import java.io.*;

class Employee1 implements Serializable{
    Employee1(int Eno,String Ename,String Email){
        this.Eno=Eno;
        this.Ename=Ename;
        this.Email=Email;
    }
    int Eno;
    String Ename;
    transient String Email;
}
public class deserialization {
    public static void main(String[] args){
        try {
            ObjectInputStream In = new ObjectInputStream(new FileInputStream("Indhu.txt"));
            Employee E =(Employee)In.readObject();
            System.out.println(E.Eno+" "+E.Ename+" "+E.Email);
            In.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
