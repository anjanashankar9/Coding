/*
Goal: To find the maximum sum in any subarray of the given array.
-2 -3 4 -1 -2 1 5 -3
Maximum Contiguous subarray
4 -1 -2 1 5 -3
Sum = 9
 */

public class MaximumSumSubarray {

    //Brute Force - O(n*n*n)
    public static int bruteForce(int[] arr) {
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


    public static void maximumSumSubarray(String[] args) {
        int []input = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        int result = bruteForce(input);
        System.out.println(result);
    }
}
