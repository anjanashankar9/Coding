package dynamicprogramming;

import java.io.IOException;
import java.util.Scanner;

public class DecibinaryNumbers {

    // Complete the decibinaryNumbers function below.
    static long decibinaryNumbers(long x) {
        long result = 0;
        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void decibinaryNumbers(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            long x = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = decibinaryNumbers(x);

            System.out.println(result);
        }

        scanner.close();
    }
}

/*
Let's talk about binary numbers. We have an -digit binary number, , and we denote the digit at index  (zero-indexed from right to left) to be . We can find the decimal value of  using the following formula:

For example, if binary number , we compute its decimal value like so:

Meanwhile, in our well-known decimal number system where each digit ranges from  to , the value of some decimal number, , can be expanded in the same way:

Now that we've discussed both systems, let's combine decimal and binary numbers in a new system we call decibinary! In this number system, each digit ranges from  to  (like the decimal number system), but the place value of each digit corresponds to the one in the binary number system. For example, the decibinary number  represents the decimal number  because:

Pretty cool system, right? Unfortunately, there's a problem: two different decibinary numbers can evaluate to the same decimal value! For example, the decibinary number  also evaluates to the decimal value :

This is a major problem because our new number system has no real applications beyond this challenge!

Consider an infinite list of non-negative decibinary numbers that is sorted according to the following rules:

The decibinary numbers are sorted in increasing order of the decimal value that they evaluate to.
Any two decibinary numbers that evaluate to the same decimal value are ordered by increasing decimal value, meaning the equivalent decibinary values are strictly interpreted and compared as decimal values and the smaller decimal value is ordered first. For example,  and  both evaluate to . We would order  before  because .
Here is a list of first few decibinary numbers properly ordered:

image

You will be given  queries in the form of an integer, . For each , find and print the the  decibinary number in the list on a new line.

Function Description

Complete the decibinaryNumbers function in the editor below. For each query, it should return the decibinary number at that one-based index.

decibinaryNumbers has the following parameter(s):

x: the index of the decibinary number to return
Input Format

The first line contains an integer, , the number of queries.
Each of the next  lines contains an integer, , describing a query.

Constraints

Subtasks

 for  of the maximum score
 for  of the maximum score
 for  of the maximum score
Output Format

For each query, print a single integer denoting the the  decibinary number in the list. Note that this must be the actual decibinary number and not its decimal value. Use 1-based indexing.

Sample Input 0

5
1
2
3
4
10
Sample Output 0

0
1
2
10
100
Explanation 0

For each , we print the  decibinary number on a new line. See the figure in the problem statement.

Sample Input 1

7
8
23
19
16
26
7
6
Sample Output 1

12
23
102
14
111
4
11
Sample Input 2

10
19
25
6
8
20
10
27
24
30
11
Sample Output 2

102
103
11
12
110
100
8
31
32
5
 */

//https://www.hackerrank.com/challenges/decibinary-numbers/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming