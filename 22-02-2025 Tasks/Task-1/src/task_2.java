import java.util.*;

class Student implements Comparable<Student> {
    String name;
    int[] marks;
    int total;
    double average;

    Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
        this.total = Arrays.stream(marks).sum();
        this.average = (double) total / marks.length;
    }

    @Override
    public int compareTo(Student other) {
        return Integer.compare(other.total, this.total); // Sort in descending order
    }
}

public class task_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        Student[] students = new Student[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student name: ");
            String name = scanner.next();

            System.out.print("Enter number of subjects: ");
            int m = scanner.nextInt();
            int[] marks = new int[m];

            System.out.println("Enter marks:");
            for (int j = 0; j < m; j++) {
                marks[j] = scanner.nextInt();
            }

            students[i] = new Student(name, marks);
        }

        Arrays.sort(students);

        System.out.println("\nSorted Student List (by Total Marks):");
        for (Student student : students) {
            System.out.println(student.name + " - Total: " + student.total + ", Average: " + student.average);
        }

        scanner.close();
    }
}
