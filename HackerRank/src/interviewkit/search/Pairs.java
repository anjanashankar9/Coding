package interviewkit.search;


import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Pairs {

    // Complete the pairs function below.
    //O(n*n) solution
    static int pairs(int k, int[] arr) {
        int pairs  = 0;
        for (int i=0; i<arr.length; i++) {
            for (int j=i+1; j<arr.length; j++) {
                if (Math.abs(arr[i] - arr[j]) == k){
                    pairs++;
                }
            }
        }
        return pairs;
    }

    //O(n) solution
    static int pairs2(int k, int[] arr) {
        int pairs  = 0;
        HashSet<Integer> count = new HashSet<>();

        for (int i=0; i<arr.length; i++) {
            int value = k + arr[i];
            if (count.contains(value)) {
                pairs++;
            }
            value = arr[i] - k ;
            if (count.contains(value)) {
                pairs++;
            }

            count.add(arr[i]);
        }
        return pairs;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void pairs(String[] args) {

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs2(k, arr);

        System.out.println(result);

        scanner.close();
    }
}


/*
You will be given an array of integers and a target value. Determine the number of pairs of array elements that have a difference equal to a target value.

For example, given an array of [1, 2, 3, 4] and a target value of 1, we have three values meeting the condition: , , and .

Function Description

Complete the pairs function below. It must return an integer representing the number of element pairs having the required difference.

pairs has the following parameter(s):

k: an integer, the target difference
arr: an array of integers
Input Format

The first line contains two space-separated integers  and , the size of  and the target value.
The second line contains  space-separated integers of the array .

Constraints

each integer  will be unique
Output Format

An integer representing the number of pairs of integers whose difference is .

Sample Input

5 2
1 5 3 4 2
Sample Output

3
Explanation

There are 3 pairs of integers in the set with a difference of 2: [5,3], [4,2] and [3,1] .
 */
//https://www.hackerrank.com/challenges/pairs/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search