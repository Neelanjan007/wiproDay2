/////*
//// * Create a generic class Repository<T, ID> with the following methods:
//
//void save(ID id, T entity)
//T findById(ID id)
//List<T> findAll()
//void deleteById(ID id)
//
//Create an Employee class with fields:
//
//int id
//String name
//double salary
//
//Instantiate Repository<Employee, Integer> in main() and:
//
//Add 3 employees
//Retrieve and print all employees
//Retrieve a specific employee by ID
//Delete an employee and print remaining data
//
// * 
// * 
// */

package javassignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Repository<T, ID> {
    private final Map<ID, T> dataStore = new HashMap<>();

    public void save(ID id, T entity) {
        dataStore.put(id, entity);
    }

    public T findById(ID id) {
        return dataStore.get(id);
    }

    public List<T> findAll() {
        return new ArrayList<>(dataStore.values());
    }

    public void deleteById(ID id) {
        dataStore.remove(id);
    }
}


class Employee11 {
    int id;
    String name;
    double salary;

    public Employee11(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public String toString() {
        return "Employee[id=" + id + ", name='" + name + "', salary=" + salary + "]";
    }
}


public class GenericRepositoryDemo {
    public static void main(String[] args) {
        Repository<Employee11, Integer> employeeRepo = new Repository<>();

        
        employeeRepo.save(1, new Employee11(1, "Satya", 75000));
        employeeRepo.save(2, new Employee11(2, "Neelanjan", 62000));
        employeeRepo.save(3, new Employee11(3, "Akash", 81000));

       
        System.out.println("All employees:");
        employeeRepo.findAll().forEach(System.out::println);

        
        System.out.println("\nEmployee with ID 2:");
        System.out.println(employeeRepo.findById(2));

        
        employeeRepo.deleteById(2);

       
        System.out.println("\nEmployees after deleting ID 2:");
        employeeRepo.findAll().forEach(System.out::println);
    }
}
