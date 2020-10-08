package semaphore;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-08
 */
class Philosopher implements Runnable {

    private Object leftFork;
    private Object rightFork;

    public Philosopher(Object leftFork, Object rightFork) {
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    @Override
    public void run() {
        try {
            while (true) {
                doAction(System.nanoTime() + " : Thinking");
                synchronized (leftFork) {
                    doAction(System.nanoTime() + " : Picked up left fork");
                    synchronized (rightFork) {
                        doAction(System.nanoTime() + " : Picked up right fork - Eating");
                        doAction(System.nanoTime() + " : Put down right fork - Finished Eating");
                    }

                    doAction(System.nanoTime() + " : Put down left fork");
                }
            }
        }catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

    private void doAction(String action) throws InterruptedException {
        System.out.println(
                Thread.currentThread().getName() + " " + action);
        Thread.sleep(((int) (Math.random() * 100)));
    }
}
public class DiningPhilosopher {
    public static void main(String[] args) {
        Philosopher[] philosophers = new Philosopher[5];
        Object[] forks = new Object[philosophers.length];
        for (int i = 0; i < forks.length; i++) {
            forks[i] = new Object();
        }

        for (int i = 0; i < philosophers.length; i++) {
            Object leftFork = forks[i];
            Object rightFork = forks[(i + 1) % forks.length];

            philosophers[i] = new Philosopher(leftFork, rightFork);

            Thread t
                    = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}
