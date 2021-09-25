package easy;

import java.util.*;

public class IntersectionTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<nums1.length; i++) {
            set.add(nums1[i]);
        }

        for(int j=0; j<nums2.length; j++) {
            if(set.contains(nums2[j])) {
                result.add(nums2[j]);
                set.remove(nums2[j]);
            }
        }
        int[] res = new int[result.size()];
        for (int k=0; k<result.size(); k++)
            res[k] = result.get(k);
        return res;
    }

    public int[] intersection2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for(int i=0; i<nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0)+1);
        }

        for(int j=0; j<nums2.length; j++) {
            if(map.containsKey(nums2[j])) {
                result.add(nums2[j]);
                map.put(nums2[j], map.get(nums2[j])-1);
                if(map.get(nums2[j]) == 0)
                    map.remove(nums2[j]);
            }
        }
        int[] res = new int[result.size()];
        for (int k=0; k<result.size(); k++)
            res[k] = result.get(k);
        return res;
    }
}



/*
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Explanation: [4,9] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000

 */

/* II
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.



Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.


Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000


Follow up:

What if the given array is already sorted? How would you optimize your algorithm?
What if nums1's size is small compared to nums2's size? Which algorithm is better?
What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 */