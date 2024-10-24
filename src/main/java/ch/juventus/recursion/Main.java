package ch.juventus.recursion;

public class Main {

    public static void main(String[] args) {

        int n = 40;

        System.out.println("Start iterative approach: " + System.currentTimeMillis());
        int itrResult = itrFib(n);
        System.out.println("Result: " + itrResult);
        System.out.println("End iterative approach: " + System.currentTimeMillis());

        System.out.println("Start recursive approach: " + System.currentTimeMillis());
        int recResult = recFib(n);
        System.out.println("Result: " + recResult);
        System.out.println("End recursive approach: " + System.currentTimeMillis());

    }

    private static int itrFib(int n) {
        int fib = 0;
        int prev = 1;
        for (int i = 0; i < n; i++) {
            int temp = fib;
            fib += prev;
            prev = temp;
        }
        return fib;
    }

    private static int recFib(int n) {
        if (n <= 1) {
            return n;
        } else {
            return recFib(n-2) + recFib(n-1);
        }
    }

}
