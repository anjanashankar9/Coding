package miscellaneous;

/**
 * @Author Anjana Shankar
 * @Created 2020-08-23
 */

import java.util.Scanner;

public class MaximumXOR {

    // Complete the maxXor function below.
    static int[] maxXor(int[] arr, int[] queries) {
        // solve here
        int[] maxXor = new int[queries.length];
        for (int i=0; i< queries.length; i++) {
            int maxTillNow = Integer.MIN_VALUE;
            for (int j=0; j<arr.length; j++) {
                int xor = arr[j] ^ queries[i];
                if (xor > maxTillNow) {
                    maxTillNow = xor;
                }
            }
            maxXor[i] = maxTillNow;
        }
        return maxXor;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void maximumXor(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] queries = new int[m];

        for (int i = 0; i < m; i++) {
            int queriesItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            queries[i] = queriesItem;
        }

        int[] result = maxXor(arr, queries);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
        scanner.close();
    }
}


/*
You are given an array  of  elements. A list of integers,  is given as an input, find the maximum value of  for all  , where  represents xor of two elements.

Note that there are multiple test cases in one input file.

For example:







Function Description

Complete the maxXor function in the editor below. It must return an array of integers, each representing the maximum xor value for each element  against all elements of .

maxXor has the following parameter(s):

arr: an array of integers
queries: an array of integers to query
Input Format

The first line contains an integer , the size of the array .

The second line contains  space-separated integers,  from .

The third line contain , the size of the array .

Each of the next  lines contains an integer  where .

Constraints



Output Format

The output should contain  lines with each line representing output for the corresponding input of the testcase.

Sample Input 0

3
0 1 2
3
3
7
2
Sample Output 0

3
7
3
Explanation 0














Sample Input 1

5
5 1 7 4 3
2
2
0
Sample Output 1

7
7
Explanation 1














Sample Input 2

4
1 3 5 7
2
17
6
Sample Output 2

22
7
Explanation 2













 */
//https://www.hackerrank.com/challenges/maximum-xor/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=miscellaneous