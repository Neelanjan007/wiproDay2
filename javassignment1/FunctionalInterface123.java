//48.Create a functional interface EmployeeProcessor with a method:
//
//void process(Employee e);
//
//Use it to print:
//
//Name and salary of employees
//Bonus calculation (10% of salary)




package javassignment1;

@FunctionalInterface
interface EmployeeProcessor {
	void process(Employee125 e);
}


class Employee125 {
	private int id;
	private String name;
	private double salary;

	public Employee125(int id, String name, double salary) {
		this.setId(id);
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

public class FunctionalInterface123 {
	public static void main(String[] args) {
		Employee125 emp1 = new Employee125(1, "Neelanjan", 60000);
		Employee125 emp2 = new Employee125(2, "Satya", 75000);

		// Processor to print name and salary
		EmployeeProcessor printDetails = (e) -> {
			System.out.println("ID : " +e.getId() + " Name: " + e.getName() + " Salary: " + e.getSalary());
		};

		// Processor to calculate bonus
		EmployeeProcessor calculateBonus = (e) -> {
			double bonus = e.getSalary() * 0.10;
			System.out.println("ID : " +e.getId() +" Bonus for " + e.getName() + ": " + bonus);
		};

		System.out.println("== Employee Details ==");
		printDetails.process(emp1);
		printDetails.process(emp2);

		System.out.println("\n== Bonus Calculation ==");
		calculateBonus.process(emp1);
		calculateBonus.process(emp2);
	}
}
