package main.java.algorithms.search.easy;

import java.util.Scanner;

/**
 * Created by ashankar1 on 4/9/15.
 */
public class IceCreamParlor {
    public static void icecreamParlor(){
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int i=0;i<T;i++){
            int M = in.nextInt();
            int N = in.nextInt();
            int[] arr = new int[N];
            for(int j=0;j<N;j++){
                arr[j] = in.nextInt();
            }
            findIndices(M,N,arr);
        }

    }

    private static void findIndices(int m, int n, int[] arr) {
        for(int i=0;i<n-1;i++){
            int searchKey = m - arr[i];
            if(searchKey <0) {
                //System.out.println("Error");
                continue;
            }
            int index = search(i+1,n,arr,searchKey);
            if(index > -1){
                System.out.println(Integer.toString(i+1)+" "+Integer.toString(index+1));
                break;
            }
        }
    }

    private static int search(int l, int h, int[] arr, int searchkey) {
        for(int j=l;j<h;j++){
            if(arr[j] == searchkey){
                return j;
            }
        }
        return -1;
    }
}

/*
Sunny and Johnny together have M dollars they want to spend on ice cream.
The parlor offers N flavors, and they want to choose two flavors so that they end up spending the whole amount.

You are given the cost of these flavors. The cost of the ith flavor is denoted by ci.
You have to display the indices of the two flavors whose sum is M.

Input Format

The first line of the input contains T; T test cases follow.
Each test case follows the format detailed below: The first line contains M. The second line contains N.
The third line contains N space-separated integers denoting the price of each flavor. Here, the ith integer denotes ci.

Output Format

Output two integers, each of which is a valid index of a flavor. The lower index must be printed first. Indices are indexed from 1 to N.

Constraints

1≤T≤50
2≤M≤10000
2≤N≤10000
1≤ci ≤10000,where i∈[1,N]
The prices of any two items may be the same and each test case has a unique solution.

Sample Input

2
4
5
1 4 5 3 2
4
4
2 2 4 3
Sample Output

1 4
1 2
Explanation

The sample input has two test cases.
For the 1st, the amount M = 4 and there are 5 flavors at the store. The flavors indexed at 1 and 4 sum up to 4.
For the 2nd test case, the amount M = 4 and the flavors indexed at 1 and 2 sum up to 4.
 */
//https://www.hackerrank.com/challenges/icecream-parlor
