package vlal.n10.e3;

public class Example03 {
    public static void main(String[] args) throws InterruptedException {
        Account account=new Account(100_000);
        System.out.println("balance: "+account.getBalance());

        WithdrawThread withdrawThread = new WithdrawThread(account);
        DepositThread depositThread = new DepositThread(account);

        depositThread.start();
        withdrawThread.start();

        depositThread.join();
        withdrawThread.join();

        System.out.println(account.getBalance());

    }
}
