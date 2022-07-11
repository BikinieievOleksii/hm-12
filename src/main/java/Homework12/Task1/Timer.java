package Homework12.Task1;

public class Timer implements Runnable {
    private int secondsPassed = 0;
    private final Object MONITOR;
    private final Printer printer;

    public Timer(Object MONITOR, Printer printer) {
        this.MONITOR = MONITOR;
        this.printer = printer;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                increment();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (MONITOR) {
                if (secondsPassed % 5 == 0) {
                    printer.setCheck(true);
                    MONITOR.notifyAll();
                }
            }
        }
    }

    synchronized public void increment() throws InterruptedException {
        Thread.sleep(1000);
        secondsPassed++;
        System.out.println(secondsPassed);
    }
}
