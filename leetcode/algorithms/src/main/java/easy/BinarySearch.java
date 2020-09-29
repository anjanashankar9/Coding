package easy;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-29
 */
public class BinarySearch {

    private int search(int[] arr, int target) {
        return search(arr, 0, arr.length-1, target);

    }

    private int search(int[] arr, int low, int high, int target) {
        int mid = (low+high)/2;
        if(arr[mid] == target)
            return mid;
        if(low >= high)
            return -1;
        if(arr[mid] < target) {
            return search(arr, mid+1, high, target);
        }
        else
            return search(arr, low, mid-1, target);
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,9,12};
        int result = new BinarySearch().search(arr, 2);
        System.out.println(result);
    }
}

/*
Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search target in nums. If target exists, then return its index, otherwise return -1.


Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1


Note:

You may assume that all elements in nums are unique.
n will be in the range [1, 10000].
The value of each element in nums will be in the range [-9999, 9999].
 */