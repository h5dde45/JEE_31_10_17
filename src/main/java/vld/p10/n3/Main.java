package vld.p10.n3;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(100_000);
//        Account account = new Account(0);
        System.out.println("balance: " + account.getBalance());

        WithDrawThread withDrawThread = new WithDrawThread(account);
        DepositThread depositThread = new DepositThread(account);
        withDrawThread.start();
        depositThread.start();
        withDrawThread.join();
        depositThread.join();

//        account.waitAndWithDraw(50_000_000);

        System.out.println("End balance: " + account.getBalance());

    }

    private static class WithDrawThread extends Thread {
        private final Account account;

        public WithDrawThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20_000; i++) {
                account.withDraw(1);
            }
        }
    }

    private static class DepositThread extends Thread {
        private final Account account;

        public DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 20_000; i++) {
                account.deposit(1);
            }
        }
    }
}
