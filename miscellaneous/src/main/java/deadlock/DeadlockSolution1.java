package deadlock;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-07
 */
public class DeadlockSolution1 {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run() {
                synchronized (lock1) {
                    System.out.println("Thread 1: Acquired lock1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("Thread 1: Waiting for lock2...");
                    synchronized (lock2) {
                        System.out.println("Thread 1: Holding both lock1 and lock2");
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                synchronized (lock1) {
                    System.out.println("Thread 2: Acquired lock1");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("Thread 2: Waiting for lock2...");
                    synchronized (lock2) {
                        System.out.println("Thread 2: Holding both lock1 and lock2");
                    }
                }
            }
        };

        t1.setName("Thread 1");
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}
