//11. Create a class called Calculator which has 4 different methods add, diff, mul and div which 
//accepts two numbers as parameters. Create an object to access these methods and invoke 
//these methods with two numbers and display the result in the corresponding methods. 




package javassignment1;

public class Calculator {

    public void add(double a, double b) {
        double result = a + b;
        System.out.println("Addition: " + result);
    }

    public void diff(double a, double b) {
        double result = a - b;
        System.out.println("Subtraction: " + result);
    }

    public void mul(double a, double b) {
        double result = a * b;
        System.out.println("Multiplication: " + result);
    }

    public void div(double a, double b) {
        if (b == 0) {
            System.out.println("Division: Cannot divide by zero");
        } else {
            double result = a / b;
            System.out.println("Division: " + result);
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        double num1 = 20;
        double num2 = 5;
        System.out.println("Number1 = 20 & Number2 = 5 : ");

        calc.add(num1, num2);
        calc.diff(num1, num2);
        calc.mul(num1, num2);
        calc.div(num1, num2);
    }
}

