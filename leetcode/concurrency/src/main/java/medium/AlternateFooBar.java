package medium;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-08
 */

class FooBar {
    private int n;
    private boolean isFoo;

    public FooBar(int n) {
        this.n = n;
        this.isFoo = true;
    }

    public synchronized void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(!isFoo) wait();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            isFoo = false;
            this.notify();
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while(isFoo) wait();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            isFoo = true;
            this.notify();
        }
    }
}

public class AlternateFooBar {
    public static void main(String[] args) {
        FooBar instance = new FooBar(1);

        Thread t1 = new Thread() {
            public void run() {
                Runnable printFoo = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("foo");
                    }
                };
                try {
                    instance.foo(printFoo);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted: moving on");
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                Runnable printBar = new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("bar");
                    }
                };
                try {
                    instance.bar(printBar);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted: moving on");
                }
            }
        };


        t1.start();
        t2.start();
    }

}

/*
Suppose you are given the following code:

class FooBar {
  public void foo() {
    for (int i = 0; i < n; i++) {
      print("foo");
    }
  }

  public void bar() {
    for (int i = 0; i < n; i++) {
      print("bar");
    }
  }
}
The same instance of FooBar will be passed to two different threads. Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.



Example 1:

Input: n = 1
Output: "foobar"
Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
Example 2:

Input: n = 2
Output: "foobarfoobar"
Explanation: "foobar" is being output 2 times.

 */

//https://leetcode.com/problems/print-foobar-alternately/