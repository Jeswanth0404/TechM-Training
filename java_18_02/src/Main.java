import java.sql.SQLException;
import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
        jdbc jd = new jdbc();
        Scanner sc = new Scanner(System.in);
        System.out.println("This is Student table from MySql");
        System.out.println("Enter your choice");
        int choice = sc.nextInt();
        //String ch =sc.next();
        switch(choice) {
            case 1:
                System.out.println("You have chosen to view the table contents");
                jd.selectRecords();
                break;
            case 2:
                System.out.println("You have chosen to insert into the table. ");
                jd.insertRecord();
                break;
            case 3:
                System.out.println("You have chosen to update the values in the table. ");
                jd.updateRecordWithPreparedStatement(76,"Daniel");
                break;
            case 4:
                System.out.println("You have chosen to delete the values in the table. ");
                jd.deleteRecordWithPreparedStatement(36);
                break;
            default:
                System.out.println("Invalid input");
        }
       /* switch(ch) {
            case "view":
                System.out.println("You have chosen to view the table contents");
                jd.selectRecords();
                break;
            case "insert":
                System.out.println("You have chosen to insert into the table. ");
                jd.insertRecord();
                break;
            case "update":
                System.out.println("You have chosen to update the values in the table. ");
                jd.updateRecordWithPreparedStatement(76,"Daniel");
                break;
            case "delete":
                System.out.println("You have chosen to delete the values in the table. ");
                jd.deleteRecordWithPreparedStatement(56);
                break;
            default:
                System.out.println("Invalid input");*/
}
}