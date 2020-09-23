package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-23
 */
public class GoodPairs {
    public int numIdenticalPairs(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i= nums.length-1; i>=0; i--) {
            if(map.containsKey(nums[i])) {
                result += map.get(nums[i]);
            }
            else {
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i])+1);
        }
        return result;
    }

    public static void goodPairs(String[] args) {
        int[] nums = {1,2,3,1,1,3};
        GoodPairs gp = new GoodPairs();
        int result = gp.numIdenticalPairs(nums);
        System.out.println(result);
    }
}

/*
    Given an array of integers nums.

A pair (i,j) is called good if nums[i] == nums[j] and i < j.

Return the number of good pairs.



Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
Example 2:

Input: nums = [1,1,1,1]
Output: 6
Explanation: Each pair in the array are good.
Example 3:

Input: nums = [1,2,3]
Output: 0


Constraints:

1 <= nums.length <= 100
1 <= nums[i] <= 100

 */
//https://leetcode.com/problems/number-of-good-pairs/