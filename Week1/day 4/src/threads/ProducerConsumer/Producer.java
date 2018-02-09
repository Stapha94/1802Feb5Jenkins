package threads.ProducerConsumer;

import java.util.List;

public class Producer implements Runnable {
    private final List<Integer> taskQueue;
    private final int MAX_CAPACITY;

    public Producer(List<Integer> taskQueue, int capacity) {
        this.taskQueue = taskQueue;
        this.MAX_CAPACITY = capacity;
    }

    @Override
    public void run() {
        int counter = 0;

        while(true) {
            try {
                produce(counter++);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void produce(int i) throws InterruptedException {
        synchronized (taskQueue) {
            while(taskQueue.size() == MAX_CAPACITY) {
                System.out.println("Thread: " + Thread.currentThread().getName() + " is waiting for the consumer");
                taskQueue.wait();
            }

            Thread.sleep(500);
            taskQueue.add(i);
            System.out.println("Produced " + i);
            taskQueue.notifyAll();
        }
    }
}
