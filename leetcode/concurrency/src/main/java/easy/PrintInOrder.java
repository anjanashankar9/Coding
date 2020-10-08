package easy;

class Foo {
    public int count;

    public Foo() {
        this.count = 1;

    }

    synchronized public void first(Runnable printFirst) throws InterruptedException {
        while(count != 1) wait();

        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        this.count++;
        notifyAll();
    }

    synchronized public void second(Runnable printSecond) throws InterruptedException {
        while(count != 2) wait();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        this.count++;
        notifyAll();
    }

    synchronized public void third(Runnable printThird) throws InterruptedException {
        while(count != 3) wait();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        this.count++;
        notifyAll();
    }
}

public class PrintInOrder {
    public static void main(String[] args) {
        Foo instance = new Foo();

        Thread t1 = new Thread() {
            public void run() {
                Runnable printFirst = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("first");
                    }
                };
                try {
                    instance.first(printFirst);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted: moving on");
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                Runnable printSecond = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("second");
                    }
                };
                try {
                    instance.second(printSecond);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted: moving on");
                }
            }
        };

        Thread t3 = new Thread() {
            public void run() {
                Runnable printThird = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("third");
                    }
                };
                try {
                    instance.third(printThird);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted: moving on");
                }
            }
        };

        t1.start();
        t3.start();
        t2.start();
    }

}
/*
Suppose we have a class:

public class Foo {
  public void first() { print("first"); }
  public void second() { print("second"); }
  public void third() { print("third"); }
}
The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().



Example 1:

Input: [1,2,3]
Output: "firstsecondthird"
Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
Example 2:

Input: [1,3,2]
Output: "firstsecondthird"
Explanation: The input [1,3,2] means thread A calls first(), thread B calls third(), and thread C calls second(). "firstsecondthird" is the correct output.


Note:

We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seems to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.


 */

//https://leetcode.com/problems/print-in-order/