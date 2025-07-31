package mockito_tasks;

public class Account {
    private Long id;
    private double balance;

    public Account(Long id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Long getId() { return id; }

    public double getBalance() { return balance; }

    public void debit(double amount) {
        if (amount > balance) throw new IllegalArgumentException("Insufficient balance");
        balance -= amount;
    }

    public void credit(double amount) {
        balance += amount;
    }
}

