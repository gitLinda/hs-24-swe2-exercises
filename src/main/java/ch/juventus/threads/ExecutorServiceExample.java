package ch.juventus.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample {

    public static void main(String[] args) {

        try(ExecutorService executor = Executors.newFixedThreadPool(2)) {

            Callable<String> callable1 = () -> {
                Thread.sleep(500);
                return "Result 1";
            };
            Callable<String> callable2 = () -> {
                Thread.sleep(500);
                return "Result 2";
            };

            Future<String> future1 = executor.submit(callable1);
            Future<String> future2 = executor.submit(callable2);

            while (!(future1.isDone() && future2.isDone())) {
                System.out.printf(
                        "future1 is %s and future2 is %s%n",
                        future1.isDone() ? "done" : "not done",
                        future2.isDone() ? "done" : "not done"
                );
                Thread.sleep(100);
            }

            String result1 = future1.get();
            String result2 = future2.get();

            System.out.println(result1 + " and " + result2);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
