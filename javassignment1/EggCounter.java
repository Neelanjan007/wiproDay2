//10. Consider user has N eggs. Then display the no of eggs in gross (144 eggs make one gross) and 
//  no of eggs in dozen (12 eggs make one dozen) and the no of eggs that is left out remaining. 
//  The total no of eggs can be got as input through command line. The program should display
//    how many gross, how many dozen, and how many left over eggs the user has.
//   Solution Guidance (if applicable): For example, if the input is 1342 eggs, then the program should respond with 
// Your number of eggs is 9 gross, 3 dozen, and 10


package javassignment1;

public class EggCounter {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please provide the number of eggs as a command line argument.");
            return;
        }

        try {
            int eggs = Integer.parseInt(args[0]);

            int gross = eggs / 144;
            int remainderAfterGross = eggs % 144;

            int dozen = remainderAfterGross / 12;
            int leftover = remainderAfterGross % 12;

            System.out.println("Your number of eggs is " + gross + " gross, " + dozen + " dozen, and " + leftover);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid integer number.");
        }
    }
}


//i/p : 1622
//o/p : Your number of eggs is 11 gross, 3 dozen, and 2

