package ch.juventus.threads;

public class PrinterExample {

    public static void main(String[] args) {
        Printer printer = new Printer();
        PrinterJob job = new PrinterJob(printer);
        new Thread(job).start();
        new Thread(job).start();
    }

}
