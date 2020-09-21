package arrays;

public class MinimumSwaps {

    // Selection sort sorts the array in minimum number of swaps.
    // O(n square) solution
    static int minimumSwaps(int[] arr) {

        int minSwaps = 0;
        int n = arr.length;

        for (int i=0;i<n;i++) {
            int min = i;
            for (int j=i+1;j<n;j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;

                minSwaps++;
            }
        }
        return minSwaps;
    }

    // O(n log n) solution
    static int minimumSwaps2(int[] arr) {
        int minSwaps = 0;
        int n = arr.length;

        /* We will utilise the fact that we have consecutive integers
        from 1 to n. If we do not have the right element at i, that means
        the element at arr[i] is also wrong. You keep doing this till you are
        able to find the array.
         */
        for (int i=0;i<n;i++) {
            if (i < arr[i] + 1) {
                //swap with the right position of this.
                int temp = arr[arr[i]-1];
                arr[arr[i]-1] = arr[i];
                arr[i] = temp;
                minSwaps++;
                //we should again check this position, because it may
                // happen that the right element did not come to its position
                i--;
            }

        }
        return minSwaps;
    }


    public static void minimumSwaps(String[] args) {

        int arr[] = {4, 3, 1, 2};

        int res = minimumSwaps2(arr);

        System.out.println(res);
    }
}

/*
You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.

For example, given the array  we perform the following steps:

i   arr                         swap (indices)
0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
5   [1, 2, 3, 4, 5, 6, 7]
It took  swaps to sort the array.

Function Description

Complete the function minimumSwaps in the editor below. It must return an integer representing the minimum number of swaps to sort the array.

minimumSwaps has the following parameter(s):

arr: an unordered array of integers
Input Format

The first line contains an integer, , the size of .
The second line contains  space-separated integers .

Constraints

Output Format

Return the minimum number of swaps to sort the given array.

Sample Input 0

4
4 3 1 2
Sample Output 0

3
Explanation 0

Given array
After swapping  we get
After swapping  we get
After swapping  we get
So, we need a minimum of  swaps to sort the array in ascending order.

Sample Input 1

5
2 3 4 1 5
Sample Output 1

3
Explanation 1

Given array
After swapping  we get
After swapping  we get
After swapping  we get
So, we need a minimum of  swaps to sort the array in ascending order.

Sample Input 2

7
1 3 5 2 4 6 7
Sample Output 2

3
Explanation 2

Given array
After swapping  we get
After swapping  we get
After swapping  we get
So, we need a minimum of  swaps to sort the array in ascending order.
 */

//https://www.hackerrank.com/challenges/minimum-swaps-2/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays