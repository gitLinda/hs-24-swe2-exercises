package ch.juventus.threads;

public class AccountDanger implements Runnable {

    private final Account account = new Account(50);

    @Override
    public void run() {
        for (int x = 0; x < 5; x++) {
            makeWithdrawal(10);
            if (account.getBalance() < 0) {
                System.out.println("account is overdrawn!");
            }
        }
    }

    private void makeWithdrawal(int amount) {
//        synchronized (account) {
            if (account.getBalance() >= amount) {
                System.out.println(Thread.currentThread().getName() + " is going to withdraw");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) { }
                account.withdraw(amount);
                System.out.println(Thread.currentThread().getName() + " completes the withdraw");
            } else {
                System.out.println("Not enough in account for " + Thread.currentThread().getName() +
                        " to withdraw " +  account.getBalance());
            }
//        }
    }

}
