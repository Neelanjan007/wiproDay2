//25.Create a class named MyTriangle that contains two static methods
//a) public static double area(double a, double b, double c)
//b) public static double perimeter(double a, double b, double c)
//to compute area and perimeter of a triangle respectively given three valid
//sides a, b and c.
//And add a static method
///** Return true if the sum of any two sides is greater than the third side.
//**/
//c) public static boolean isValid(double a, double b, double c)
//In the main method of MyTriangle, test the three methods you write.
//1) Get a, b and c from the Console
//2) If a is -1, exit your program and print  Bye~ 
//3) If a is not -1, use isValid to check the input
//4) If the input is valid, compute the area and perimeter and print them
//5) If the input is not valid, return false and print  The input is invalid. 
//6) Go to 1)


package javassignment1;

import java.util.Scanner;

public class MyTriangle {

    public static double area(double a, double b, double c) {
        double s = (a + b + c) / 2; // semi-perimeter
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    public static double perimeter(double a, double b, double c) {
        return a + b + c;
    }

    public static boolean isValid(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("\nEnter side a (-1 to exit): ");
            double a = sc.nextDouble();

            if (a == -1) {
                System.out.println("Bye~");
                break;
            }

            System.out.print("Enter side b: ");
            double b = sc.nextDouble();
            System.out.print("Enter side c: ");
            double c = sc.nextDouble();

            if (isValid(a, b, c)) {
                double area = area(a, b, c);
                double perimeter = perimeter(a, b, c);
                System.out.printf("Area: %.2f\n", area);
                System.out.printf("Perimeter: %.2f\n", perimeter);
            } else {
                System.out.println("The input is invalid.");
            }
        }

        sc.close();
    }
}

