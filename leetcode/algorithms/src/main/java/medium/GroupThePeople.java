package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Anjana Shankar
 * @Created 2020-09-25
 */
public class GroupThePeople {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<Integer>> groups = new HashMap<>();
        for(int i=0; i< groupSizes.length; i++) {
            List<Integer> indexes;
            if(groups.containsKey(groupSizes[i])){
                indexes = groups.get(groupSizes[i]);
            }
            else {
                indexes = new ArrayList<>();
            }
            indexes.add(i);
            groups.put(groupSizes[i], indexes);
        }

        for(Integer i : groups.keySet()) {
            List<Integer> groupSet = groups.get(i);
            for(int j=0; j<groupSet.size(); j+=i) {
                List<Integer> toAdd = new ArrayList<>();
                for(int k=0; k<i; k++) {
                    toAdd.add(groupSet.get(k+j));
                }
                result.add(toAdd);
            }
        }
        return result;
    }

    public static void groupThePeople(String[] args) {
        int[] groupSizes = {3,3,3,3,3,1,3};
        GroupThePeople gp = new GroupThePeople();
        List<List<Integer>> result = gp.groupThePeople(groupSizes);

        for(List<Integer> l : result) {
            for(int i : l) {
                System.out.print(i+ " ");
            }
            System.out.println();
        }

    }
}

/*
There are n people that are split into some unknown number of groups. Each person is labeled with a unique ID from 0 to n - 1.

You are given an integer array groupSizes, where groupSizes[i] is the size of the group that person i is in. For example, if groupSizes[1] = 3, then person 1 must be in a group of size 3.

Return a list of groups such that each person i is in a group of size groupSizes[i].

Each person should appear in exactly one group, and every person must be in a group. If there are multiple answers, return any of them. It is guaranteed that there will be at least one valid solution for the given input.



Example 1:

Input: groupSizes = [3,3,3,3,3,1,3]
Output: [[5],[0,1,2],[3,4,6]]
Explanation:
The first group is [5]. The size is 1, and groupSizes[5] = 1.
The second group is [0,1,2]. The size is 3, and groupSizes[0] = groupSizes[1] = groupSizes[2] = 3.
The third group is [3,4,6]. The size is 3, and groupSizes[3] = groupSizes[4] = groupSizes[6] = 3.
Other possible solutions are [[2,1,6],[5],[0,4,3]] and [[5],[0,6,2],[4,3,1]].
Example 2:

Input: groupSizes = [2,1,3,3,3,2]
Output: [[1],[0,5],[2,3,4]]


Constraints:

groupSizes.length == n
1 <= n <= 500
1 <= groupSizes[i] <= n

 */

//https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/
