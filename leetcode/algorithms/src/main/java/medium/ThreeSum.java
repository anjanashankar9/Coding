package medium;

import java.util.*;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-21
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if(nums == null || nums.length<3) {
            return result;
        }
        Arrays.sort(nums);

        for(int i=0; i<nums.length-2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int val = 0 - nums[i];

                //find 2 numbers that have the sum val1;
                int j = i + 1;
                int k = nums.length - 1;

                while (j < k) {
                    if (nums[j] + nums[k] == val) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        while (j < k && nums[j] == nums[j + 1]) j++;
                        while (j < k && nums[k] == nums[k - 1]) k--;
                        j++;
                        k--;
                    } else if (nums[j] + nums[k] < val) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {-1,0,1,2,-1,-4};
        int[] nums2 = {};
        int[] nums3 = {0};
        int[] nums4 = {-2,0,1,1,2};
        int[] nums5 = {0,0,0,0};


//        System.out.println(new ThreeSum().threeSum(nums1));
//        System.out.println(new ThreeSum().threeSum(nums2));
//        System.out.println(new ThreeSum().threeSum(nums3));
        System.out.println(new ThreeSum().threeSum(nums4));
//        System.out.println(new ThreeSum().threeSum(nums5));
    }
}

/*
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Notice that the solution set must not contain duplicate triplets.



Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []


Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */

//https://leetcode.com/problems/3sum/
