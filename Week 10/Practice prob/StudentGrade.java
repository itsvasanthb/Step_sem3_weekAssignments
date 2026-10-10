
import java.util.*;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String grade;

        if (n >= 90) {
            grade = "A";
        } else if (n >= 75) {
            grade = "B";
        } else if (n >= 60) {
            grade = "C";
        } else if (n >= 40) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("Grade " + grade);
        sc.close();
    }
}
