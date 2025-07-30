/*
 * 45.Create a class Student with fields: id, name, department.
Group the students by department using Map<String, List<Student>>.
Print all departments with their student names.
Bonus: Use Java 8 Stream and Collectors.groupingBy() 
 * 
 */




package javassignment1;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Student11 {
    int id;
    String name;
    String department;

    public Student11(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String toString() {
        return name;
    }
}

public class GroupStudentsByDepartment {
    public static void main(String[] args) {
        List<Student11> students = Arrays.asList(
            new Student11(1, "Neelanjan", "ECE"),
            new Student11(2, "Ankita", "ECE"),
            new Student11(3, "Rahul", "CSE"),
            new Student11(4, "Suman", "ECE"),
            new Student11(5, "Piyush", "IT"),
            new Student11(6, "Tanay", "IT")
        );

        Map<String, List<Student11>> grouped = students.stream()
                .collect(Collectors.groupingBy(s -> s.department));

        System.out.println("Students grouped by department:");
        grouped.forEach((dept, studentList) -> {
            System.out.println(dept + ": " +
                studentList.stream().map(s -> s.name).collect(Collectors.joining(", "))
            );
        });
    }
}
