package Homework12.Task1;

public class Printer implements Runnable {
    private final Object MONITOR;
    private boolean check = false;

    public Printer(Object MONITOR) {
        this.MONITOR = MONITOR;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            synchronized (MONITOR) {
                try {
                    MONITOR.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (check) {
                    System.out.println("5 seconds left");
                    check = false;
                }
            }
        }
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
