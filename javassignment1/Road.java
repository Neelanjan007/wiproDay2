// 17.Create a class called Vehicle. Create subclasses like Truck, Bus, Car etc. Add common methods 
//                      in the base class and specific methods in the corresponding class. Create a class called Road 
//                      and create objects for the Truck, Car, Bus etc and display the appropriate message. 
//
//                      In the Vehicle class constructor initialize few variables like color, no of 
//                      wheels, model etc. Give appropriate values for these variables from the invoking subclass. 


package javassignment1;

class Vehicle {
    String color;
    int wheels;
    String model;

    Vehicle(String color, int wheels, String model) {
        this.color = color;
        this.wheels = wheels;
        this.model = model;
    }

    void showDetails() {
        System.out.println("Model: " + model + ", Color: " + color + ", Wheels: " + wheels);
    }
}

class Truck extends Vehicle {
    Truck(String color, String model) {
        super(color, 6, model);
    }

    void carryLoad() {
        System.out.println("Truck is carrying heavy load.");
    }
}

class Bus extends Vehicle {
    Bus(String color, String model) {
        super(color, 4, model);
    }

    void transportPassengers() {
        System.out.println("Bus is transporting passengers.");
    }
}

class Car extends Vehicle {
    Car(String color, String model) {
        super(color, 4, model);
    }

    void drive() {
        System.out.println("Car is being driven smoothly.");
    }
}

public class Road {
    public static void main(String[] args) {
        Truck truck = new Truck("Blue", "Tata 4018");
        Bus bus = new Bus("Yellow", "Volvo B9R");
        Car car = new Car("Red", "Hyundai i20");

        System.out.println("== Truck ==");
        truck.showDetails();
        truck.carryLoad();

        System.out.println("\n== Bus ==");
        bus.showDetails();
        bus.transportPassengers();

        System.out.println("\n== Car ==");
        car.showDetails();
        car.drive();
    }
}
