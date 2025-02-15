/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.pcp;

import java.util.ArrayList;
import java.util.List;


public class Consumer implements Runnable {
    private final String name;
    private final Storage storage;
    private final int sleepTime;
    
    private final List<Integer> received;
    private boolean running;
    
    public Consumer(String name, Storage storage, int sleepTime) {
        this.name = name;
        this.storage = storage;
        this.sleepTime = sleepTime;
        received = new ArrayList<Integer>();
        running = true;
    }

    public void setRunning() {
        this.running = false;
    }

    public String getName() {
        return name;
    }

    public Storage getStorage() {
        return storage;
    }

    public int getSleepTime() {
        return sleepTime;
    }

    public boolean isRunning() {
        return running;
    }

    public List<Integer> getReceived() {
        return received;
    }

    @Override
    public void run() {
        do {
            Integer result = storage.get();
            System.out.println("Info: " + result);
            if (result != null) {
                received.add(result);
            } else {
                if (storage.isProductionComplete()){
                    break;
                }
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    System.out.println("Consumer interrupted");
                }
            }
        }while (running);
        System.out.println("Consumer stopped");
    }
}

