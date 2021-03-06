package vlal.n10.e4;

public class Example04 {
    public static void main(String[] args) throws InterruptedException {
        Account account=new Account(0);
        new DepositThread(account).start();
        System.out.println("calling wAithdraw..");

        account.waitAndWithdraw(50_000_000);
        System.out.println("wAw end");
    }

    private static class DepositThread extends Thread {
        private final Account account;

        public DepositThread(Account account) {
            this.account = account;
        }

        @Override
        public void run() {
            for (int i = 0; i < 50_000_000; i++) {
                account.deposit(1);
            }
        }
    }
}
