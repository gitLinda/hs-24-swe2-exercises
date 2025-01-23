package ch.juventus.threads;

public class PrinterJob implements Runnable {

    private final Printer printer;

    public PrinterJob(Printer printer) {
        this.printer = printer;
    }

    @Override
    public void run() {
        printer.print();
    }
}
