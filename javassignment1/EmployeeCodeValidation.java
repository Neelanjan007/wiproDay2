/*
 *34.Create a class by name Employee with members   Employee ID, Name and year of birth. 
 *The Employee ID is a string that contains the ID in the formatyear-designation-number. 
 *The year is represented with the last two digits. 
 *The designation is a single letter code - 'F' for faculty and 'S' for staff.
	The number is a 3 digit number.(Example:81-F-112     79-S-254)

35.Write a program to read the employee details and validate the employee code.
If the employee code is incorrect throw a user-defined exception"InvalidEmployeeCode" 
else create the Employee object and display the details of the employee.  
 * 
 * 
 */

package javassignment1;

import java.util.Scanner;


@SuppressWarnings("serial")
class InvalidEmployeeCode extends Exception {
 public InvalidEmployeeCode(String message) {
     super(message);
 }
}


class Employee139 {
 String empId;
 String name;
 int birthYear;


 Employee139(String empId, String name, int birthYear) throws InvalidEmployeeCode {
     if (!empId.matches("\\d{2}-[FS]-\\d{3}")) {
         throw new InvalidEmployeeCode("Invalid Employee ID format! Must be like 81-F-112");
     }
     this.empId = empId;
     this.name = name;
     this.birthYear = birthYear;
 }


 public void display() {
     System.out.println("\n--- Employee Details ---");
     System.out.println("Employee ID   : " + empId);
     System.out.println("Employee Name : " + name);
     System.out.println("Year of Birth : " + birthYear);
 }
}


public class EmployeeCodeValidation {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);
     try {
         System.out.print("Enter Employee ID (Format: YY-F/S-XXX): ");
         String id = sc.nextLine();

         System.out.print("Enter Employee Name: ");
         String name = sc.nextLine();

         System.out.print("Enter Year of Birth: ");
         int birthYear = sc.nextInt();

         
         Employee139 emp = new Employee139(id, name, birthYear);
         emp.display();

     } catch (InvalidEmployeeCode e) {
         System.out.println("Error: " + e.getMessage());
     } catch (Exception e) {
         System.out.println("Invalid input. Please enter correct values.");
     } finally {
         sc.close();
     }
 }
}


