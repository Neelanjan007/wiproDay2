//27.Create an enum of the six types of paper currency. Loop through the values( ) and print each value. Write a switch statement for the enum.  For each
//   case, output a description of that particular currency.


package javassignment1;

import java.util.Scanner;


enum Currency {
 ONE, FIVE, TEN, TWENTY, FIFTY, HUNDRED
}

public class CurrencyEnumDemo {
 public static void main(String[] args) {
     Scanner sc = new Scanner(System.in);

     System.out.println("Enter currency name (ONE, FIVE, TEN, TWENTY, FIFTY, HUNDRED):");
     String input = sc.nextLine().trim().toUpperCase(); // Case-insensitive handling

     try {
         Currency currency = Currency.valueOf(input);
         printDescription(currency);
     } catch (IllegalArgumentException e) {
         System.out.println("Invalid currency entered.");
     }

     System.out.println("\n--- All Currency Descriptions ---");
     for (Currency c : Currency.values()) {
         System.out.print(c + ": ");
         printDescription(c);
     }
 }

 
 public static void printDescription(Currency currency) {
     switch (currency) {
         case ONE:
             System.out.println("One rupee note (rare now).");
             break;
         case FIVE:
             System.out.println("Five rupees note, green.");
             break;
         case TEN:
             System.out.println("Ten rupees note, orange.");
             break;
         case TWENTY:
             System.out.println("Twenty rupees note, yellow-red.");
             break;
         case FIFTY:
             System.out.println("Fifty rupees note, purple.");
             break;
         case HUNDRED:
             System.out.println("One hundred rupees note, blue-purple.");
             break;
     }
 }
}

