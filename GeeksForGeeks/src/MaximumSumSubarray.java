/*
Goal: To find the maximum sum in any subarray of the given array.
-2 -3 4 -1 -2 1 5 -3
Maximum Contiguous subarray
4 -1 -2 1 5 -3
Sum = 9
 */

public class MaximumSumSubarray {

    //Brute Force - O(n*n*n)
     static int bruteForce(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            for (int j=i+1; j<=n; j++) {
                int sum = 0;
                for (int k=i; k<j; k++) {
                    sum += arr[k];
                }
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }


    //Almost Brute Force - O(n*n)
     static int orderNSquare(int[] arr) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++) {
            int sum = arr[i];
            if (sum > max) {
                max = sum;
            }
            for (int j=i+1; j<n; j++) {
                sum += arr[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }

    static int maxCrossingSum(int[] arr, int l, int m, int h) {
         int sum = 0;
         int left_sum = Integer.MIN_VALUE;
         for (int i=m; i>=0; i--) {
             sum += arr[i];
             if(sum>left_sum) {
                 left_sum = sum;
             }
         }

         sum = 0;
         int right_sum = Integer.MIN_VALUE;
         for(int i=m+1; i<= h; i++) {
             sum += arr[i];
             if (sum > right_sum) {
                 right_sum = sum;
             }
         }

         return Math.max(
                 left_sum+right_sum, Math.max(
                         left_sum, right_sum
                 )
         );
    }
    static int maximumSumSubarrayDivideAndConquerHelper(int[] arr, int l, int h) {
        //Base case - only one element
        if(l==h)
            return arr[l];

        int m = (l+h)/2;

        /* Return maximum of following three possible cases:
           a) Maximum subarray sum in left half
           b) Maximum subarray sum in right half
           c) Maximum subarray sum such that the subarray crosses the midpoint
        */
        return Math.max(
                Math.max(maximumSumSubarrayDivideAndConquerHelper(arr, l, m),
                        maximumSumSubarrayDivideAndConquerHelper(arr, m+1, h)),
                maxCrossingSum(arr, l, m, h)
        );
    }

    // Divide and Conquer - O(nlogn)
    static int maximumSumSubarrayDivideAndConquer(int[] arr) {
        return maximumSumSubarrayDivideAndConquerHelper(arr, 0, arr.length-1);
    }

    public static void maximumSumSubarray(String[] args) {
        int []input = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        int result = maximumSumSubarrayDivideAndConquer(input);
        System.out.println(result);
    }
}
