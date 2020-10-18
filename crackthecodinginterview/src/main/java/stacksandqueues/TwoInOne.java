package stacksandqueues;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-10
 *
 * We can have one stack running from 0 to n-1 for the array,
 * and the other starting at n-1 to 0 for the array.
 * We call the stack full when the array is full;
 */
public class TwoInOne {
    int[] arr;

    TwoInOne(int n) {
        arr = new int[n];
    }

    class Stack {
        int size=0;
        int top;

        Stack(int top) {
            this.top = top;
        }
    }
}

/*
Describe how you could use a single array to implement two stacks.
 */
