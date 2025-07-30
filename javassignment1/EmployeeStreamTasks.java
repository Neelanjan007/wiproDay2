/*
 * 50.List<Employee> employees = Arrays.asList(
    new Employee(101, "Ravi", "HR", 50000),
    new Employee(102, "Priya", "IT", 60000),
    new Employee(103, "Arun", "HR", 55000),
    new Employee(104, "Kavya", "IT", 70000),
    new Employee(105, "Divya", "Sales", 45000)
);
Q1. Print all employee names using Stream
Q2. Filter and print employees with salary > 55000
Q3. Count the number of employees in "HR" department
Q4. Sort employees by salary in descending order
Q5. Find the highest paid employee (use max)
Q6. Find the average salary of all employees
Q7. Collect all names into a List
Q8. Group employees by department (use Collectors.groupingBy)
Q9. Calculate total salary per department
Q10. Find names of employees in IT department sorted by salary
Q11. Check if any employee earns less than 40000
Q12. Get a comma-separated string of all employee names
Q13. Get a list of top 2 highest earning employees
Q14. Skip first 2 employees and print the rest
Q15. Limit to first 3 employees and print their names
Q16. Get employee with minimum salary in HR department
Q17. Partition employees into two groups: salary > 55000 and <= 55000
Q18. Create a Map<Department, AverageSalary>
Q19. Sort employees by name and then by salary
Q20. Convert List<Employee> into Map<Id, Name>
🔹 Challenge 1: Get employees whose name starts with “D” and ends with “a”
🔹 Challenge 2: List departments with more than 1 employee
🔹 Challenge 3: Find the second highest salary using streams
(Hint: Use distinct(), sorted(), skip(1), findFirst()) 
 * 
 * 
 */




package javassignment1;

import java.util.*;
import java.util.stream.Collectors;

class Employee130 {
    int id;
    String name;
    String department;
    double salary;

    public Employee130(int id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

   
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return id + " - " + name + " - " + department + " - Rs." + salary;
    }
}

public class EmployeeStreamTasks {
    public static void main(String[] args) {
        List<Employee130> employees = Arrays.asList(
            new Employee130(101, "Ravi", "HR", 50000),
            new Employee130(102, "Priya", "IT", 60000),
            new Employee130(103, "Arun", "HR", 55000),
            new Employee130(104, "Kavya", "IT", 70000),
            new Employee130(105, "Divya", "Sales", 45000)
        );

        // Q1
        employees.stream().map(Employee130::getName).forEach(System.out::println);

        // Q2
        employees.stream().filter(e -> e.getSalary() > 55000).forEach(System.out::println);

        // Q3
        long countHR = employees.stream().filter(e -> e.getDepartment().equals("HR")).count();
        System.out.println("HR Count: " + countHR);

        // Q4
        employees.stream().sorted(Comparator.comparingDouble(Employee130::getSalary).reversed()).forEach(System.out::println);

        // Q5
        employees.stream().max(Comparator.comparingDouble(Employee130::getSalary)).ifPresent(System.out::println);

        // Q6
        double avgSalary = employees.stream().collect(Collectors.averagingDouble(Employee130::getSalary));
        System.out.println("Average Salary: Rs." + avgSalary);

        // Q7
        List<String> names = employees.stream().map(Employee130::getName).collect(Collectors.toList());
        System.out.println("Collected the List of names : "+names);

        // Q8
        Map<String, List<Employee130>> groupByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee130::getDepartment));
        System.out.println(groupByDept);

        // Q9
        Map<String, Double> totalSalaryPerDept = employees.stream()
                .collect(Collectors.groupingBy(Employee130::getDepartment,
                        Collectors.summingDouble(Employee130::getSalary)));
        System.out.println(totalSalaryPerDept);

        // Q10
        employees.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .sorted(Comparator.comparingDouble(Employee130::getSalary))
                .map(Employee130::getName)
                .forEach(System.out::println);

        // Q11
        boolean anyLowSalary = employees.stream().anyMatch(e -> e.getSalary() < 40000);
        System.out.println("Any salary < 40000: " + anyLowSalary);

        // Q12
        String joinedNames = employees.stream().map(Employee130::getName).collect(Collectors.joining(", "));
        System.out.println(joinedNames);

        // Q13
        List<Employee130> top2 = employees.stream()
                .sorted(Comparator.comparingDouble(Employee130::getSalary).reversed())
                .limit(2)
                .collect(Collectors.toList());
        top2.forEach(System.out::println);

        // Q14
        employees.stream().skip(2).forEach(System.out::println);

        // Q15
        employees.stream().limit(3).map(Employee130::getName).forEach(System.out::println);

        // Q16
        employees.stream()
                .filter(e -> e.getDepartment().equals("HR"))
                .min(Comparator.comparingDouble(Employee130::getSalary))
                .ifPresent(System.out::println);

        // Q17
        Map<Boolean, List<Employee130>> partitioned = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 55000));
        System.out.println(partitioned);

        // Q18
        Map<String, Double> avgPerDept = employees.stream()
                .collect(Collectors.groupingBy(Employee130::getDepartment,
                        Collectors.averagingDouble(Employee130::getSalary)));
        System.out.println(avgPerDept);

        // Q19
        employees.stream()
                .sorted(Comparator.comparing(Employee130::getName)
                        .thenComparing(Employee130::getSalary))
                .forEach(System.out::println);

        // Q20
        Map<Integer, String> idNameMap = employees.stream()
                .collect(Collectors.toMap(Employee130::getId, Employee130::getName));
        System.out.println(idNameMap);

        // Challenge 1
        employees.stream()
                .filter(e -> e.getName().startsWith("D") && e.getName().endsWith("a"))
                .forEach(System.out::println);

        // Challenge 2
        Map<String, Long> deptCount = employees.stream()
                .collect(Collectors.groupingBy(Employee130::getDepartment, Collectors.counting()));
        deptCount.entrySet().stream().filter(e -> e.getValue() > 1).forEach(System.out::println);

        // Challenge 3
        employees.stream()
                .map(Employee130::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .ifPresent(s -> System.out.println("Second highest salary: Rs." + s));
    }
}
