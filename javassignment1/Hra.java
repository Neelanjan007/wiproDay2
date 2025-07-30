/*
 * Create a class with following specifications.                                                                         
Class Emp                                                                                                           
           
empId              int                   
empName        string      
designation      string             
basic                double              
hra                   double readOnly

Methods
printDET()
printDET() methods will show details of the EMP.                                             
calculateHRA() method will calculate HRA based on basic.

There will 3 designations supported by the application.                                                                                            
If designation  is  Manager   - HRA will be 10% of BASIC
if designation  is  TeamLeader   - HRA will be 12% of BASIC
if category is "HR"  - HRA will be 5% of BASIC

Have constructor to which you will pass, empId, designation, basic and price.

And checks whether the BASIC is less than 50000 or not. If it is less than 50000 raise a custom Exception as given below

Create LowSalException class with proper user message to handle BASIC less than 50000.
 * */
 



package javassignment1;

@SuppressWarnings("serial")
class LowSalException extends Exception {
    public LowSalException(String message) {
        super(message);
    }
}

class Emp {
    private int empId;
    private String empName;
    private String designation;
    private double basic;
    private final double hra;

    public Emp(int empId, String empName, String designation, double basic) throws LowSalException {
        if (basic < 50000) {
            throw new LowSalException("Basic salary of "+ empName + ""+ " cannot be less than 50000!");
        }
        this.empId = empId;
        this.empName = empName;
        this.designation = designation;
        this.basic = basic;
        this.hra = calculateHRA(); 
    }

    private double calculateHRA() {
        switch (designation.toLowerCase()) {
            case "manager":
                return 0.10 * basic;
            case "teamleader":
                return 0.12 * basic;
            case "hr":
                return 0.05 * basic;
            default:
                return 0.0;
        }
    }

    public void printDET() {
        System.out.println("Emp ID: " + empId);
        System.out.println("Emp Name: " + empName);
        System.out.println("Designation: " + designation);
        System.out.println("Basic Salary: " + basic);
        System.out.println("HRA: " + hra);
    }
}

public class Hra {
    public static void main(String[] args) {
        try {
            Emp e1 = new Emp(101, "Neelanjan", "Manager", 60000);
            e1.printDET();

            System.out.println();

            Emp e2 = new Emp(102, "Aditya", "HR", 49999.00); // Will throw exception
            e2.printDET();
        } catch (LowSalException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
