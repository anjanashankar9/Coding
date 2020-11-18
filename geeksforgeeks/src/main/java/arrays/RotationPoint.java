package arrays;

/**
 * @Author Anjana Shankar
 * @Created 2020-11-18
 */
public class RotationPoint {
    /*
    O(N) solution or Brute force would be to check each element in the
    array and find the point at which the previous number is greater than the
    next number.

    But since the array is sorted, we can use a modified version of binary
    search to find this point in the array.
    O(log N) solution
     */
    public int getRotationPoint(int[] arr) {
        return getRotationPoint(arr, 0, arr.length-1);
    }

    private int getRotationPoint(int[] arr, int start, int end) {
        if(start > end) {
            return 0; // array is not rotated.
        }



        int mid = (start + end)/2;

        if(mid < end && arr[mid] > arr[mid+1])
            return mid+1;
        if(mid > start && arr[mid] < arr[mid-1])
            return mid;

        if(arr[mid] > arr[start]) {
            return getRotationPoint(arr, mid+1, end);
        }
        else {
            return getRotationPoint(arr, start, mid-1);
        }

    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {15, 18, 20, 23, 6, 12};
        int[] arr3 = {5, 6, 1, 2, 3};
        int[] arr4 = {};

        System.out.println(new RotationPoint().getRotationPoint(arr1));
        System.out.println(new RotationPoint().getRotationPoint(arr2));
        System.out.println(new RotationPoint().getRotationPoint(arr3));
        System.out.println(new RotationPoint().getRotationPoint(arr4));
    }
}

/*
Find the Rotation Count in Rotated Sorted array
Last Updated: 30-10-2020
Consider an array of distinct numbers sorted in increasing order. The array has been rotated (clockwise) k number of times. Given such an array, find the value of k.

Examples:

Input : arr[] = {15, 18, 2, 3, 6, 12}
Output: 2
Explanation : Initial array must be {2, 3,
6, 12, 15, 18}. We get the given array after
rotating the initial array twice.

Input : arr[] = {7, 9, 11, 12, 5}
Output: 4

Input: arr[] = {7, 9, 11, 12, 15};
Output: 0
 */
