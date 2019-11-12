package interviewkit.search;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class TripleSum {

    //TODO: Possible failure incase of dup elements in arr
    static long search(int[] arr, int start, int end, int k) {
        if (start == end) {
            if (arr[start] <= k) {
                return start + 1;
            }
            else
                return 0;
        }

        int mid = (start+end) /2;
        if(arr[mid] == k) {
            return mid+1;
        }

        if (arr[mid] > k) {
            return search(arr,start, mid-1, k);
        }
        else
            return search(arr, mid+1, end, k);
    }

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
        long triplets = 0;

        //Sort the arrays.
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);

        for (int i=0; i< a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();

        for (int i=0; i< b.length; i++) {
            System.out.print(b[i] + " ");
        }
        System.out.println();

        for (int i=0; i< c.length; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println();

        for (int i=0; i< b.length; i++) {
            triplets = triplets + (search(a, 0, a.length-1, b[i]) *
                    search(c, 0, c.length-1, b[i]) );
        }


        return triplets;

    }


    public static void tripleSum(String[] args) {

        int lena = 3;

        int lenb = 2;

        int lenc = 3;

        int[] arra = {1,3,5};

        int[] arrb = {2,3};

        int[] arrc = {1,2,3};

        long ans = triplets(arra, arrb, arrc);

        System.out.println(ans);
    }
}


/*
Given  arrays  of different sizes, find the number of distinct triplets  where  is an element of , written as , , and , satisfying the criteria: .

For example, given  and , we find four distinct triplets: .

Function Description

Complete the triplets function in the editor below. It must return the number of distinct triplets that can be formed from the given arrays.

triplets has the following parameter(s):

a, b, c: three arrays of integers .
Input Format

The first line contains  integers , the sizes of the three arrays.
The next  lines contain space-separated integers numbering  respectively.

Constraints



Output Format

Print an integer representing the number of distinct triplets.

Sample Input 0

3 2 3
1 3 5
2 3
1 2 3
Sample Output 0

8
Explanation 0

The special triplets are  .

Sample Input 1

3 3 3
1 4 5
2 3 3
1 2 3
Sample Output 1

5
Explanation 1

The special triplets are

Sample Input 2

4 3 4
1 3 5 7
5 7 9
7 9 11 13
Sample Output 2

12
Explanation 2

The special triplets are .
 */
//https://www.hackerrank.com/challenges/triple-sum/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=search
