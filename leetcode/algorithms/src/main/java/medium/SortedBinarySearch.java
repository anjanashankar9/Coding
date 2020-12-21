package medium;

/**
 * @Author Anjana Shankar
 * @Created 2020-12-21
 */
public class SortedBinarySearch {
    public int search(int[] nums, int target) {
        return search(nums, target, 0 , nums.length-1);
    }

    private int search(int[] nums, int target, int start, int end) {
        if(start > end)
            return -1;

        int mid = (start+end)/2;

        if(nums[mid] == target)
            return mid;

        if(nums[start] <= nums[mid]) {
            if(nums[start] <= target && nums[mid]> target)
                return search(nums, target, start, mid-1);
            else
                return search(nums, target, mid+1, end);

        }
        if(nums[mid]<= nums[end]) {
            if(nums[mid]<=target && target <= nums[end])
                return search(nums, target, mid+1, end);
            else
                return search(nums, target, start, mid-1);
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,8,1,2,3};
        int target = 8;

        System.out.println(new SortedBinarySearch().search(nums, target));
    }
}

/*
You are given an integer array nums sorted in ascending order, and an integer target.

Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

If target is found in the array return its index, otherwise, return -1.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1


Constraints:

1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
All values of nums are unique.
nums is guranteed to be rotated at some pivot.
-10^4 <= target <= 10^4

 */
//https://leetcode.com/problems/search-in-rotated-sorted-array/