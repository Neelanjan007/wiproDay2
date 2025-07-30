// 16.Write a program that prompts user for the mark (between 0-100 in int) of 3 students; computes the average (in double); and prints the result rounded to 2 decimal places. Your program needs to perform input validation. For examples,
//
//                      Enter the mark (0-100) for student 1: 56
//                      Enter the mark (0-100) for student 2: 101
//                      Invalid input, try again...
//                      Enter the mark (0-100) for student 2: -1
//                      Invalid input, try again...
//                      Enter the mark (0-100) for student 2: 99
//                      Enter the mark (0-100) for student 3: 45
//                      The average is: 66.67


package javassignment1;

import java.util.Scanner;

public class StudentMarksAverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalStudents = 3;
        int[] marks = new int[totalStudents];
        int i = 0;

        while (i < totalStudents) {
            System.out.print("Enter the mark (0-100) for student " + (i + 1) + ": ");
            if (sc.hasNextInt()) {
                int mark = sc.nextInt();
                if (mark >= 0 && mark <= 100) {
                    marks[i] = mark;
                    i++;
                } else {
                    System.out.println("Invalid input, try again...");
                }
            } else {
                System.out.println("Invalid input, try again...");
                sc.next(); 
            }
        }

        double average = (marks[0] + marks[1] + marks[2]) / 3.0;
        System.out.printf("The average is: %.2f\n", average);

        sc.close();
    }
}

