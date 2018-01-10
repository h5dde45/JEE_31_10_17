package vlal.n10.e4;

public class Account {
    private long balance;

    public Account() {
        this(0L);
    }

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public void withdraw(long amount) {
        checkAmountNotNegative(amount);
        synchronized (this) {
            if (balance < amount) {
                throw new IllegalArgumentException("not enough money");
            }
            balance -= amount;
        }
    }

    public synchronized void waitAndWithdraw(long amount) throws InterruptedException {
        checkAmountNotNegative(amount);
            while (balance < amount) {
                wait();
            }
            balance -= amount;
    }

    public synchronized void deposit(long amount) {
        checkAmountNotNegative(amount);
            balance += amount;
        notifyAll();
    }

    private void checkAmountNotNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("a negative balance");
        }
    }
}
