/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.pcp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class Producer implements Runnable {
    private final String name;
    private final Storage storage;
    private final int sleepTime;

    private final List<Integer> sent;
    private final int numberOfItems;
    
    public Producer(String name, Storage storage, int sleepTime, int numberOfItems) {
       this.name = name;
       this.storage = storage;
       this.sleepTime = sleepTime;
       this.numberOfItems = numberOfItems;
       sent = new ArrayList<Integer>();
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

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public List<Integer> getSent() {
        return sent;
    }

    @Override
    public void run() {
        for (int i = 0; i < numberOfItems; i++) {
            try {
                while (!storage.put(i)){
                    Thread.sleep(sleepTime);
                }
                sent.add(i);
            } catch (InterruptedException e) {
                System.out.println("Producer interrupted");
            }
        }
        storage.setProductionComplete();
        System.out.println("Producer completed");
    }
}
