package vl_20_01;

public class LD {
    public static void main(String[] args) throws InterruptedException {
        NewAccount newAccount = new NewAccount(0);
        new NewDepositThread(newAccount).start();
        System.out.println("waiting... ");
        newAccount.waitAndWithdraw(50_000_000);
        System.out.println(newAccount.getBalance());
    }

    private static class NewDepositThread extends Thread{
        private final NewAccount newAccount;

        public NewDepositThread(NewAccount newAccount) {
            this.newAccount = newAccount;
        }

        @Override
        public void run() {
            for (int i = 0; i < 60_000_000; i++) {
                newAccount.deposit(1);
            }
        }
    }
}
