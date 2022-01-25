package com.maks.multithreading.philosophers;

public class Philosopher implements Runnable {
    private final Object leftFork;
    private final Object rightFork;

    public Philosopher(final Object leftFork, final Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        int count = 5;
        try {
            while (count != 0) {
                doAction(" thinks");
                synchronized (leftFork) {
                    doAction(" take left fork");
                    synchronized (rightFork) {
                        doAction(" take right fork and eat");
                        doAction(" put down right fork");
                        count--;
                    }
                    doAction(" put down left fork");
                }
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }

    private void doAction(final String action) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep((long) (Math.random() * 4000));
    }
}
