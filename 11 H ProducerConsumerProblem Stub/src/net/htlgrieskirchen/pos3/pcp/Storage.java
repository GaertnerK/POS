/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.htlgrieskirchen.pos3.pcp;

import java.util.IllegalFormatCodePointException;
import java.util.concurrent.ArrayBlockingQueue;

public class Storage { 
    private final ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
    
    private int fetchedCounter;
    private int storedCounter;
    private int underflowCounter;
    private int overflowCounter;
    private boolean productionComplete;
    
    public Storage() {
        fetchedCounter = 0;
        storedCounter = 0;
        underflowCounter = 0;
        overflowCounter = 0;
        productionComplete = false;
    }
    
    public synchronized boolean put(Integer data) throws InterruptedException {
        if (queue.size() == 10){
            overflowCounter++;
            return false;
        }else {
            System.out.println("INFO PUT: " + data);
            queue.put(data);
            storedCounter++;
        }
        return true;
    }
 
    public synchronized Integer get() {
        if (queue.isEmpty()){
            underflowCounter++;
            return null;
        }else {
            fetchedCounter++;
            return queue.poll();
        }
    }

    public boolean isProductionComplete() {
        return productionComplete;
    }

    public synchronized void setProductionComplete() {
        productionComplete = true;
    }

    public synchronized int getFetchedCounter() {
        return fetchedCounter;
    }

    public synchronized int getStoredCounter() {
        return storedCounter;
    }

    public int getUnderflowCounter() {
        return underflowCounter;
    }

    public int getOverflowCounter() {
        return overflowCounter;
    }

    public ArrayBlockingQueue<Integer> getQueue() {
        return queue;
    }
}
