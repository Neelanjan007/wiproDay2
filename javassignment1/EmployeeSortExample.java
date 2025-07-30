/*
 * 44.
Custom Sorting with Comparator
Problem:
You are given a list of Employee objects with attributes: id, name, and salary.
Store them in a List<Employee>.
Sort by salary in descending order using Comparator.
Then sort by name alphabetically using a lambda expression.
 * 
 * 
 */
package javassignment1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Employee {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return id + " " + name + " " + salary;
    }
}

public class EmployeeSortExample {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", 70000));
        employees.add(new Employee(102, "Bob", 50000));
        employees.add(new Employee(103, "Charlie", 60000));
        employees.add(new Employee(104, "David", 90000));

        // Sort by salary descending
        employees.sort(Comparator.comparingDouble((Employee e) -> e.salary).reversed());
        System.out.println("Sorted by salary (descending):");
        employees.forEach(System.out::println);

        // Sort by name alphabetically 
        employees.sort(Comparator.comparing(e -> e.name));
        System.out.println("\nSorted by name (alphabetically):");
        employees.forEach(System.out::println);
    }
}