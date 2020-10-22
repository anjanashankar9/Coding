package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-22
 */
public class KSum {

    public List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> result = new ArrayList<>();
        /*
        1. If k elements do not exist from this point on,
        we do not have a solution.
        2. If the smallest value times k is greater than target,
        we cannot have a solution.
        3. If the largest value times k is smaller than target,
        we cannot have a solution.
         */
        if (start == nums.length || (nums[start] * k) > target || target > (nums[nums.length - 1] * k))
            return result;

        // Base Case
        if (k == 2)
            return twoSum(nums, target, start);
        for (int i = start; i < nums.length; ++i)
            if (i == start || nums[i - 1] != nums[i]) //skipping duplicate elements
                for (List<Integer> set : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    result.add(new ArrayList<>(Arrays.asList(nums[i])));
                    result.get(result.size() - 1).addAll(set);
                }
        return result;
    }

    //Base Case for K Sum
    private List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();

        HashSet<Integer> set = new HashSet<>();

        for(int i=start; i<nums.length; i++) {
            if (result.isEmpty() ||
                    result.get(result.size() - 1).get(1) != nums[i])
                if (set.contains(target - nums[i]))
                    result.add(Arrays.asList(target - nums[i], nums[i]));
            set.add(nums[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        int k = 4;
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;

        List<List<Integer>> result = new KSum().kSum(nums, target, 0, k);
        for(List<Integer> r : result) {
            System.out.print("[");
            for(Integer i : r) {
                System.out.print(i+",");
            }

            System.out.println("]");
        }

    }
}

/*
Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Notice that the solution set must not contain duplicate quadruplets.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [], target = 0
Output: []


Constraints:

0 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
 */

//https://leetcode.com/problems/4sum/
