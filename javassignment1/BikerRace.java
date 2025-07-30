//24.Five Bikers Compete in a race such that they drive at a constant speed which may or may
//not be the same as the other. To qualify the race, the speed of a racer must be more than the
//average speed of all 5 racers. Take as input the speed of each racer and print back the speed
//of qualifying racers. 



package javassignment1;

import java.util.Scanner;

public class BikerRace {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] speeds = new double[5];
        double sum = 0;

        System.out.println("Enter speeds of 5 bikers:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Speed of Biker " + (i + 1) + ": ");
            speeds[i] = sc.nextDouble();
            sum += speeds[i];
        }

        double average = sum / 5;
        System.out.println("\nAverage Speed: " + average);

        System.out.println("\nQualified Bikers (speed > average):");
        boolean anyQualified = false;
        for (int i = 0; i < 5; i++) {
            if (speeds[i] > average) {
                System.out.println("Biker " + (i + 1) + " with speed: " + speeds[i]);
                anyQualified = true;
            }
        }

        if (!anyQualified) {
            System.out.println("No biker qualified.");
        }

        sc.close();
    }
}


