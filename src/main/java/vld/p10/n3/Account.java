package vld.p10.n3;

public class Account {
    private long balance;

    public Account() {
    }

    public Account(long balance) {
        this.balance = balance;
    }

    public long getBalance() {
        return balance;
    }

    public synchronized void deposit(long amount) {
        checkAmountNonNegative(amount);
        balance += amount;
        notify();
    }

    public void withDraw(long amount) {
        checkAmountNonNegative(amount);
        synchronized (this){
            if (balance < amount) {
                throw new IllegalArgumentException("not enough money");
            }
            balance -= amount;
        }
    }

    public synchronized void waitAndWithDraw(long amount) throws InterruptedException {
        checkAmountNonNegative(amount);
        while (balance<amount){
            wait();
        }
            balance -= amount;
    }

    private void checkAmountNonNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("negative amount");
        }
    }
}



