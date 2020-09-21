package arrays;

public class NewYearChaos {

    // Complete the minimumBribes function below.
    // O(n square) solution
    // bubble sorting
    static void minimumBribes1(int[] q) {
        int minBribe = 0;
        int n = q.length;

        for (int i=0; i<n-2 ;i++) {
            if (q[i] > i+3 ) {
                System.out.println("Too chaotic");
                return;
            }
        }

        for(int i=0; i<n-1; i++) {
            for(int j=i; j<n-1; j++) {
                if(q[j] > q[j+1]) {
                    int temp = q[j];
                    q[j] = q[j+1];
                    q[j+1] = temp;
                    minBribe++;
                }
            }
        }
        for(int i=0;i<n;i++) {
            System.out.print(q[i] + " ");
        }

        System.out.println(minBribe);


    }

    //O(n) solution
    static void minimumBribes(int[] q) {
        int minBribe = 0;
        int n = q.length;


        for (int i=n-1; i>=0; i--) {
            if (q[i] == i+1) {
                continue;
            }
            if (i-1 >=0 && q[i-1] == i+1) {
                //q[i-1] position must have bribed. Exchange
                int temp = q[i-1];
                q[i-1] = q[i];
                q[i] = temp;
                minBribe++;
            }

            if (i-2 >= 0 && q[i-2] == i+1) {
                int temp = q[i-2];
                q[i-2] = q[i - 1];
                q[i-1] = q[i];
                q[i] = temp;
                minBribe += 2;
            }

            if (q[i] != i+1) {
                System.out.println("Too chaotic");
                return;
            }

        }

        for(int i=0;i<n;i++) {
            System.out.print(q[i] + " ");
        }
        System.out.println();

        System.out.println(minBribe);


    }

    public static void newYEarChaos(String[] args) {
        int n = 5;
        int[] q = {2, 1, 5, 3, 4};
        //int[] q = {1, 2, 5, 3, 7, 8, 6, 4};

        minimumBribes(q);


    }
}

/*
It's New Year's Day and everyone's in line for the Wonderland rollercoaster ride! There are a number of people queued up, and each person wears a sticker indicating their initial position in the queue. Initial positions increment by  from  at the front of the line to  at the back.

Any person in the queue can bribe the person directly in front of them to swap positions. If two people swap positions, they still wear the same sticker denoting their original places in line. One person can bribe at most two others. For example, if and  bribes , the queue will look like this: .

Fascinated by this chaotic queue, you decide you must know the minimum number of bribes that took place to get the queue into its current state!

Function Description

Complete the function minimumBribes in the editor below. It must print an integer representing the minimum number of bribes necessary, or Too chaotic if the line configuration is not possible.

minimumBribes has the following parameter(s):

q: an array of integers
Input Format

The first line contains an integer , the number of test cases.

Each of the next  pairs of lines are as follows:
- The first line contains an integer , the number of people in the queue
- The second line has  space-separated integers describing the final state of the queue.

Constraints

Subtasks

For  score
For  score

Output Format

Print an integer denoting the minimum number of bribes needed to get the queue into its final state. Print Too chaotic if the state is invalid, i.e. it requires a person to have bribed more than  people.

Sample Input

2
5
2 1 5 3 4
5
2 5 1 3 4
Sample Output

3
Too chaotic
Explanation

Test Case 1

The initial state:

pic1(1).png

After person  moves one position ahead by bribing person :

pic2.png

Now person  moves another position ahead by bribing person :

pic3.png

And person  moves one position ahead by bribing person :

pic5.png

So the final state is  after three bribing operations.

Test Case 2

No person can bribe more than two people, so its not possible to achieve the input state.
 */

//https://www.hackerrank.com/challenges/new-year-chaos/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays