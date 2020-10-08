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
