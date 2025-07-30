// 20.Write a Java program to create an abstract class Vehicle with abstract methods startEngine() and stopEngine(). Create subclasses Car and Motorcycle that extend the Vehicle 
// class and implement the respective methods to start and stop the engines for each vehicle type.


package javassignment1;


abstract class Vehicle1 {
 abstract void startEngine();
 abstract void stopEngine();
}


class Car1 extends Vehicle1 {
 @Override
 void startEngine() {
     System.out.println("Car engine started.");
 }

 @Override
 void stopEngine() {
     System.out.println("Car engine stopped.");
 }
}


class Motorcycle extends Vehicle1 {
 

@Override
 void startEngine() {
     System.out.println("Motorcycle engine started.");
 }

 @Override
 void stopEngine() {
     System.out.println("Motorcycle engine stopped.");
 }
}


public class VehicleTest {
 public static void main(String[] args) {
     Vehicle1 myCar = new Car1();
     Vehicle1 myBike = new Motorcycle();

     System.out.println("Testing Car:");
     myCar.startEngine();
     myCar.stopEngine();

     System.out.println("\nTesting Motorcycle:");
     myBike.startEngine();
     myBike.stopEngine();
 }
}

