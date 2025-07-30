//21.Write a Java program to create an abstract class Person with abstract methods eat() and exercise(). Create subclasses Athlete and LazyPerson that extend the Person 
//class and implement the respective methods to describe how each person eats and exercises.


package javassignment1;


abstract class Person {
 abstract void eat();
 abstract void exercise();
}


class Athlete extends Person {
 @Override
 void eat() {
     System.out.println("Athlete eats a balanced diet rich in protein and vitamins.");
 }

 @Override
 void exercise() {
     System.out.println("Athlete exercises daily with intense workouts and training.");
 }
}


class LazyPerson extends Person {
 @Override
 void eat() {
     System.out.println("Lazy person prefers junk food and snacks.");
 }

 @Override
 void exercise() {
     System.out.println("Lazy person avoids exercise and prefers resting.");
 }
}


public class PersonTest {
 public static void main(String[] args) {
     Person athlete = new Athlete();
     Person lazy = new LazyPerson();

     System.out.println("Athlete:");
     athlete.eat();
     athlete.exercise();

     System.out.println("\nLazyPerson:");
     lazy.eat();
     lazy.exercise();
 }
}

