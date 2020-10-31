package contest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

/**
 * @Author Anjana Shankar
 * @Created 2020-10-31
 */
public class SortByFrequency {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> count = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            int cnt = frequency.getOrDefault(nums[i], 0);
            if(count.containsKey(cnt)) {
                //Remove from this list
                ArrayList<Integer> removeFrequency = count.getOrDefault(cnt,new ArrayList<>());
                if(removeFrequency.contains(nums[i]))
                    removeFrequency.remove((Integer)nums[i]);
                count.put(cnt, removeFrequency);
            }
            cnt++;
            ArrayList<Integer> addFrequency = count.getOrDefault(cnt,new ArrayList<>());
            addFrequency.add(nums[i]);
            count.put(cnt, addFrequency);
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0)+1);
        }

        int j=0;
        for(Integer i: count.keySet()) {
            ArrayList<Integer> arr = count.get(i);
            Collections.sort(arr, Collections.reverseOrder());
            for(Integer element : arr) {
                for (int k = 0; k < i; k++) {
                    nums[j++] = element;
                }
            }
        }
        return nums;
    }
}

/*
Given an array of integers nums, sort the array in increasing order based on the frequency of the values. If multiple values have the same frequency, sort them in decreasing order.

Return the sorted array.



Example 1:

Input: nums = [1,1,2,2,2,3]
Output: [3,1,1,2,2,2]
Explanation: '3' has a frequency of 1, '1' has a frequency of 2, and '2' has a frequency of 3.
Example 2:

Input: nums = [2,3,1,3,2]
Output: [1,3,3,2,2]
Explanation: '2' and '3' both have a frequency of 2, so they are sorted in decreasing order.
Example 3:

Input: nums = [-1,1,-6,4,5,-6,1,4,1]
Output: [5,-1,4,4,-6,-6,1,1,1]


Constraints:

1 <= nums.length <= 100
-100 <= nums[i] <= 100
 */

//https://leetcode.com/contest/biweekly-contest-38/problems/sort-array-by-increasing-frequency/