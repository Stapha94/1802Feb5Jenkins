package com.threads.producerconsumer;

import java.util.List;

public class Producer implements Runnable {

    private final List<Integer> tastQueue;
    private final int MAX_CAPACITY;

    public Producer(List<Integer> taskQueue, int capacity){

        this.tastQueue = taskQueue;
        this.MAX_CAPACITY = capacity;

    }

    @Override
    public void run() {

        int counter = 0;

        while(true){

            produce(counter++);

        }

    }

}
