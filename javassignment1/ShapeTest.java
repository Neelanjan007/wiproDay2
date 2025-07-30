//14.Create a class called shape with the following methods
//                  1. area
//                  2. perimeter
//
//                                      Overload the area and perimeter method to calculate for both square and rectangle.
//                                      Create a main class and invoke the area method to calculate the area of the square and 
//                  rectangle. Also invoke the perimeter method to calculate the perimeter of the square 
//                  and rectangle.



package javassignment1;

class Shape {

    // Area of square
    public double area(double side) {
        return side * side;
    }

    // Area of rectangle
    public double area(double length, double breadth) {
        return length * breadth;
    }

    // Perimeter of square
    public double perimeter(int side) {
        return 4 * side;
    }

    // Perimeter of rectangle
    public double perimeter(int length, int breadth) {
        return 2 * (length + breadth);
    }
}

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape = new Shape();

       
        double squareSide = 5;
        System.out.println("Square Area: " + shape.area(squareSide));
        System.out.println("Square Perimeter: " + shape.perimeter((int)squareSide));

        
        double length = 6;
        double breadth = 4;
        System.out.println("Rectangle Area: " + shape.area(length, breadth));
        System.out.println("Rectangle Perimeter: " + shape.perimeter((int)length, (int)breadth));
    }
}

