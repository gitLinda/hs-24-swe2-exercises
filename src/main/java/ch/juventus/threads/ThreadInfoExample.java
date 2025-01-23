package ch.juventus.threads;

public class ThreadInfoExample {

    public static void main(String[] args) {
        Runnable r = new ThreadInfo();

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        System.out.println("T1 -> " + t1.getState());
        t1.start();
        System.out.println("T1 -> " + t1.getState());

        System.out.println("T2 -> " + t2.getState());
        t2.start();
        System.out.println("T2 -> " + t2.getState());
    }
}
