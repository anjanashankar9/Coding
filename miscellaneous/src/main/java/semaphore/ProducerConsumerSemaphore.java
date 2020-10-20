package semaphore;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-18
 *
 * We have a buffer of fixed size. The producer can produce an item and place in the buffer.
 * A consumer can pick items and consume them.
 * We need to ensure that when the producer is producing an item, then the consumer should not be consuming an item.
 * i.e. buffer is the critical section.
 *
 * To solve this problem, we need 2 counting semaphores, full and empty.
 * Full keeps track of number of items in the buffer at any given time.
 * Empty keeps track of number of unoccupied slots.
 */

class Producer implements Runnable {

    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;
    LinkedList<Integer> buffer;
    int i = 0;

    Producer(Semaphore producerSemaphore, Semaphore consumerSemaphore,
             LinkedList<Integer> buffer) {
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(true) {
            try {
//                synchronized (this) {
                    System.out.println("Consumer with Semaphore permit ; " + consumerSemaphore.availablePermits());
                    System.out.println("Producer with Semaphore permit ; " + producerSemaphore.availablePermits());
                    producerSemaphore.acquire();
                    System.out.println("Produced : " + i);
                    synchronized (buffer) {
                        buffer.add(i++);
                    }
//                Thread.sleep(100);
                    consumerSemaphore.release();
//                }

            } catch (InterruptedException e) {
            }
        }
    }
}

class Consumer implements Runnable {

    Semaphore producerSemaphore;
    Semaphore consumerSemaphore;
    LinkedList<Integer> buffer;

    Consumer(Semaphore producerSemaphore, Semaphore consumerSemaphore,
            LinkedList<Integer> buffer) {
        this.producerSemaphore = producerSemaphore;
        this.consumerSemaphore = consumerSemaphore;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while(true) {
            try {
//                synchronized (this) {
                    System.out.println("Consumer with Semaphore permit ; " + consumerSemaphore.availablePermits());
                    System.out.println("Producer with Semaphore permit ; " + producerSemaphore.availablePermits());
                    consumerSemaphore.acquire();
                    synchronized (buffer) {
                        System.out.println("Consumed : " + buffer.size() + " " + buffer.remove());
                    }
//                Thread.sleep(100);
                    producerSemaphore.release();
//                }

            } catch (InterruptedException e) {
            }
        }
    }
}

public class ProducerConsumerSemaphore {
    private LinkedList<Integer> buffer = new LinkedList<>();
    private int capacity = 3;
    private int items = 0;

    public int remove() {
        int val = buffer.removeFirst();
        items--;
        return val;
    }

    public void add(int item) {
        buffer.add(item);
        items++;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public static void main(String[] args) {
        ProducerConsumerSemaphore pc = new ProducerConsumerSemaphore();

        Semaphore producerSemaphore = new Semaphore(pc.getCapacity());
        Semaphore consumerSemaphore = new Semaphore(0);

        Producer producer=new Producer(producerSemaphore, consumerSemaphore,
                pc.buffer);
        Consumer consumer=new Consumer(producerSemaphore, consumerSemaphore,
                pc.buffer);

        Thread producerThread = new Thread(producer, "ProducerThread");
        Thread consumerThread = new Thread(consumer, "ConsumerThread");

        producerThread.start();
        consumerThread.start();

    }
}


//Reference : http://www.cs.loyola.edu/~jglenn/702/F2007/Examples/Producer_Consumer_Semaphores/pc_semaphore.html