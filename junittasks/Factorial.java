package junittasks;

public class Factorial {
	    public static int fact(int n) {
	        if (n < 0) {
	            throw new IllegalArgumentException("Negative numbers not allowed");
	        }
	        int result = 1;
	        for (int i = 2; i <= n; i++) {
	            result *= i;
	        }
	        return result;
	    }
	}