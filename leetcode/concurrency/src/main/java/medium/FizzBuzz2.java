package medium;

import java.util.function.IntConsumer;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-11
 */
public class FizzBuzz2 {
    private int n;
    private int count;

    public FizzBuzz2(int n) {
        this.n = n;
        this.count = 1;
    }

    // printFizz.run() outputs "fizz".
    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while(count<n) {
            while(count%3!=0) wait();
            if(count%5 != 0) {
                printFizz.run();
            }
            count++;
            notifyAll();
        }
    }

    // printBuzz.run() outputs "buzz".
    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while(count<n) {
            while(count%5!=0) wait();
            if(count%3 != 0) {
                printBuzz.run();
            }
            count++;
            notifyAll();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while(count<n) {
            while (count%5!=0 || count%3 != 0) wait();
            printFizzBuzz.run();
            count++;
            notifyAll();
        }

    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while(count<n) {
            while (count%3 == 0 || count%5 == 0) wait();

            printNumber.accept(count);
            count++;
            notifyAll();;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FizzBuzz2 fb = new FizzBuzz2(16);

        Runnable rFizz = new Runnable() {
            @Override
            public void run() {
                System.out.print("fizz, ");
            }
        };

        Runnable rBuzz = new Runnable() {
            @Override
            public void run() {
                System.out.print("buzz, ");
            }
        };

        Runnable rFizzbuzz = new Runnable() {
            @Override
            public void run() {
                System.out.print("fizzbuzz, ");
            }
        };

        Thread tFizz = new Thread(){
            public void run() {
                try {
                    fb.fizz(rFizz);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread tBuzz = new Thread(){
            public void run() {
                try {
                    fb.buzz(rBuzz);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread tFizzBuzz = new Thread(){
            public void run() {
                try {
                    fb.fizzbuzz(rFizzbuzz);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread tNumbers = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fb.number(new IntConsumer() {
                        @Override
                        public void accept(int value) {
                            System.out.print(value+", ");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        tFizz.start();
        tBuzz.start();
        tFizzBuzz.start();
        tNumbers.start();

    }
}

/*
Write a program that outputs the string representation of numbers from 1 to n, however:

If the number is divisible by 3, output "fizz".
If the number is divisible by 5, output "buzz".
If the number is divisible by both 3 and 5, output "fizzbuzz".
For example, for n = 15, we output: 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz.

Suppose you are given the following code:

class FizzBuzz {
  public FizzBuzz(int n) { ... }               // constructor
  public void fizz(printFizz) { ... }          // only output "fizz"
  public void buzz(printBuzz) { ... }          // only output "buzz"
  public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz"
  public void number(printNumber) { ... }      // only output the numbers
}
Implement a multithreaded version of FizzBuzz with four threads. The same instance of FizzBuzz will be passed to four different threads:

Thread A will call fizz() to check for divisibility of 3 and outputs fizz.
Thread B will call buzz() to check for divisibility of 5 and outputs buzz.
Thread C will call fizzbuzz() to check for divisibility of 3 and 5 and outputs fizzbuzz.
Thread D will call number() which should only output the numbers.
 */

//https://leetcode.com/problems/fizz-buzz-multithreaded/