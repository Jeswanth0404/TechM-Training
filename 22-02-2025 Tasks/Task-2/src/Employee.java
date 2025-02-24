import java.util.*;

class Employee {
    private int empId;
    private String empName;
    private double sal;
    private int yearsWorked;

    public void setEmployeeDetails(int empId, String empName, double sal, int yearsWorked) {
        this.empId = empId;
        this.empName = empName;
        this.sal = sal;
        this.yearsWorked = yearsWorked;
    }

    public void getEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Salary: " + sal);
        System.out.println("Years Worked: " + yearsWorked);
    }

    public void getLoanEligibility() {
        if (yearsWorked > 5) {
            double annualSalary = sal;
            double loanAmount = 0;
            if (annualSalary >= 15_00_000) {
                loanAmount = 7_00_000;
            } else if (annualSalary >= 10_00_000) {
                loanAmount = 5_00_000;
            } else if (annualSalary >= 6_00_000) {
                loanAmount = 2_00_000;
            }
            System.out.println("Eligible Loan Amount: " + loanAmount);
        } else {
            System.out.println("Not eligible for a loan.");
        }
    }
}

class EmployeeLoan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int empId = scanner.nextInt();

        System.out.print("Enter Employee Name: ");
        scanner.nextLine(); // consume newline
        String empName = scanner.nextLine();

        System.out.print("Enter Monthly Salary: ");
        double sal = scanner.nextDouble();

        System.out.print("Enter Years Worked: ");
        int yearsWorked = scanner.nextInt();

        Employee emp = new Employee();
        emp.setEmployeeDetails(empId, empName, sal, yearsWorked);

        System.out.println("\nEmployee Details:");
        emp.getEmployeeDetails();

        System.out.println("\nLoan Eligibility:");
        emp.getLoanEligibility();

        scanner.close();
    }
}
