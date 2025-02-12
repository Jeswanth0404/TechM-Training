import java.io.*;
class Employee implements Serializable{
    Employee(int Eno,String Ename,String Email){
        this.Eno=Eno;
        this.Ename=Ename;
        this.Email=Email;
    }
    int Eno;
    String Ename;
    transient String Email;
}
public class serialization {
    public static void main(String[] args) throws IOException{
        try {
            Employee E1 = new Employee(234,"Indhumathi","indhumathi@gmail.com");
            FileOutputStream Fout = new FileOutputStream("Indhu.txt");
            ObjectOutputStream out = new ObjectOutputStream(Fout);
            out.writeObject(E1);
            out.flush();
            out.close();
            System.out.println("SUCCESS");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
