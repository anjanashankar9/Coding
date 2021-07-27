package easy;

import helpers.TreeNode;

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length < 1)
            return null;

        TreeNode root = sortedArrayToBSTHelper(nums, 0, nums.length-1);
        return root;
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int i, int j) {
        if(j<i)
            return null;
        int curr = (i+j)/2;
        TreeNode node = new TreeNode(nums[curr]);
        node.left = sortedArrayToBSTHelper(nums, i, curr-1);
        node.right = sortedArrayToBSTHelper(nums, curr+1, j);
        return node;
    }
}

/*
Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.

A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.



Example 1:


Input: nums = [-10,-3,0,5,9]
Output: [0,-3,9,-10,null,5]
Explanation: [0,-10,5,null,-3,null,9] is also accepted:

Example 2:


Input: nums = [1,3]
Output: [3,1]
Explanation: [1,3] and [3,1] are both a height-balanced BSTs.

 */
