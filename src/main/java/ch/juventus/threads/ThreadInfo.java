package ch.juventus.threads;

public class ThreadInfo implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Hello " + Thread.currentThread().getName());
    }
}
