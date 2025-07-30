/*
 * 28.
Write the following methods that return a lambda expression performing a specified action:

PerformOperation isOdd(): The lambda expression must return true  if a number is odd or false  if it is even.
PerformOperation isPrime(): The lambda expression must return  true if a number is prime or false  if it is composite.
PerformOperation isPalindrome(): The lambda expression must return true   if a number is a palindrome or false  if it is not. 
 */

package javassignment1;

@FunctionalInterface
interface PerformOperation {
    boolean check(int a);
}

class LambdaOperations {

    public static PerformOperation isOdd() {
        return x -> x % 2 != 0;
    }

    public static PerformOperation isPrime() {
        return x -> {
            if (x < 2) return false;
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) return false;
            }
            return true;
        };
    }

    public static PerformOperation isPalindrome() {
        return x -> {
            int original = x;
            int reversed = 0;
            while (x > 0) {
                int digit = x % 10;
                reversed = reversed * 10 + digit;
                x /= 10;
            }
            return original == reversed;
        };
    }
}

public class Lambda {
    public static void main(String[] args) {
        PerformOperation oddCheck = LambdaOperations.isOdd();
        PerformOperation primeCheck = LambdaOperations.isPrime();
        PerformOperation palindromeCheck = LambdaOperations.isPalindrome();

        int testNum1 = 17;
        int testNum2 = 22;
        int testNum3 = 121;

        System.out.println("Is " + testNum1 + " odd? " + oddCheck.check(testNum1));
        System.out.println("Is " + testNum1 + " prime? " + primeCheck.check(testNum1));
        System.out.println("Is " + testNum3 + " a palindrome? " + palindromeCheck.check(testNum3));
        System.out.println("Is " + testNum2 + " odd? " + oddCheck.check(testNum2));
        System.out.println("Is " + testNum2 + " a palindrome? " + palindromeCheck.check(testNum2));
    }
}
