package com.maks.multithreading.callCenter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class StartWork {
    public static void main(final String[] args) {

        final int countOperators = 5;
        final BlockingQueue clients = new PriorityBlockingQueue();

        final AddClient addClient = new AddClient(clients);
        final Thread threadAddClient = new Thread(addClient);
        threadAddClient.start();
        for (int i = 0; i < countOperators; i++) {
            final Thread threadOperator = new Thread(new Operator(clients, i + 1));
            threadOperator.start();
        }
    }
}
