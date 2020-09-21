package search;

import java.util.Scanner;

public class MaximumSumSubarray {

    static long maximumSum(long[] a, long m) {
        // Using Prefix Sum Algorithm - O(n)

        // Find prefix sum %m for each element in the array.
        // Find prefix sum %m for each element in the array.
        long[] prefixSumMod = new long[a.length];
        long result = Long.MIN_VALUE;
        long minPrefixSum = 0;

        prefixSumMod[0] = a[0] % m;
        for (int i=1; i<a.length; i++) {
            prefixSumMod[i] = (prefixSumMod[i-1] + a[i]%m)%m;
        }

        for (int i=0; i<a.length; i++) {
            result = Math.max(result, Math.max(prefixSumMod[i], a[i]%m));
        }

        return result;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void maximumSumSubarray(String[] args) {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);
            System.out.println();
            System.out.println(result);
        }

        scanner.close();
    }
}

/*
We define the following:

A subarray of array  of length  is a contiguous segment from  through  where .
The sum of an array is the sum of its elements.
Given an  element array of integers, , and an integer, , determine the maximum value of the sum of any of its subarrays modulo . For example, Assume  and . The following table lists all subarrays and their moduli:

		sum	%2
[1]		1	1
[2]		2	0
[3]		3	1
[1,2]		3	1
[2,3]		5	1
[1,2,3]		6	0
The maximum modulus is .

Function Description

Complete the maximumSum function in the editor below. It should return a long integer that represents the maximum value of .

maximumSum has the following parameter(s):

a: an array of long integers, the array to analyze
m: a long integer, the modulo divisor
Input Format

The first line contains an integer , the number of queries to perform.

The next  pairs of lines are as follows:

The first line contains two space-separated integers  and (long), the length of  and the modulo divisor.
The second line contains  space-separated long integers .
Constraints

 the sum of  over all test cases
Output Format

For each query, return the maximum value of  as a long integer.

Sample Input

1
5 7
3 3 9 9 5
Sample Output

6
Explanation

The subarrays of array  and their respective sums modulo  are ranked in order of length and sum in the following list:

 and
 and






The maximum value for  for any subarray is .
 */
// https://www.hackerrank.com/challenges/maximum-subarray-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
