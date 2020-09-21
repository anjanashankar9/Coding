package dynamicprogramming;

import java.util.Scanner;

public class MaxArraySum {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {
        int[] dp = new int[arr.length];

        if (arr.length <2)
            return arr[0];

        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);

        for(int i=2; i< arr.length; i++) {
            dp[i] = Math.max(Math.max(arr[i], dp[i-1]), dp[i-2]+arr[i]);
        }

        return dp[arr.length-1];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void maxArraySum(String[] args) {

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        System.out.println(res);

        scanner.close();
    }
}

/*
Given an array of integers, find the subset of non-adjacent elements with the maximum sum. Calculate the sum of that subset.

For example, given an array  we have the following possible subsets:

Subset      Sum
[-2, 3, 5]   6
[-2, 3]      1
[-2, -4]    -6
[-2, 5]      3
[1, -4]     -3
[1, 5]       6
[3, 5]       8
Our maximum subset sum is .

Function Description

Complete the  function in the editor below. It should return an integer representing the maximum subset sum for the given array.

maxSubsetSum has the following parameter(s):

arr: an array of integers
Input Format

The first line contains an integer, .
The second line contains  space-separated integers .

Constraints

Output Format

Return the maximum sum described in the statement.

Sample Input 0

5
3 7 4 6 5
Sample Output 0

13
Explanation 0

Our possible subsets are  and . The largest subset sum is  from subset

Sample Input 1

5
2 1 5 8 4
Sample Output 1

11
Explanation 1

Our subsets are  and . The maximum subset sum is  from the first subset listed.

Sample Input 2

5
3 5 -7 8 10
Sample Output 2

15
Explanation 2

Our subsets are  and . The maximum subset sum is  from the fifth subset listed.
 */

//https://www.hackerrank.com/challenges/max-array-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dynamic-programming
