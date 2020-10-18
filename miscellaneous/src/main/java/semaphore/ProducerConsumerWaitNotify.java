package semaphore;

import java.util.LinkedList;

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

public class ProducerConsumerWaitNotify {
    LinkedList<Integer> buffer = new LinkedList<>();
    int capacity = 5;

    public void produce() throws InterruptedException {
        int value = 0;
        while(true) {
            synchronized (this) {
                while(buffer.size() == capacity)
                    wait();

                System.out.println("Produced Value : " + value);

                buffer.add(value++);
                notify();

                Thread.sleep(1000);
            }
        }
    }

    public void consume() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (buffer.size() == 0)
                    wait();

                int val = buffer.removeFirst();
                System.out.println("Consumed value : "+val);

                notify();
                Thread.sleep(1000);
            }
        }
    }

    public static void main(String[] args)
            throws InterruptedException
    {
        // Object of a class that has both produce()
        // and consume() methods
        final ProducerConsumerWaitNotify pc = new ProducerConsumerWaitNotify();

        // Create producer thread
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.produce();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Create consumer thread
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run()
            {
                try {
                    pc.consume();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        // Start both threads
        t1.start();
        t2.start();

        // t1 finishes before t2
        t1.join();
        t2.join();
    }
}
