// 19.The following are the superclass Bank and its subclasses Saving and Current.
//                          Super class : Bank
//                          public class Bank 
//                          {
//                          String accNo;  //customer account number with Bank
//                          String custName; //customer name
//                          int custGender;  //customer gender 1 = Male, 2 =Female
//                          String custJob;  //customer job positions
//                          double curBal;  //customer balance in the bank account
//                          public String toString();
//                          public abstract double calcBalance();
//                          }
//
//                          Subclass : Saving
//                          public class Saving 
//                          {
//                          double savRate;  //percent interest rate per year
//                          }
//
//                          Subclass : Current
//                          public class Current
//                          {
//                          boolean fixedDep;  //whether the customer keeps the fixed// deposit with the bank of not
//                          double curRate;  //percent interest rate per year
//                          }
//
//                          The  above  classes  show  that  Bank  can  have  two  different  types  of  account  which  are Saving  and  Current  account.
//                            The  balance amount  in the  bank for  each account  is basedon the following calculation :
//
//                          Saving :Balance =  current balance + (savRate * current balance)
//                          Current :Balance = current balance + (curRate * current balance)
//
//                          If the customer has a fixed deposit with the bank, then the bank will charge RM150for the service fee.  
//                          The amount will be deducted automatically yearly.
//
//                          a)  Write a method of calcBalance() for both subclasses.
//                          b)  Search  a  customer  based  on  the  account  number  entered  then  display  detailinformation  of  him/her.  If  the  customer  account  number  is  not  found,  display  anappropriate message.
//                          c)  Count how many customers that have the current account with the bank and the totalbalance.  


package javassignment1;

import java.util.*;

abstract class Bank {
    String accNo;
    String custName;
    int custGender; // 1 = Male, 2 = Female
    String custJob;
    double curBal;

    Bank(String accNo, String custName, int custGender, String custJob, double curBal) {
        this.accNo = accNo;
        this.custName = custName;
        this.custGender = custGender;
        this.custJob = custJob;
        this.curBal = curBal;
    }

    public String toString() {
        String genderStr = (custGender == 1) ? "Male" : "Female";
        return "Account No: " + accNo + "\nName: " + custName + "\nGender: " + genderStr +
               "\nJob: " + custJob + "\nCurrent Balance: RM" + curBal;
    }

    public abstract double calcBalance();
}


class Saving extends Bank {
    double savRate;

    Saving(String accNo, String custName, int custGender, String custJob, double curBal, double savRate) {
        super(accNo, custName, custGender, custJob, curBal);
        this.savRate = savRate;
    }

    public double calcBalance() {
        return curBal + (savRate * curBal);
    }
}


class Current extends Bank {
    boolean fixedDep;
    double curRate;

    Current(String accNo, String custName, int custGender, String custJob, double curBal,
            double curRate, boolean fixedDep) {
        super(accNo, custName, custGender, custJob, curBal);
        this.curRate = curRate;
        this.fixedDep = fixedDep;
    }

    public double calcBalance() {
        double balance = curBal + (curRate * curBal);
        if (fixedDep) {
            balance -= 150; // service charge
        }
        return balance;
    }
}


public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Bank> accounts = new ArrayList<>();

        
        accounts.add(new Saving("S001", "Ram", 2, "Teacher", 10000, 0.05));
        accounts.add(new Current("C001", "Shyam", 1, "Engineer", 15000, 0.03, true));
        accounts.add(new Saving("S002", "Satya", 1, "Clerk", 8000, 0.04));
        accounts.add(new Current("C002", "Akash", 2, "Doctor", 20000, 0.025, false));
        accounts.add(new Current("C003", "Neelanjan", 1, "Manager", 18000, 0.03, true));

      
        System.out.println("Balances:");
        for (Bank b : accounts) {
            System.out.println(b);
            System.out.println("Updated Balance: RM" + b.calcBalance());
            System.out.println("---------------------");
        }

     
        System.out.print("Enter account number to search: ");
        String searchAcc = sc.nextLine();
        boolean found = false;
        for (Bank b : accounts) {
            if (b.accNo.equalsIgnoreCase(searchAcc)) {
                System.out.println("Customer Found:\n" + b);
                System.out.println("Updated Balance: RM" + b.calcBalance());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Account number not found.");
        }

        // c) Count current accounts and total balance
        int currentCount = 0;
        double currentTotalBalance = 0;
        for (Bank b : accounts) {
            if (b instanceof Current) {
                currentCount++;
                currentTotalBalance += b.calcBalance();
            }
        }

        System.out.println("\nTotal number of current accounts: " + currentCount);
        System.out.println("Total balance in current accounts: RM" + currentTotalBalance);
    }
}

