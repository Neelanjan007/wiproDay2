//32.By using multiple catch blocks, write a class to demonstrate the order of the execution of the 
//catch blocks usingNegativeArraySizeException,ArrayIndexOutOfBoundsException, 
//StringIndexOutOfBoundsException, IndexOutOfBoundsException, NullPointerException,          
//ArithmeticException and print the stack trace for each exception.


package javassignment1;

public class MultipleCatchOrderDemo {
    public static void main(String[] args) {
        try {
            // Uncomment each block one at a time to test specific exception

            // 1. NegativeArraySizeException
            // int[] arr = new int[-5];

            // 2. ArrayIndexOutOfBoundsException
            // int[] arr = new int[3];
            // System.out.println(arr[5]);

            // 3. StringIndexOutOfBoundsException
            // String str = "Hello";
            // System.out.println(str.charAt(10));

            // 4. IndexOutOfBoundsException
            // java.util.List<Integer> list = new java.util.ArrayList<>();
            // System.out.println(list.get(1));

            // 5. NullPointerException
            // String s = null;
            // System.out.println(s.length());

            // 6. ArithmeticException
            int result = 10 / 0;

        } catch (NegativeArraySizeException e) {
            System.out.println("Caught NegativeArraySizeException");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException");
            e.printStackTrace();
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException");
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught IndexOutOfBoundsException");
            e.printStackTrace();
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException");
            e.printStackTrace();
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Caught General Exception");
            e.printStackTrace();
        }

        System.out.println("Program continues after handling exception.");
    }
}
