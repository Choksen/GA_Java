package com.maks.multithreading.philosophers;

public class PhilosophersRun {
    public static void main(final String[] args) {
        final Philosopher[] philosophers = new Philosopher[5];
        final Object[] forks = new Object[5];

        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {
            final Object leftFork = forks[i];
            final Object rightFork = forks[(i + 1) % forks.length];

            if (i == philosophers.length - 1) {
                philosophers[i] = new Philosopher(rightFork, leftFork);
            } else {
                philosophers[i] = new Philosopher(leftFork, rightFork);
            }

            final Thread threadPhilosopher = new Thread(philosophers[i], "Philosopher " + (i + 1));
            threadPhilosopher.start();
        }
    }
}
