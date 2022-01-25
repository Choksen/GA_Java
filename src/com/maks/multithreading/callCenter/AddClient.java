package com.maks.multithreading.callCenter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class AddClient implements Runnable {
    private BlockingQueue<Integer> clients;
    private int count = 1;

    public AddClient(final BlockingQueue<Integer> clients) {
        this.clients = clients;
    }

    @Override
    public void run() {
        while (true) {
            clients.offer(count++);
            System.out.println("Client " + count + " added to queue");
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(4000));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
