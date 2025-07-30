//26.Given integer array, remove the duplicate elements and print sum of even 
//numbers in the array.
//input 1={2,3,54,1,6,7,7}


package javassignment1;

import java.util.*;

public class RemoveDuplicatesAndSumEven {
    public static void main(String[] args) {
        Integer[] input = {2, 3, 54, 1, 6, 7, -7, 7, 1, 0, 0};

       
        Set<Integer> uniqueNumbers = new HashSet<>(Arrays.asList(input));

     
        int evenSum = uniqueNumbers.stream()
                                   .filter(n -> n % 2 == 0)
                                   .mapToInt(Integer::intValue)
                                   .sum();
        
        
        System.out.println("input = 2, 3, 54, 1, 6, 7, -7, 7, 1, 0, 0};");
        System.out.println("Unique elements: " + uniqueNumbers);
        System.out.println("Sum of even numbers: " + evenSum);
    }
}

