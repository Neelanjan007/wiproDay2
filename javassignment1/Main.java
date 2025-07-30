/*47.Create a custom checked exception class InvalidSalaryException that extends Exception.

Create a class EmployeeService with the following methods:

validateSalary(double salary) → throws InvalidSalaryException if salary is < 0
processSalary(Employee emp) → calls validateSalary()
startProcess(Employee emp) → calls processSalary()

The main method should:

Create an Employee object with negative salary
Call startProcess()
Catch and handle InvalidSalaryException using try-catch in main()
 * 
 * 
 */


package javassignment1;

@SuppressWarnings("serial")
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}


class Employee124 {
    private int id;
    private String name;
    private double salary;

    public Employee124(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }
}


class EmployeeService {
    public void validateSalary(double salary) throws InvalidSalaryException {
        if (salary < 0) {
            throw new InvalidSalaryException("Salary cannot be negative Neelanjan: " + salary);
        }
    }

    public void processSalary(Employee124 emp) throws InvalidSalaryException {
        validateSalary(emp.getSalary());
        System.out.println("Salary is valid for " + emp);
    }

    public void startProcess(Employee124 emp) throws InvalidSalaryException {
        processSalary(emp);
    }
}


public class Main {
    public static void main(String[] args) {
        Employee124 emp = new Employee124(101, "Neelanjan", 50000);

        EmployeeService service = new EmployeeService();
        try {
            service.startProcess(emp);
        } catch (InvalidSalaryException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
