/*
 * 49.Create a class Employee with optional fields for email and department. Use Optional to:

Safely access employee details.

Provide default values when data is absent.

Throw custom exceptions if required fields are missing. 
 * 
 */



package javassignment1;

import java.util.Optional;


@SuppressWarnings("serial")
class MissingFieldException extends Exception {
 public MissingFieldException(String message) {
     super(message);
 }
}


class Employee126 {
 private int id;
 private String name;
 private Optional<String> email;
 private Optional<String> department;

 public Employee126(int id, String name, String email, String department) {
     this.id = id;
     this.name = name;
     this.email = Optional.ofNullable(email);
     this.department = Optional.ofNullable(department);
 }

 public int getId() {
     return id;
 }

 public String getName() {
     return name;
 }

 public Optional<String> getEmail() {
     return email;
 }

 public Optional<String> getDepartment() {
     return department;
 }
}

public class Missing {
 public static void main(String[] args) {
	 
	 
     // Employee with missing email and department
     Employee126 emp1 = new Employee126(1, "Neelanjan", null, null);

     
     Employee126 emp2 = new Employee126(2, "Meera", "meera@example.com", "HR");

     try {
         printEmployeeDetails(emp1);
     } catch (MissingFieldException e) {
         System.out.println("Error: " + e.getMessage());
     }

     System.out.println("\n---");

     try {
         printEmployeeDetails(emp2);
     } catch (MissingFieldException e) {
         System.out.println("Error: " + e.getMessage());
     }
 }

 public static void printEmployeeDetails(Employee126 emp) throws MissingFieldException {
     System.out.println("ID: " + emp.getId());
     System.out.println("Name: " + emp.getName());

     
     String email = emp.getEmail().orElse("No Email Provided");
     System.out.println("Email: " + email);

     // Throwing exception if department is missing
     String department = emp.getDepartment().orElseThrow(() ->
             new MissingFieldException("Department is required for the employee - " + emp.getName()));
     System.out.println("Department: " + department);
 }
}

