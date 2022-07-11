package Homework12.Task1;

public class Main {
    final static Object MONITOR = new Object();

    public static void main(String[] args) throws InterruptedException {

        Printer printer = new Printer(MONITOR);
        Timer timer = new Timer(MONITOR, printer);
        Thread thread = new Thread(timer);
        Thread thread2 = new Thread(printer);
        thread.start();
        thread2.start();
    }
}
