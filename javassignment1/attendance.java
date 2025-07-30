/*
 * 7.A student will not be allowed to sit in exam if his/her attendence is less than 70%.
Take following input from user
Number of classes held
Number of classes attended.
And print
percentage of class attended
Is student is allowed to sit in exam or not.

8.Modify the above question to allow student to sit if he/she has medical cause. Ask user if he/she has medical cause or not ( 'Y' or 'N' ) and print accordingly.

 * 
 */
package javassignment1;
import java.util.Scanner;

public class attendance {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        System.out.print("Enter total number of classes held: ");
        int totalClasses = scanner.nextInt();

        System.out.print("Enter number of classes attended: ");
        int attendedClasses = scanner.nextInt();

        
        double attendancePercentage = (attendedClasses * 100.0) / totalClasses;

        
        System.out.printf("Attendance Percentage: %.2f%%\n", attendancePercentage);

    
        System.out.print("Do you have a medical cause? (Y/N): ");
        char medicalCause = scanner.next().charAt(0);

        
        medicalCause = Character.toUpperCase(medicalCause);

        
        if (attendancePercentage >= 70 || medicalCause == 'Y') {
            System.out.println("Student is allowed to sit in the exam.");
        } else {
            System.out.println("Student is NOT allowed to sit in the exam.");
        }

        scanner.close();

	}

}
