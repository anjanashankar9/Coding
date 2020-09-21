package miscellaneous;

/**
 * @Author Anjana Shankar
 * @Created 2020-08-18
 */

import java.util.Scanner;

public class Primality {

    // Complete the primality function below.
    static String primality(int n) {
        if (n==2 || n==3)
            return "Prime";
        if (n%2 == 0 || n%3 == 0 || n==1)
            return "Not prime";

        int sqrt = (int)Math.ceil(Math.sqrt(n));
        for (int i=5; i<=sqrt+1; i += 2){
            if (n%i == 0)
                return "Not prime";
        }

        return "Prime";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void primality(String[] args) {

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int pItr = 0; pItr < p; pItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            String result = primality(n);

            System.out.println(result);
        }

        scanner.close();
    }
}


/*
A prime is a natural number greater than  that has no positive divisors other than  and itself. Given  integers, determine the primality of each integer and print whether it is Prime or Not prime on a new line.

Note: If possible, try to come up with an  primality algorithm, or see what sort of optimizations you can come up with for an  algorithm. Be sure to check out the Editorial after submitting your code!

Function Description

Complete the primality function in the editor below. It should return Prime if  is prime, or Not prime.

primality has the following parameter(s):

n: an integer to test for primality
Input Format

The first line contains an integer, , denoting the number of integers to check for primality.
Each of the  subsequent lines contains an integer, , the number you must test for primality.

Constraints

Output Format

For each integer, print whether  is Prime or Not prime on a new line.

Sample Input

3
12
5
7
Sample Output

Not prime
Prime
Prime
Explanation

We check the following  integers for primality:

 is divisible by numbers other than  and itself (i.e.: , , , ), so we print Not prime on a new line.
 is only divisible  and itself, so we print Prime on a new line.
 is only divisible  and itself, so we print Prime on a new line.
 */

//https://www.hackerrank.com/challenges/ctci-big-o/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous