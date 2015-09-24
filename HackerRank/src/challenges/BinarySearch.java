package challenges;

import java.util.Scanner;

/**
 * Created by ashankar1 on 4/9/15.
 */
public class BinarySearch {
    public static void mainSearch(String[] args){
        Scanner in = new Scanner(System.in);
        int V = in.nextInt();
        int n = in.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = in.nextInt();
        }
        int pos = binarySearch(arr,0,n-1,V);
        System.out.println(pos);
    }

    private static int binarySearch(int[] arr,int low, int high, int key){
        int mid = (low+high)/2;
        if(low > high)
            return -1;
        if(arr[mid] == key)
            return mid;
        if(key < arr[mid])
            return binarySearch(arr,low,mid-1,key);
        else
            return binarySearch(arr,mid+1,high,key);

    }
}

/*
This is a simple challenge to get things started. Given a sorted array (ar) and a number (V),
can you print the index location of V in the array?

{The next section describes the input format. You can often skip it, if you are using included methods. }

Input Format
There will be three lines of input:

V - the value that has to be searched.
n - the size of the array.
ar - n numbers that makes up the array.
Output Format
Output the index of V in the array.

{The next section describes the constraints and ranges of the input. You should check this section to know the range of the input. }

Constraints
1<=n<=1000
-1000 <=x <= 1000 , x belongs to ar

{This "sample" shows the first input test case. It is often useful to go through the sample to understand a challenge. }

Sample Input

4
6
1 4 5 7 9 12
Sample Output

1
Explanation
V = 4. The 4 is located in the 1st spot on the array, so the answer is 1.
 */

//NO PATH