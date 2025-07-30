//1.class Product::
//
//id:Long
//name:String
//category:String
//price:Double
//
//
//2. class Customer:
//
//id:Long
//name:String
//tier:Integer
//
//3.class Order:
//
//id:Long
//status:String
//orderDate:LocalDate
//deliveryDate:LocalDate
//products:List<Product>
//customer:Customer
//
//
//1.Obtain a list of products belongs to category  Books  with price > 100
//2.Obtain a list of order with products belong to category  Baby 
//3.Obtain a list of product with category =  Toys  and then apply 10% discount
//4.Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
//5.Get the cheapest products of  Books  category hint: use findFirst()
//6.Get the 3 most recent placed order( sort the order records by order date field. The tricky part is that the sorting this time should be in descending order such that you can obtain the order records with the most recent order date.)
//7.Calculate total lump sum of all orders placed in Feb 2021
//8.Obtain a collection of statistic figures (i.e. sum, average, max, min, count) for all products of category  Books 
//What if you need to get sum, average, max, min and count at the same time? Should we run the data stream 5 times to get those figures one by one? Such an approach is not quite effective. Luckily, stream API provides a convenient way to get all those values at once by using terminal operation summaryStatistics(). It returns a data type DoubleSummaryStatistics which contains all the required figures.
//9.Get the most expensive product by category hint:use Collectors.maxBy()



package javassignment1;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;

class Product {
    Long id;
    String name;
    String category;
    Double price;

    Product(Long id, String name, String category, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String toString() {
        return name + " - " + category + " - Rs." + price;
    }
}

class Customer {
    Long id;
    String name;
    Integer tier;

    Customer(Long id, String name, Integer tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }
}

class Order {
    Long id;
    String status;
    LocalDate orderDate;
    LocalDate deliveryDate;
    List<Product> products;
    Customer customer;

    Order(Long id, String status, LocalDate orderDate, LocalDate deliveryDate,
          List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }
}

public class StreamOrderQueries {
    public static void main(String[] args) {
       
        Product p1 = new Product(1L, "Java Book", "Books", 150.0);
        Product p2 = new Product(2L, "Baby Diaper", "Baby", 80.0);
        Product p3 = new Product(3L, "Toy Car", "Toys", 300.0);
        Product p4 = new Product(4L, "Python Book", "Books", 90.0);
        Product p5 = new Product(5L, "Lego Set", "Toys", 500.0);

        Customer c1 = new Customer(1L, "Neelanjan", 1);
        Customer c2 = new Customer(2L, "Akash", 2);

        Order o1 = new Order(1L, "DELIVERED", LocalDate.of(2021, 2, 10), LocalDate.of(2021, 2, 15),
                Arrays.asList(p1, p2), c1);
        Order o2 = new Order(2L, "SHIPPED", LocalDate.of(2021, 3, 5), LocalDate.of(2021, 3, 12),
                Arrays.asList(p3, p5), c2);
        Order o3 = new Order(3L, "DELIVERED", LocalDate.of(2021, 2, 20), LocalDate.of(2021, 2, 25),
                Arrays.asList(p4), c2);
        Order o4 = new Order(4L, "NEW", LocalDate.of(2021, 4, 5), LocalDate.of(2021, 4, 10),
                Arrays.asList(p1, p5), c2);

        List<Order> orders = Arrays.asList(o1, o2, o3, o4);
        List<Product> allProducts = Arrays.asList(p1, p2, p3, p4, p5);

       
        System.out.println("\n1. Books with price > 100:");
        allProducts.stream()
                .filter(p -> p.category.equalsIgnoreCase("Books") && p.price > 100)
                .forEach(System.out::println);

     
        System.out.println("\n2. Orders with Baby products:");
        orders.stream()
                .filter(o -> o.products.stream().anyMatch(p -> p.category.equalsIgnoreCase("Baby")))
                .forEach(o -> System.out.println("Order ID: " + o.id));

      
        System.out.println("\n3. Toys with 10% discount:");
        allProducts.stream()
                .filter(p -> p.category.equalsIgnoreCase("Toys"))
                .map(p -> new Product(p.id, p.name, p.category, p.price * 0.9))
                .forEach(System.out::println);

    
        System.out.println("\n4. Products ordered by Tier 2 customers in date range:");
        orders.stream()
                .filter(o -> o.customer.tier == 2
                        && o.orderDate.isAfter(LocalDate.of(2021, 1, 31))
                        && o.orderDate.isBefore(LocalDate.of(2021, 4, 2)))
                .flatMap(o -> o.products.stream())
                .distinct()
                .forEach(System.out::println);

   
        System.out.println("\n5. Cheapest Book:");
        allProducts.stream()
                .filter(p -> p.category.equalsIgnoreCase("Books"))
                .sorted(Comparator.comparingDouble(p -> p.price))
                .findFirst()
                .ifPresent(System.out::println);

       
        System.out.println("\n6. 3 Most Recent Orders:");
        orders.stream()
                .sorted(Comparator.comparing(Order::orderDate).reversed())
                .limit(3)
                .forEach(o -> System.out.println("Order ID: " + o.id + " Date: " + o.orderDate));

      
        System.out.println("\n7. Total lump sum for Feb 2021:");
        double febTotal = orders.stream()
                .filter(o -> o.orderDate.getMonthValue() == 2 && o.orderDate.getYear() == 2021)
                .flatMap(o -> o.products.stream())
                .mapToDouble(p -> p.price)
                .sum();
        System.out.println("Total: Rs." + febTotal);

      
        System.out.println("\n8. Summary stats for Books:");
        DoubleSummaryStatistics stats = allProducts.stream()
                .filter(p -> p.category.equalsIgnoreCase("Books"))
                .mapToDouble(p -> p.price)
                .summaryStatistics();
        System.out.println("Count: " + stats.getCount());
        System.out.println("Sum: " + stats.getSum());
        System.out.println("Avg: " + stats.getAverage());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Max: " + stats.getMax());

        
        System.out.println("\n9. Most expensive product by category:");
        Map<String, Optional<Product>> maxByCategory = allProducts.stream()
                .collect(Collectors.groupingBy(
                        p -> p.category,
                        Collectors.maxBy(Comparator.comparingDouble(p -> p.price))
                ));
        maxByCategory.forEach((cat, productOpt) -> {
            System.out.println("Category: " + cat + " -> " + productOpt.orElse(null));
        });
    }
}
