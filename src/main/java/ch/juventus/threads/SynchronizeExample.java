package ch.juventus.threads;

public class SynchronizeExample {
    public static void main(String[] args) {
        AccountDanger ad = new AccountDanger();
        Thread one = new Thread(ad);
        Thread two = new Thread(ad);
        one.setName("Fred");
        two.setName("Lucy");
        one.start();
        two.start();
    }
}
