package com.main;

import java.util.List;
import java.util.Scanner;

import com.bean.Product;
import com.config.AppConfig;
import com.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BillingApp {
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductService service = context.getBean(ProductService.class);

        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n1. Generate Bill");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Available Products:");
                    List<Product> productList = service.getAllProducts();
                    System.out.printf("%-10s %-20s %-15s %-25s %-10s\n",
                            "Code", "Name", "Category", "Description", "Price");
                    for (Product p : productList) {
                        System.out.printf("%-10d %-20s %-15s %-25s ₹%.2f\n",
                                p.getProduct_code(), p.getProduct_name(),
                                p.getProduct_category(), p.getProduct_description(),
                                p.getProduct_price());
                    }
                    System.out.println("----------------------------------------------------");

                   
                    class BillItem {
                        Product product;
                        int quantity;
                        double total;
                    }

                    List<BillItem> cart = new java.util.ArrayList<>();
                    String more;

                    do {
                        int code = 0, qty = 0;
                        boolean valid = false;

                        while (!valid) {
                            try {
                                System.out.print("Enter product code: ");
                                code = sc.nextInt();
                                if (!service.validateProductCode(code)) {
                                    throw new BillingException("❌ Invalid product code.");
                                }
                                valid = true;
                            } catch (BillingException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        valid = false;
                        while (!valid) {
                            try {
                                System.out.print("Enter quantity: ");
                                qty = sc.nextInt();
                                if (!service.validateQuantity(qty)) {
                                    throw new BillingException("❌ Invalid quantity.");
                                }
                                valid = true;
                            } catch (BillingException e) {
                                System.out.println(e.getMessage());
                            }
                        }

                        Product p = service.getProductDetails(code);
                        double total = service.calculatePrice(qty, p.getProduct_price());

                        BillItem item = new BillItem();
                        item.product = p;
                        item.quantity = qty;
                        item.total = total;

                        cart.add(item);

                        System.out.print("Do you want to add another product? (yes/no): ");
                        sc.nextLine();
                        more = sc.nextLine().trim().toLowerCase();
                    } while (more.equals("yes") || more.equals("y"));

                    System.out.println("\n🧾 Final Bill");
                    System.out.printf("%-20s %-10s %-10s %-10s\n", "Product", "Qty", "Price", "Total");
                    double grandTotal = 0;
                    for (BillItem item : cart) {
                        System.out.printf("%-20s %-10d ₹%-9.2f ₹%-9.2f\n",
                                item.product.getProduct_name(),
                                item.quantity,
                                item.product.getProduct_price(),
                                item.total);
                        grandTotal += item.total;
                    }
                    System.out.println("----------------------------------------------------");
                    System.out.printf("🟩 Grand Total: ₹%.2f\n", grandTotal);
                    break;

                case 2:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("❗ Enter option 1 or 2 only.");
            }
        } while (choice != 2);
    }
}

/*
 * 
 * output----------------------------------------------------------------------------

 * 
1. Generate Bill
2. Exit
Enter your choice: 1
Available Products:
Code       Name                 Category        Description               Price     
1002       LEDTV                electronics     TV                        ₹45000.00
1003       iPhone 14            mobiles         Smartphone                ₹70000.00
1004       Rice Cooker          home-appliance  Electric rice cooker      ₹2500.00
1005       Fan                  home-appliance  Ceiling fan               ₹3200.00
1006       Laptop               electronics     Dell Inspiron             ₹58000.00
----------------------------------------------------
Enter product code: 1003
Enter quantity: 1
Do you want to add another product? (yes/no): yes
Enter product code: 1004
Enter quantity: 1
Do you want to add another product? (yes/no): yes
Enter product code: 1005
Enter quantity: 1
Do you want to add another product? (yes/no): no

🧾 Final Bill
Product              Qty        Price      Total     
iPhone 14            1          ₹70000.00  ₹70000.00 
Rice Cooker          1          ₹2500.00   ₹2500.00  
Fan                  1          ₹3200.00   ₹3200.00  
----------------------------------------------------
🟩 Grand Total: ₹75700.00

1. Generate Bill
2. Exit
Enter your choice: 
 * 
 */
