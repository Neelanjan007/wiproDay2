//13. Create a class called Worker. Write classes DailyWorker and SalariedWorker that inherit from
//                  Worker. Every worker has a name and a salaryrate. Write method Pay (int hours) to compute 
//                  the week pay of every worker.  A Daily worker is paid on the basis of the number of days 
//                  she/he works. The salaried worker gets paid the wage for 40 hours a week no matter what the
//                  actual hours are.  Test this program to calculate the pay of workers. 

package javassignment1;


class Worker {
 String name;
 double salaryRate;

 Worker(String name, double salaryRate) {
     this.name = name;
     this.salaryRate = salaryRate;
 }

 double pay(int hours) {
     return 0.0; 
 }
}


class DailyWorker extends Worker {

 DailyWorker(String name, double salaryRate) {
     super(name, salaryRate);
 }

 @Override
 double pay(int hours) {
     int daysWorked = hours / 8; // Assuming 8 hours = 1 work day
     return daysWorked * salaryRate;
 }
}


class SalariedWorker extends Worker {

 SalariedWorker(String name, double salaryRate) {
     super(name, salaryRate);
 }

 @Override
 double pay(int hours) {
     return 40 * salaryRate; // Fixed 40 hours
 }
}


public class WorkerTest {
 public static void main(String[] args) {
     DailyWorker dw = new DailyWorker("Ravi", 1000); // ₹1000/day
     SalariedWorker sw = new SalariedWorker("Neha", 800); // ₹800/hour

     int hoursWorked = 48; // employee worked for 6 days
     System.out.println("Hours = 48");

     System.out.println("Daily Worker Pay: ₹" + dw.pay(hoursWorked));
     System.out.println("Salaried Worker Pay: ₹" + sw.pay(hoursWorked));
 }
}

