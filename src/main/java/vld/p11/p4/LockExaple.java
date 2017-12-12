package vld.p11.p4;

public class LockExaple {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(0);

        new DepositThread(account).start();
        System.out.println("Entering waitAndWithdraw");
        account.waitAndWithdraw(50_000_000L);

        System.out.println("waitAndWithdraw finished, end balance = " + account.getBalance());
    }

    private static class DepositThread extends Thread {
        private final Account account;

        public DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 60_000_000; i++) {
                account.deposit(1);
            }
        }
    }
}
