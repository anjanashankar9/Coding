# Semaphores
A sempahore is an integer variable that can be accessed only through 2 standard operations.
wait() and signal()
The wait() operation reduces the value of semaphore by 1 and
the signal() operation increases the value of semaphore by 1.

There are 2 types of semaphores:
1. <b>Binary Semaphore</b><br>
    Similar to Mutex. Can have only 2 values, 0 and 1. Its value is initialized to 1.
    Used to implement the solution of critical section problem with multiple processes.
2. <b>Counting Semaphore</b><br>
    It can have a value over a range. It is used to control access to a resource that has 
    multiple instances.    
    
Reference: https://www.geeksforgeeks.org/producer-consumer-problem-using-semaphores-set-1/?ref=rp

## Producer Consumer Problem
We have a buffer of fixed size. The producer can produce an item and place in the buffer.
A consumer can pick items and consume them. 
We need to ensure that when the producer is producing an item, then the consumer should not be consuming an item.
i.e. buffer is the critical section.

Solved this using 2 approaches.
1. A wait notify mechanism.
You can find the code <a href="ProducerConsumerWaitNotify.java">here</a>.

2. Semaphores.
Semaphores are not inherently thread safe. Hence the critical resource synchronization needs to be 
taken care of by the code.
You can find the code <a href="ProducerConsumerSemaphore.java">here</a>.

## Dining Philosopher's Problem
 There are five silent philosophers (P1 – P5) sitting around a circular table, spending their lives eating and thinking.
 There are five forks for them to share (1 – 5) and to be able to eat,
 a philosopher needs to have forks in both his hands.
 After eating, he puts both of them down and then they can be
 picked by another philosopher who repeats the same cycle.
 
 The goal is to come up with a scheme/protocol that helps the
 philosophers achieve their goal of eating and thinking without
 getting starved to death.
 
 #### Solution 1: Potential deadlock.
 Find the code <a href="DiningPhilosopher.java">here</a>.
 This can potentially run into deadlock.
 Explanation:
 Each of the philosopher has acquired his left fork, but can't acquire his right 
 fork, because his neighbour has already acquired it. This situation is commonly
 known as `circular wait`. This is one of the condition that results in a deadlock.  
 
 #### Solution 2: Resolve Deadlock
 The primary reason of deadlock is the circular wait condition where each process
 waits upon a resource that's being held by some other process. We need to break this
 circular wait condition to be able to avoid deadlock.
 The simplest way to do this is by asking all except one of the philosopher to pick 
 up the left fork first. This one philosopher should pick up the right fork first.
 
 You can find the code <a href="DiningPhilosopherDeadlockResolved.java">here</a>.
 
 Reference: https://www.baeldung.com/java-dining-philoshophers
    
 