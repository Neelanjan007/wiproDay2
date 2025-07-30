package javassignment1;

import java.util.Scanner;

public class shopkeeper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double total = 0.0;

        System.out.println("Enter product number (1, 2, 3) and quantity sold.");
        System.out.println("Enter 0 to stop.");

        while (true) {
            System.out.print("\nProduct number (1-3 or 0 to stop): ");
            int productNumber = scanner.nextInt();

            if (productNumber == 0) {
                break; 
            }

            System.out.print("Quantity sold: ");
            int quantity = scanner.nextInt();

            double price = 0.0;

            switch (productNumber) {
                case 1:
                    price = 22.50;
                    break;
                case 2:
                    price = 44.50;
                    break;
                case 3:
                    price = 9.98;
                    break;
                default:
                    System.out.println("Invalid product number.");
                    continue; 
            }

            double productTotal = price * quantity;
            total += productTotal;

            System.out.printf("Product %d | Quantity: %d | Subtotal: ₹%.2f\n", productNumber, quantity, productTotal);
        }

        System.out.printf("\nTotal retail value of all products sold: ₹%.2f\n", total);
        scanner.close();
    }
}

