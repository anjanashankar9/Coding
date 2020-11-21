package medium;

/**
 * @Author Anjana Shankar
 * @Created 2020-11-21
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        /*
            At every index i, you check if there is a subsequence ending at j
            (j between 0 to i included) that can be increased by including this
            element
            Every index will have a lis of length one atleast, since you can
            always have just that one number
            [10,9] - 1,1
            [10,9,2] - 1,1,1
            [10,9,2,5] - [1,1,1,2] since 2,5 is an increasing subsequence
            [10,9,2,5,3] - [1,1,1,2,2] since 2,3 is an increasing subsequence
            [10,9,2,5,3,7] - [1,1,1,2,2,3] 2,5,7 and 2,3,7 are possibilities
            [10,9,2,5,3,7,101] - [1,1,1,2,2,3, 4] 2,5,7,101 and 2,3,7,101 are possibilities
            [10,9,2,5,3,7,101,18] - [1,1,1,2,2,3, 4, 4] 2,5,7,18 and 2,3,7,18 are possibilities

            max of this is 4.

            Because of the optimal substructure nature of this problem,
            we can use dynamic programming to solve this.

         */

        int[] dp = new int[nums.length];
        for(int i=0; i<nums.length-1; i++) {
            dp[i] = 1;
        }

        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j] && dp[i] < dp[j]+1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = dp[0];
        for(int i=1; i<dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

/*
Given an integer array nums, return the length of the longest strictly increasing subsequence.

A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].



Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1


Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104


Follow up:

Could you come up with the O(n2) solution?
Could you improve it to O(n log(n)) time complexity?
 */

//https://leetcode.com/problems/longest-increasing-subsequence/