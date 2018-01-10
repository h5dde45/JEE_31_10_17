package vlal.n10.e3;

public class WithdrawThread extends Thread{
    private final Account account;

    public WithdrawThread(Account account) {
        this.account = account;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20000; i++) {
            account.withdraw(1);
        }
    }
}
