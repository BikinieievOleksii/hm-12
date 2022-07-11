package Homework12.Task2;

import java.util.function.IntConsumer;

public class Main {
    public static void main(String[] args) {
        Task2 task2 = new Task2(15);

        Runnable printFizz = () -> System.out.print("fizz, ");
        Runnable printBuzz = () -> System.out.print("buzz, ");
        Runnable printFizzBuzz = () -> System.out.print("fizzbuzz, ");
        IntConsumer printNumber = i -> System.out.print(i + ", ");

        Thread threadA = new Thread(() -> {
            try {
                task2.fizz(printFizz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadB = new Thread(() -> {
            try {
                task2.buzz(printBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadC = new Thread(() -> {
            try {
                task2.fizzbuzz(printFizzBuzz);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread threadD = new Thread(() -> {
            try {
                task2.number(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();
    }
}
