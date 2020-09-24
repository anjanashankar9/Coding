package easy;

import java.util.HashMap;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-24
 */
public class SmallerThanCurrentNumber {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result = new int[nums.length];
        int[] count = new int[102];

        for(int i=0; i<nums.length; i++) {
            count[nums[i]+1]++;
        }


        for(int i=1; i<102; i++) {
            count[i] += count[i-1];
        }

        for(int i=0; i< nums.length; i++) {
            result[i] = count[nums[i]];
        }
        return result;
    }

    public static void smallerThanCurrentNumber(String[] args) {
        int[] nums = {8,1,2,2,3};
        SmallerThanCurrentNumber sc = new SmallerThanCurrentNumber();
        int[] result = sc.smallerNumbersThanCurrent(nums);
        for(int i: result) {
            System.out.print(i + " ");
        }
    }
}

/*
Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].

Return the answer in an array.



Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]
Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]


Constraints:

2 <= nums.length <= 500
0 <= nums[i] <= 100
 */
//https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/