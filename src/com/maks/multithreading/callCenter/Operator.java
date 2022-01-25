package com.maks.multithreading.callCenter;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class Operator implements Runnable {

    private BlockingQueue<Integer> clients;
    private int id;

    public Operator(final BlockingQueue<Integer> clients, final int id) {
        this.clients = clients;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (ThreadLocalRandom.current().nextBoolean()) {
                    final int idClientRand = clients.take();
                    System.out.println(idClientRand + " client decided to call back later");
                }
                final int idClient = clients.take();
                System.out.println("Operator " + id + " starting call with client " + idClient);
                Thread.sleep(ThreadLocalRandom.current().nextInt(10000 + 1 - 3000) + 3000);
                System.out.println("Operator " + id + " finishing call with client " + idClient);
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
