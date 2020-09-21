package stacks_and_queues;


import java.util.Scanner;
import java.util.Stack;

public class LargestRectangle {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
        long maxRect = 0;

        Stack<Integer> s = new Stack<>();

        for (int i=0; i<h.length; i++) {
            /* if this building has a height > previous building,
             the previous building can be included in an area with
             this building.
             Keep pushing till you find a smaller bar.
             */
            if (s.empty() || h[i]>=h[s.peek()]) {
                s.push(i);
            }
            else {
                /*
                Once you find such a building that is lower,
                keep popping from stack till you find the previous
                lower building stop
                 */
                while(!s.empty() && h[s.peek()] > h[i]) {
                    int tp = s.pop();
                    int j = !s.empty() ? s.peek() : -1;
                    /*
                    Calculate the area with the height of the building at the
                    top of the stack.
                     */
                    int area = h[tp] * (i-j-1);
                    if (maxRect < area) {
                        maxRect = area;
                    }
                }

                s.push(i);
            }

        }

        int i = h.length;
        while(!s.empty()) {
            int tp = s.pop();
            int j = !s.empty() ? s.peek() : -1;
            int area = h[tp] * (i-j-1);
            if (maxRect < area) {
                maxRect = area;
            }
        }

        return maxRect;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void largestRectangle(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        System.out.println(result);

        scanner.close();
    }
}

/*
Skyline Real Estate Developers is planning to demolish a number of old, unoccupied buildings and construct a shopping mall in their place. Your task is to find the largest solid area in which the mall can be constructed.

There are a number of buildings in a certain two-dimensional landscape. Each building has a height, given by . If you join  adjacent buildings, they will form a solid rectangle of area .

For example, the heights array . A rectangle of height  and length  can be constructed within the boundaries. The area formed is .

Function Description

Complete the function largestRectangle int the editor below. It should return an integer representing the largest rectangle that can be formed within the bounds of consecutive buildings.

largestRectangle has the following parameter(s):

h: an array of integers representing building heights
Input Format

The first line contains , the number of buildings.
The second line contains  space-separated integers, each representing the height of a building.

Constraints

Output Format

Print a long integer representing the maximum area of rectangle formed.

Sample Input

5
1 2 3 4 5
Sample Output

9
Explanation

An illustration of the test case follows.
 */

//https://www.hackerrank.com/challenges/largest-rectangle/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=stacks-queues